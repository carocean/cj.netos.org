package cj.netos.org.model;

/**
 * Table: work_recipient
 */
public class WorkRecipient {
    /**
     * Column: workgroup
     */
    private String workgroup;

    /**
     * Column: person
     */
    private String person;

    /**
     * Column: sort
     * Remark: 序顺具有发送优先级
     */
    private Integer sort;

    public String getWorkgroup() {
        return workgroup;
    }

    public void setWorkgroup(String workgroup) {
        this.workgroup = workgroup == null ? null : workgroup.trim();
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person == null ? null : person.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}