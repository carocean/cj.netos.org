package cj.netos.org.service;

import cj.netos.org.IWorkflowService;
import cj.netos.org.mapper.*;
import cj.netos.org.model.*;
import cj.netos.org.result.WorkItem;
import cj.netos.org.util.IdWorker;
import cj.netos.org.util.OrgUtils;
import cj.studio.ecm.CJSystem;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.orm.mybatis.annotation.CjTransaction;
import cj.ultimate.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CjBridge(aspects = "@transaction")
@CjService(name = "workflowService")
public class WorkflowService implements IWorkflowService {
    @CjServiceRef(refByName = "mybatis.cj.netos.org.mapper.WorkflowMapper")
    WorkflowMapper workflowMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.org.mapper.WorkInstMapper")
    WorkInstMapper workInstMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.org.mapper.WorkEventMapper")
    WorkEventMapper workEventMapper;

    @CjServiceRef(refByName = "mybatis.cj.netos.org.mapper.WorkGroupMapper")
    WorkGroupMapper workGroupMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.org.mapper.WorkRecipientMapper")
    WorkRecipientMapper workRecipientMapper;

    @CjTransaction
    @Override
    public void addWorkflow(Workflow workflow) throws CircuitException {
        if (existsWorkFlowName(workflow.getName())) {
            throw new CircuitException("500", String.format("工作流名称重复:%s", workflow.getName()));
        }
        workflowMapper.insert(workflow);
    }

    @CjTransaction
    @Override
    public boolean existsWorkFlowName(String name) {
        WorkflowExample example = new WorkflowExample();
        example.createCriteria().andNameEqualTo(name);
        return workflowMapper.countByExample(example) > 0;
    }

    @CjTransaction
    @Override
    public Workflow getWorkflow(String workflow) {
        return workflowMapper.selectByPrimaryKey(workflow);
    }

    @CjTransaction
    @Override
    public List<Workflow> pageWorkflow(int limit, long offset) {
        return workflowMapper.page(limit, offset);
    }

    @CjTransaction
    @Override
    public WorkItem createWorkInstance(String principal, String workflow, String data) throws CircuitException {
        Workflow flow = getWorkflow(workflow);
        if (flow == null) {
            throw new CircuitException("404", String.format("工作流不存在:%s", workflow));
        }
        WorkInst inst = new WorkInst();
        inst.setCreator(principal);
        inst.setCtime(OrgUtils.dateTimeToMicroSecond(System.currentTimeMillis()));
        inst.setData(data);
        inst.setIcon(flow.getIcon());
        inst.setId(new IdWorker().nextId());
        inst.setIsDone(0);
        inst.setName(flow.getName());
        inst.setNote(flow.getNote());
        inst.setWorkflow(flow.getId());
        workInstMapper.insert(inst);

        WorkEvent event = new WorkEvent();
        event.setWorkInst(inst.getId());
        event.setTitle(inst.getName());
        event.setStepNo(0);
        event.setRecipient(principal);
        event.setIsDone(0);
        event.setCode("workInstBegin");
        event.setId(new IdWorker().nextId());
        event.setCtime(OrgUtils.dateTimeToMicroSecond(System.currentTimeMillis()));
        event.setData(data);
        workEventMapper.insert(event);
        return new WorkItem(inst, event);
    }

    @Override
    public List<WorkInst> pageWorkInst(String principal, int limit, long offset) {
        return workInstMapper.page(limit, offset);
    }

    @CjTransaction
    @Override
    public WorkInst getWorkInstance(String principal, String workinst) {
        return workInstMapper.selectByPrimaryKey(workinst);
    }

    @CjTransaction
    @Override
    public List<WorkItem> getAllWorkitem(String principal, String workinst) {
        List<WorkEvent> list = workEventMapper.getAll(workinst);
        WorkInst inst = workInstMapper.selectByPrimaryKey(workinst);
        List<WorkItem> results = new ArrayList<>();
        for (WorkEvent event : list) {
            WorkItem result = new WorkItem();
            result.setWorkEvent(event);
            result.setWorkInst(inst);
            results.add(result);
        }
        return results;
    }

