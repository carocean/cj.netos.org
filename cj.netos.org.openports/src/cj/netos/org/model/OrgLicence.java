package cj.netos.org.model;

/**
 * Table: org_licence
 */
public class OrgLicence {
    /**
     * Column: id
     * Remark: 牌照标识一般对应地商或运营商id，一对一
     */
    private String id;

    /**
     * Column: title
     * Remark: 对应公司名
     */
    private String title;

    /**
     * Column: operate_period
     * Remark: 经营期限
     */
    private String operatePeriod;

    /**
     * Column: fee
     * Remark: 已交服务费
     */
    private Integer fee;

    /**
     * Column: privilege_level
     * Remark: 权限等级。 0地商 1市商 2运营商
     */
    private Integer privilegeLevel;

    /**
     * Column: bussiness_scop
     * Remark: 经营范围，由平台给地商或运营商填写
     */
    private String bussinessScop;

    /**
     * Column: bussiness_area_title
     * Remark: 经营区域 运营商一般为省，是限制区域经营； 地商的经营区域依赖于运营商经营区域，它的具体区域限制在纹银银行所在地区
     */
    private String bussinessAreaTitle;

    /**
     * Column: bussiness_area_code
     * Remark: 经营区域代码，对应高德地图的行政区代码
     */
    private String bussinessAreaCode;

    /**
     * Column: organ
     * Remark: 关联的机构 根据权限等级分别对应：地商｜市商｜运营商 的标识
     */
    private String organ;

    /**
     * Column: sign_text
     * Remark: 地商签约的数字签名
     */
    private String signText;

    /**
     * Column: state
     * Remark: 0正常经营 1已吊销。 2已删除  说明：牌照为非零的机构会被停止资格
     */
    private Integer state;

    /**
     * Column: pub_time
     * Remark: 颁发日期
     */
    private String pubTime;

    /**
     * Column: end_time
     * Remark: 截止日期
     */
    private String endTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getOperatePeriod() {
        return operatePeriod;
    }

    public void setOperatePeriod(String operatePeriod) {
        this.operatePeriod = operatePeriod == null ? null : operatePeriod.trim();
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public Integer getPrivilegeLevel() {
        return privilegeLevel;
    }

    public void setPrivilegeLevel(Integer privilegeLevel) {
        this.privilegeLevel = privilegeLevel;
    }

    public String getBussinessScop() {
        return bussinessScop;
    }

    public void setBussinessScop(String bussinessScop) {
        this.bussinessScop = bussinessScop == null ? null : bussinessScop.trim();
    }

    public String getBussinessAreaTitle() {
        return bussinessAreaTitle;
    }

    public void setBussinessAreaTitle(String bussinessAreaTitle) {
        this.bussinessAreaTitle = bussinessAreaTitle == null ? null : bussinessAreaTitle.trim();
    }

    public String getBussinessAreaCode() {
        return bussinessAreaCode;
    }

    public void setBussinessAreaCode(String bussinessAreaCode) {
        this.bussinessAreaCode = bussinessAreaCode == null ? null : bussinessAreaCode.trim();
    }

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ == null ? null : organ.trim();
    }

    public String getSignText() {
        return signText;
    }

    public void setSignText(String signText) {
        this.signText = signText == null ? null : signText.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getPubTime() {
        return pubTime;
    }

    public void setPubTime(String pubTime) {
        this.pubTime = pubTime == null ? null : pubTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }
}