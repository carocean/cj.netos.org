package cj.netos.org.model;

/**
 * Table: work_group
 */
public class WorkGroup {
    /**
     * Column: code
     * Remark: 有语义的收件人集合名称
     */
    private String code;

    /**
     * Column: name
     * Remark: 集合中文名
     */
    private String name;

    /**
     * Column: note
     * Remark: 收件人集合
     */
    private String note;

    /**
     * Column: ctime
     */
    private String ctime;

    /**
     * Column: creator
     * Remark: 创建者
     */
    private String creator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime == null ? null : ctime.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }
}