    @CjTransaction
    @Override
    public List<WorkItem> pageMyWorkItem(String principal, int filter, int limit, long offset) throws CircuitException {
        List<WorkEvent> list = null;

        //0为我的待办项；1为我的已办事项；2为我创建的实例的当前事项；3为我参与过的未完成的流程；4为我参与过的已完成的流程
        switch (filter) {
            case 0:
                list = workEventMapper.pageTodoEvents(principal,  limit, offset);
                break;
            case 1:
                list = workEventMapper.pageDoneEvents(principal,limit, offset);
                break;
            case 2:
                list = workEventMapper.pageMyCreateInstEvents(principal,limit, offset);
                break;
            case 3:
                list = workEventMapper.pageMyDoneInstEvents(0,limit, offset);
                break;
            case 4:
                list = workEventMapper.pageMyDoneInstEvents(1,limit, offset);
                break;
            default:
                throw new CircuitException("500", String.format("不支持的过滤条件:%s", filter));
        }
        List<WorkItem> results = new ArrayList<>();
        Map<String, WorkInst> instMap = new HashMap<>();
        for (WorkEvent event : list) {
            WorkItem result = new WorkItem();
            result.setWorkEvent(event);
            WorkInst inst = instMap.get(event.getWorkInst());
            if (inst == null) {
                inst = workInstMapper.selectByPrimaryKey(event.getWorkInst());
                instMap.put(inst.getId(), inst);
            }
            result.setWorkInst(inst);
            results.add(result);
        }
        return results;
    }

    @CjTransaction
    @Override
    public List<WorkItem> pageMyWorkItemOnWorkflow(String principal, String workflow, int filter, int limit, long offset) throws CircuitException {
        List<WorkEvent> list = null;

        //0为未完成；1为已完成；2为所有
        switch (filter) {
            case 0:
                list = workEventMapper.pageTodoEventsOnWorkflow(principal, workflow,  limit, offset);
                break;
            case 1:
                list = workEventMapper.pageDoneEventsOnWorkflow(principal, workflow, limit, offset);
                break;
            default:
                throw new CircuitException("500", String.format("不支持的过滤条件:%s", filter));
        }
        List<WorkItem> results = new ArrayList<>();
        Map<String, WorkInst> instMap = new HashMap<>();
        for (WorkEvent event : list) {
            WorkItem result = new WorkItem();
            result.setWorkEvent(event);
            WorkInst inst = instMap.get(event.getWorkInst());
            if (inst == null) {
                inst = workInstMapper.selectByPrimaryKey(event.getWorkInst());
                instMap.put(inst.getId(), inst);
            }
            result.setWorkInst(inst);
            results.add(result);
        }
        return results;
    }

    @CjTransaction
    @Override
    public WorkItem getMyLastWorkItemOnInstance(String principal, String workinst) {
        WorkEvent event = workEventMapper.getLastWorkEvent(principal, workinst);
        WorkInst inst = workInstMapper.selectByPrimaryKey(workinst);
        return new WorkItem(inst, event);
    }

    @CjTransaction
    @Override
    public WorkItem getMyFirstWorkItemOnInstance(String principal, String workinst) {
        WorkEvent event = workEventMapper.getFirstWorkEvent(principal, workinst);
        WorkInst inst = workInstMapper.selectByPrimaryKey(workinst);
        return new WorkItem(inst, event);
    }

    @CjTransaction
    @Override
    public long countWorkItem(String workinst) {
        WorkEventExample example = new WorkEventExample();
        example.createCriteria().andWorkInstEqualTo(workinst);
        return workEventMapper.countByExample(example);
    }


    @CjTransaction
    @Override
    public boolean doMyWorkItem(String principal, String workinst, String operated, String note, boolean doneWorkInst) throws CircuitException {
        WorkItem workItem = getMyLastWorkItemOnInstance(principal, workinst);
        if (workItem == null || workItem.getWorkEvent() == null) {
            throw new CircuitException("404", String.format("当前工作事件不是我本人"));
        }
        if (workItem.getWorkInst().getIsDone() == 1) {
            throw new CircuitException("500", String.format("工作流：%s 已完成", workItem.getWorkInst().getName()));
        }
        if (workItem.getWorkEvent().getIsDone() == 1) {
            throw new CircuitException("500", String.format("用户%s 的工作事件%s在流程实例%s上已完成", principal, workItem.getWorkEvent().getId(), workinst));
        }
        workEventMapper.done(workItem.getWorkEvent().getId(), operated, OrgUtils.dateTimeToMicroSecond(System.currentTimeMillis()));
        if (doneWorkInst) {
            workInstMapper.done(workinst);
            WorkEvent event = new WorkEvent();
            event.setWorkInst(workinst);
            event.setTitle("结束");
            event.setStepNo(workItem.getWorkEvent().getStepNo() + 1);
            event.setSender(principal);//结束事件收件人为空
            event.setIsDone(1);
            event.setCode("workInstEnd");
            event.setPrevEvent(workItem.getWorkEvent().getId());
            event.setId(new IdWorker().nextId());
            event.setCtime(OrgUtils.dateTimeToMicroSecond(System.currentTimeMillis()));
            event.setDtime(event.getCtime());
            event.setOperated("ok");
            event.setData(workItem.getWorkInst().getData());
            event.setNote(note);
            workEventMapper.insert(event);
            return true;
        }
        return false;
    }

