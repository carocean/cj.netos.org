package cj.netos.org.ports;

import cj.netos.org.IWorkflowService;
import cj.netos.org.model.WorkInst;
import cj.netos.org.model.Workflow;
import cj.netos.org.result.WorkItem;
import cj.netos.org.util.IdWorker;
import cj.netos.org.util.OrgUtils;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;

import java.util.List;

@CjService(name = "/workflow.ports")
public class WorkFlowPorts implements IWorkflowPorts {
    @CjServiceRef
    IWorkflowService workflowService;

    @Override
    public Workflow createWorkflow(ISecuritySession securitySession, String name, String icon, String note) throws CircuitException {
        Workflow workflow = new Workflow();
        workflow.setCreator(securitySession.principal());
        workflow.setCtime(OrgUtils.dateTimeToMicroSecond(System.currentTimeMillis()));
        workflow.setIcon(icon);
        workflow.setId(new IdWorker().nextId());
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
    public WorkInst createWorkInstance(ISecuritySession securitySession, String workflow,String ondoneEventCode, String data) throws CircuitException {
        return workflowService.createWorkInstance(securitySession.principal(), workflow,ondoneEventCode, data);
    }

    @Override
    public WorkInst getWorkInstance(ISecuritySession securitySession, String workitem) throws CircuitException {
        return workflowService.getWorkInstance(securitySession.principal(), workitem);
    }

    @Override
    public List<WorkInst> pageWorkInst(ISecuritySession securitySession, int limit, long offset) throws CircuitException {
        return workflowService.pageWorkInst(securitySession.principal(),limit,offset);
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
    public void doMyWorkItem(ISecuritySession securitySession, String workitem, String operated) throws CircuitException {
        workflowService.doMyWorkItem(securitySession.principal(), workitem, operated);
    }

    @Override
    public void sendMyWorkItem(ISecuritySession securitySession, String workitem, String recipients,String eventCode,  String stepName) throws CircuitException {
        workflowService.sendMyWorkItem(securitySession.principal(), workitem, recipients,eventCode, stepName);
    }

    @Override
    public void doWorkItemAndSend(ISecuritySession securitySession, String workitem, String operated, String recipients,String eventCode,  String stepName) throws CircuitException {
        workflowService.doWorkItemAndSend(securitySession.principal(), workitem, operated, recipients,eventCode, stepName);
    }
}
