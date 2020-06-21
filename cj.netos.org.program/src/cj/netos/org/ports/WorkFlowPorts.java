package cj.netos.org.ports;

import cj.netos.org.IWorkflowService;
import cj.netos.org.model.WorkGroup;
import cj.netos.org.model.WorkInst;
import cj.netos.org.model.WorkRecipient;
import cj.netos.org.model.Workflow;
import cj.netos.org.result.WorkGroupRecipients;
import cj.netos.org.result.WorkItem;
import cj.netos.org.util.IdWorker;
import cj.netos.org.util.OrgUtils;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;
import cj.ultimate.util.StringUtil;

import java.util.List;

@CjService(name = "/workflow.ports")
public class WorkFlowPorts implements IWorkflowPorts {
    @CjServiceRef
    IWorkflowService workflowService;

    @Override
    public Workflow createWorkflow(ISecuritySession securitySession, String workflowid, String name, String icon, String note) throws CircuitException {
        Workflow workflow = new Workflow();
        workflow.setCreator(securitySession.principal());
        workflow.setCtime(OrgUtils.dateTimeToMicroSecond(System.currentTimeMillis()));
        workflow.setIcon(icon);
        workflow.setId(StringUtil.isEmpty(workflowid) ? new IdWorker().nextId() : workflowid);
        workflow.setName(name);
        workflow.setNote(note);
        workflowService.addWorkflow(workflow);
        return workflow;
    }

    @Override
    public Workflow getWorkflow(ISecuritySession securitySession, String workflow) throws CircuitException {
        return workflowService.getWorkflow(workflow);
    }

    @Override
    public List<Workflow> pageWorkflow(ISecuritySession securitySession, int limit, long offset) throws CircuitException {
        return workflowService.pageWorkflow(limit, offset);
    }

    @Override
    public WorkItem createWorkInstance(ISecuritySession securitySession, String workflow, String data) throws CircuitException {
        return workflowService.createWorkInstance(securitySession.principal(), workflow, data);
    }

    @Override
    public void updateWorkInstData(ISecuritySession securitySession, String workinst, String data) throws CircuitException {
        WorkItem workItem = workflowService.getMyLastWorkItemOnInstance(securitySession.principal(), workinst);
        if (workItem == null) {
            throw new CircuitException("404", String.format("用户%s没有当前工作项", securitySession.principal()));
        }
        if (workItem.getWorkInst().getIsDone() == 1) {
            throw new CircuitException("500", String.format("当前事件已完成"));
        }
        if (workItem.getWorkEvent().getIsDone() == 1) {
            throw new CircuitException("500", String.format("流程已完成"));
        }
        if (!securitySession.principal().equals(workItem.getWorkEvent().getRecipient())) {
            throw new CircuitException("800", String.format("不是用户的当前工作项，拒绝修改流程数据"));
        }
        workflowService.updateWorkInstData(workinst, data);
    }

    @Override
    public WorkInst getWorkInstance(ISecuritySession securitySession, String workitem) throws CircuitException {
        return workflowService.getWorkInstance(securitySession.principal(), workitem);
    }

    @Override
    public List<WorkInst> pageWorkInst(ISecuritySession securitySession, int limit, long offset) throws CircuitException {
        return workflowService.pageWorkInst(securitySession.principal(), limit, offset);
    }

    @Override
    public List<WorkItem> getAllWorkitem(ISecuritySession securitySession, String workitem) throws CircuitException {
        return workflowService.getAllWorkitem(securitySession.principal(), workitem);
    }

    @Override
    public WorkItem getMyLastWorkItemOnInstance(ISecuritySession securitySession, String workinst) throws CircuitException {
        return workflowService.getMyLastWorkItemOnInstance(securitySession.principal(), workinst);
    }

    @Override
    public WorkItem getMyFirstWorkItemOnInstance(ISecuritySession securitySession, String workinst) throws CircuitException {
        return workflowService.getMyFirstWorkItemOnInstance(securitySession.principal(), workinst);
    }

    @Override
    public List<WorkItem> pageMyWorkItem(ISecuritySession securitySession, int filter, int limit, long offset) throws CircuitException {
        return workflowService.pageMyWorkItem(securitySession.principal(), filter, limit, offset);
    }

    @Override
    public List<WorkItem> pageMyWorkItemOnWorkflow(ISecuritySession securitySession, String workflow, int filter, int limit, long offset) throws CircuitException {
        return workflowService.pageMyWorkItemOnWorkflow(securitySession.principal(), workflow, filter, limit, offset);
    }

    @Override
    public boolean doMyWorkItem(ISecuritySession securitySession, String workinst, String operated,String note, boolean doneWorkInst) throws CircuitException {
        return workflowService.doMyWorkItem(securitySession.principal(), workinst, operated,note, doneWorkInst);
    }

