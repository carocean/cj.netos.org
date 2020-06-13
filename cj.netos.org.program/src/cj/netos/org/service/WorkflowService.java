package cj.netos.org.service;

import cj.netos.org.IWorkflowService;
import cj.netos.org.mapper.WorkEventMapper;
import cj.netos.org.mapper.WorkInstMapper;
import cj.netos.org.mapper.WorkflowMapper;
import cj.netos.org.model.*;
import cj.netos.org.result.WorkItem;
import cj.netos.org.util.IdWorker;
import cj.netos.org.util.OrgUtils;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.orm.mybatis.annotation.CjTransaction;

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
    public WorkInst createWorkInstance(String principal, String workflow, String ondoneEventCode, String data) throws CircuitException {
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
        inst.setOndoneEventCode(ondoneEventCode);
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
        workEventMapper.insert(event);
        return inst;
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

        //0为未完成；1为已完成；2为所有
        switch (filter) {
            case 0:
            case 1:
                list = workEventMapper.pageWithFilter(principal, filter, limit, offset);
                break;
            case 2:
                list = workEventMapper.pageWithoutFilter(principal, limit, offset);
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
    public WorkItem doMyWorkItem(String principal, String workinst, String operated) throws CircuitException {
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
        workEventMapper.done(principal, workinst, operated, OrgUtils.dateTimeToMicroSecond(System.currentTimeMillis()));
        if (workItem.getWorkEvent().getCode().equals(workItem.getWorkInst().getOndoneEventCode())) {
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
            workEventMapper.insert(event);
        }
        return workItem;
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
        String[] arr = recipients.split(";");
        for (String recipient : arr) {
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
            workEventMapper.insert(event);
        }
    }

    @CjTransaction
    @Override
    public void doWorkItemAndSend(String principal, String workinst, String operated, String recipients, String eventCode, String stepName) throws CircuitException {
        WorkItem workItem = doMyWorkItem(principal, workinst, operated);
        if (workItem.getWorkEvent().getCode().equals(workItem.getWorkInst().getOndoneEventCode())) {
            throw new CircuitException("501", String.format("不能向后发送，流程被定义为在事件:%s后结束", workItem.getWorkInst().getOndoneEventCode()));
        }
        sendMyWorkItem(principal, workinst, recipients, eventCode, stepName);
    }
}