    @CjTransaction
    @Override
    public void sendMyWorkItem(String principal, String workinst, String recipients, String eventCode, String stepName) throws CircuitException {
        WorkItem workItem = getMyLastWorkItemOnInstance(principal, workinst);
        if (workItem == null || workItem.getWorkEvent() == null) {
            throw new CircuitException("404", String.format("当前工作事件不是我本人"));
        }
        if (workItem.getWorkInst().getIsDone() == 1) {
            throw new CircuitException("500", String.format("工作流：%s 已完成", workItem.getWorkInst().getName()));
        }
        if (workItem.getWorkEvent().getIsDone() == 0) {
            throw new CircuitException("500", String.format("用户%s 的工作事件%s在流程实例%s上还未完成", principal, workItem.getWorkEvent().getId(), workinst));
        }
        if (recipients.startsWith("$g.")) {
            String groupCode = recipients.substring(3, recipients.length());
            WorkGroup workGroup = getWorkGroup(groupCode);
            if (workGroup == null) {
                throw new CircuitException("404", String.format("工作组：%s不存在", groupCode));
            }
            List<WorkRecipient> list = getGroupRecipients(groupCode);
            StringBuffer sb = new StringBuffer();
            for (WorkRecipient recipient : list) {
                sb.append(String.format("%s;", recipient.getPerson()));
            }
            recipients = sb.toString();
        }
        String[] arr = recipients.split(";");
        for (String recipient : arr) {
            if (StringUtil.isEmpty(recipient)) {
                continue;
            }
            WorkEvent event = new WorkEvent();
            event.setCtime(OrgUtils.dateTimeToMicroSecond(System.currentTimeMillis()));
            event.setId(new IdWorker().nextId());
            event.setIsDone(0);
            event.setCode(eventCode);
            event.setRecipient(recipient);
            event.setSender(workItem.getWorkEvent().getRecipient());
            event.setPrevEvent(workItem.getWorkEvent().getId());
            event.setStepNo(workItem.getWorkEvent().getStepNo() + 1);
            event.setTitle(stepName);
            event.setWorkInst(workinst);
            event.setData(workItem.getWorkInst().getData());
            workEventMapper.insert(event);
        }
    }

    @CjTransaction
    @Override
    public boolean doWorkItemAndSend(String principal, String workinst, String operated,String note, String recipients, String eventCode, String stepName) throws CircuitException {
        boolean isEnd = doMyWorkItem(principal, workinst, operated, note, false);
        if (isEnd) {
            WorkInst inst = getWorkInstance(principal, workinst);
            CJSystem.logging().warn(getClass(), String.format("不能向后发送，流程实例：%s已结束", inst.getName()));
            return true;
        }
        sendMyWorkItem(principal, workinst, recipients, eventCode, stepName);
        return false;
    }

    @CjTransaction
    @Override
    public void addWorkGroup(WorkGroup group) {
        workGroupMapper.insert(group);
    }

    @CjTransaction
    @Override
    public WorkGroup getWorkGroup(String workgroup) {
        return workGroupMapper.selectByPrimaryKey(workgroup);
    }

    @CjTransaction
    @Override
    public void removeWorkGroup(String workGroup) {
        workGroupMapper.deleteByPrimaryKey(workGroup);
    }

    @CjTransaction
    @Override
    public List<WorkGroup> pageWorkGroup(int limit, long offset) {
        return workGroupMapper.page(limit, offset);
    }

    @CjTransaction
    @Override
    public void addWorkRecipient(WorkRecipient recipient) {
        workRecipientMapper.insert(recipient);
    }

    @CjTransaction
    @Override
    public void removeWorkRecipient(String workGroup, String person) {
        workRecipientMapper.deleteByPrimaryKey(workGroup, person);
    }

    @CjTransaction
    @Override
    public boolean existsWorkRecipient(String workgroup, String person) {
        WorkRecipientExample example = new WorkRecipientExample();
        example.createCriteria().andWorkgroupEqualTo(workgroup).andPersonEqualTo(person);
        return workRecipientMapper.countByExample(example)>0;
    }

    @CjTransaction
    @Override
    public void updateWorkInstData(String workinst, String data) {
        workInstMapper.updateData(workinst, data);
    }

    @CjTransaction
    @Override
    public List<WorkRecipient> getGroupRecipients(String workgroup) {
        WorkRecipientExample example = new WorkRecipientExample();
        example.createCriteria().andWorkgroupEqualTo(workgroup);
        return workRecipientMapper.selectByExample(example);
    }
}
