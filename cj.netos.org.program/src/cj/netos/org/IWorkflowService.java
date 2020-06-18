package cj.netos.org;

import cj.netos.org.model.WorkGroup;
import cj.netos.org.model.WorkInst;
import cj.netos.org.model.WorkRecipient;
import cj.netos.org.model.Workflow;
import cj.netos.org.result.WorkItem;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

public interface IWorkflowService {
    void addWorkflow(Workflow workflow) throws CircuitException;

    boolean existsWorkFlowName(String name);

    Workflow getWorkflow(String workflow);

    List<Workflow> pageWorkflow(int limit, long offset);


    WorkItem createWorkInstance(String principal, String workflow, String data) throws CircuitException;

    List<WorkItem> pageMyWorkItem(String principal, int filter, int limit, long offset) throws CircuitException;

    boolean doMyWorkItem(String principal, String workinst, String operated, String note, boolean doneWorkInst) throws CircuitException;

    WorkItem getMyLastWorkItemOnInstance(String principal, String workinst);

    WorkItem getMyFirstWorkItemOnInstance(String principal, String workinst);

    long countWorkItem(String workinst);

    void sendMyWorkItem(String principal, String workinst, String recipients,String eventCode,  String stepName) throws CircuitException;

    boolean doWorkItemAndSend(String principal, String workinst, String operated,String note, String recipients, String eventCode, String stepName) throws CircuitException;

    WorkInst getWorkInstance(String principal, String workinst);

    List<WorkItem> getAllWorkitem(String principal, String workinst);

    List<WorkInst> pageWorkInst(String principal, int limit, long offset);

    void addWorkGroup(WorkGroup group);

    WorkGroup getWorkGroup(String workgroup);

    void removeWorkGroup(String workGroup);

    List<WorkGroup> pageWorkGroup(int limit, long offset);

    void addWorkRecipient(WorkRecipient recipient);

    void removeWorkRecipient(String workGroup, String person);

    List<WorkRecipient> getGroupRecipients(String workgroup);

    void updateWorkInstData(String workinst, String data);

    List<WorkItem> pageMyWorkItemOnWorkflow(String principal, String workflow, int filter, int limit, long offset) throws CircuitException;

    boolean existsWorkRecipient(String workgroup, String person);

}
