package cj.netos.org.result;

import cj.netos.org.model.WorkGroup;
import cj.netos.org.model.WorkRecipient;

import java.util.List;

public class WorkGroupRecipients {
    WorkGroup workGroup;
    List<WorkRecipient> workRecipients;

    public WorkGroup getWorkGroup() {
        return workGroup;
    }

    public void setWorkGroup(WorkGroup workGroup) {
        this.workGroup = workGroup;
    }

    public List<WorkRecipient> getWorkRecipients() {
        return workRecipients;
    }

    public void setWorkRecipients(List<WorkRecipient> workRecipients) {
        this.workRecipients = workRecipients;
    }
}
