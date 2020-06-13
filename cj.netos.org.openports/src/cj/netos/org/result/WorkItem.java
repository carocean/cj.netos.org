package cj.netos.org.result;

import cj.netos.org.model.WorkEvent;
import cj.netos.org.model.WorkInst;

public class WorkItem {
    WorkInst workInst;
    WorkEvent workEvent;

    public WorkItem() {
    }

    public WorkItem(WorkInst inst, WorkEvent event) {
        this.workInst = inst;
        this.workEvent = event;
    }

    public WorkInst getWorkInst() {
        return workInst;
    }

    public void setWorkInst(WorkInst workInst) {
        this.workInst = workInst;
    }

    public WorkEvent getWorkEvent() {
        return workEvent;
    }

    public void setWorkEvent(WorkEvent workEvent) {
        this.workEvent = workEvent;
    }
}