    @Override
    public boolean doMyWorkItem2(ISecuritySession securitySession, String workinst, String operated, String note, boolean doneWorkInst, String data, boolean putonMQHub) throws CircuitException {
        return workflowService.doMyWorkItem2(securitySession.principal(), workinst, operated,note, doneWorkInst,data,putonMQHub);
    }

    @Override
    public void sendMyWorkItem(ISecuritySession securitySession, String workitem, String recipients, String eventCode, String stepName) throws CircuitException {
        workflowService.sendMyWorkItem(securitySession.principal(), workitem, recipients, eventCode, stepName);
    }

    @Override
    public boolean doWorkItemAndSend(ISecuritySession securitySession, String workinst, String operated,String note, String recipients, String eventCode, String stepName) throws CircuitException {
        return workflowService.doWorkItemAndSend(securitySession.principal(), workinst, operated,note, recipients, eventCode, stepName);
    }

    @Override
    public boolean doWorkItemAndSend2(ISecuritySession securitySession, String workinst, String operated, String note, String data, boolean putonMQHub, String recipients, String eventCode, String stepName) throws CircuitException {
        return workflowService.doWorkItemAndSend2(securitySession.principal(), workinst, operated,note,data,putonMQHub, recipients, eventCode, stepName);
    }

    @Override
    public WorkGroup addWorkGroup(ISecuritySession securitySession, String code, String name, String note) throws CircuitException {
        WorkGroup group = new WorkGroup();
        group.setCode(code);
        group.setName(name);
        group.setNote(note);
        group.setCtime(OrgUtils.dateTimeToMicroSecond(System.currentTimeMillis()));
        group.setCreator(securitySession.principal());
        workflowService.addWorkGroup(group);
        return group;
    }

    @Override
    public WorkGroup getWorkGroup(ISecuritySession securitySession, String workgroup) throws CircuitException {
        return workflowService.getWorkGroup(workgroup);
    }

    @Override
    public void removeWorkGroup(ISecuritySession securitySession, String workgroup) throws CircuitException {
        WorkGroup workGroup = workflowService.getWorkGroup(workgroup);
        if (workGroup == null) {
            return;
        }
        if (!workGroup.getCreator().equals(securitySession.principal())) {
            throw new CircuitException("800", String.format("非本人:%s创建的工作组，拒绝访问", securitySession.principal()));
        }
        workflowService.removeWorkGroup(workgroup);
    }

    @Override
    public List<WorkGroup> pageWorkGroup(ISecuritySession securitySession, int limit, long offset) throws CircuitException {
        return workflowService.pageWorkGroup(limit, offset);
    }

    @Override
    public void addWorkRecipient(ISecuritySession securitySession, String workgroup, String person, int sort) throws CircuitException {
        WorkGroup workGroup = workflowService.getWorkGroup(workgroup);
        if (workGroup == null) {
            return;
        }
        if (!workGroup.getCreator().equals(securitySession.principal())) {
            throw new CircuitException("800", String.format("非本人:%s创建的工作组，拒绝访问", securitySession.principal()));
        }
        WorkRecipient recipient = new WorkRecipient();
        recipient.setPerson(person);
        recipient.setSort(sort);
        recipient.setWorkgroup(workgroup);
        workflowService.addWorkRecipient(recipient);
    }

    @Override
    public void removeWorkRecipient(ISecuritySession securitySession, String workgroup, String person) throws CircuitException {
        WorkGroup workGroup = workflowService.getWorkGroup(workgroup);
        if (workGroup == null) {
            return;
        }
        if (!workGroup.getCreator().equals(securitySession.principal())) {
            throw new CircuitException("800", String.format("非本人:%s创建的工作组，拒绝访问", securitySession.principal()));
        }
        workflowService.removeWorkRecipient(workgroup, person);
    }

    @Override
    public boolean existsWorkRecipient(ISecuritySession securitySession, String workgroup, String person) throws CircuitException {
        WorkGroup workGroup = workflowService.getWorkGroup(workgroup);
        if (workGroup == null) {
            return false;
        }
        return workflowService.existsWorkRecipient(workgroup, person);
    }

    @Override
    public WorkGroupRecipients getWorkGroupRecipients(ISecuritySession securitySession, String workgroup) throws CircuitException {
        WorkGroup workGroup = workflowService.getWorkGroup(workgroup);
        if (workGroup == null) {
            return null;
        }
        List<WorkRecipient> recipients = workflowService.getGroupRecipients(workgroup);
        WorkGroupRecipients workGroupRecipients = new WorkGroupRecipients();
        workGroupRecipients.setWorkGroup(workGroup);
        workGroupRecipients.setWorkRecipients(recipients);
        return workGroupRecipients;
    }
}
