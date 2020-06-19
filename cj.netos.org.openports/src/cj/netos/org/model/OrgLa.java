package cj.netos.org.model;

/**
 * Table: org_la
 */
public class OrgLa {
    /**
     * Column: id
     */
    private String id;

    /**
     * Column: corp_name
     * Remark: 公司名
     */
    private String corpName;

    /**
     * Column: corp_code
     * Remark: 营业执照：社会信用代码
     */
    private String corpCode;

    /**
     * Column: corp_simple
     * Remark: 公司简称
     */
    private String corpSimple;

    /**
     * Column: licence_src
     * Remark: 营业执照地址
     */
    private String licenceSrc;

    /**
     * Column: corp_logo
     * Remark: 公司logo
     */
    private String corpLogo;

    /**
     * Column: isp
     * Remark: 归属运营商
     */
    private String isp;

    /**
     * Column: master_person
     * Remark: 业主公号
     */
    private String masterPerson;

    /**
     * Column: master_real_name
     * Remark: 地商业主真实姓名
     */
    private String masterRealName;

    /**
     * Column: master_phone
     * Remark: 地商业主电话
     */
    private String masterPhone;

    /**
     * Column: time
     */
    private String time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName == null ? null : corpName.trim();
    }

    public String getCorpCode() {
        return corpCode;
    }

    public void setCorpCode(String corpCode) {
        this.corpCode = corpCode == null ? null : corpCode.trim();
    }

    public String getCorpSimple() {
        return corpSimple;
    }

    public void setCorpSimple(String corpSimple) {
        this.corpSimple = corpSimple == null ? null : corpSimple.trim();
    }

    public String getLicenceSrc() {
        return licenceSrc;
    }

    public void setLicenceSrc(String licenceSrc) {
        this.licenceSrc = licenceSrc == null ? null : licenceSrc.trim();
    }

    public String getCorpLogo() {
        return corpLogo;
    }

    public void setCorpLogo(String corpLogo) {
        this.corpLogo = corpLogo == null ? null : corpLogo.trim();
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp == null ? null : isp.trim();
    }

    public String getMasterPerson() {
        return masterPerson;
    }

    public void setMasterPerson(String masterPerson) {
        this.masterPerson = masterPerson == null ? null : masterPerson.trim();
    }

    public String getMasterRealName() {
        return masterRealName;
    }

    public void setMasterRealName(String masterRealName) {
        this.masterRealName = masterRealName == null ? null : masterRealName.trim();
    }

    public String getMasterPhone() {
        return masterPhone;
    }

    public void setMasterPhone(String masterPhone) {
        this.masterPhone = masterPhone == null ? null : masterPhone.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }
}