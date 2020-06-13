package cj.netos.org.model;

/**
 * Table: workflow
 */
public class Workflow {
    /**
     * Column: id
     */
    private String id;

    /**
     * Column: name
     * Remark: 流程名
     */
    private String name;

    /**
     * Column: icon
     * Remark: 流程的图标
     */
    private String icon;

    /**
     * Column: ctime
     * Remark: 流程的创建时间
     */
    private String ctime;

    /**
     * Column: creator
     * Remark: 流程创建者
     */
    private String creator;

    /**
     * Column: note
     * Remark: 备注
     */
    private String note;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}