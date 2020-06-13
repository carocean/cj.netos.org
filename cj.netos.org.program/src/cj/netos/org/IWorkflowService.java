package cj.netos.org;

import cj.netos.org.model.WorkInst;
import cj.netos.org.model.Workflow;
import cj.netos.org.result.WorkItem;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

public interface IWorkflowService {
    void addWorkflow(Workflow workflow) throws CircuitException;

    boolean existsWorkFlowName(String name);

    Workflow getWorkflow(String workflow);

    List<Workflow> pageWorkflow(int limit, long offset);


    WorkInst createWorkInstance(String principal, String workflow,String ondoneEventCode, String data) throws CircuitException;

    List<WorkItem> pageMyWorkItem(String principal, int filter, int limit, long offset) throws CircuitException;

    WorkItem doMyWorkItem(String principal, String workitem, String operated) throws CircuitException;

    WorkItem getMyLastWorkItemOnInstance(String principal, String workinst);

    WorkItem getMyFirstWorkItemOnInstance(String principal, String workinst);

    long countWorkItem(String workinst);

    void sendMyWorkItem(String principal, String workitem, String recipients,String eventCode,  String stepName) throws CircuitException;

    void doWorkItemAndSend(String principal, String workitem, String operated, String recipients,String eventCode,  String stepName) throws CircuitException;

    WorkInst getWorkInstance(String principal, String workitem);

    List<WorkItem> getAllWorkitem(String principal, String workitem);

    List<WorkInst> pageWorkInst(String principal, int limit, long offset);

}
