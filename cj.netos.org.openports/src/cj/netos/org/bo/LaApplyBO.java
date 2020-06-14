package cj.netos.org.bo;

/**
 * 运营商申请单
 */
public class LaApplyBO {
    String cropName;
    String simpleName;
    String cropCode;
    String licenceSrc;
    String cropLogo;
    String masterPerson;
    String masterRealName;
    String masterPhone;
    String isp;
    int operatePeriod;
    long fee;
    int priviliegeLevel;
    private String bussinessScop;
    private String bussinessAreaTitle;
    private String bussinessAreaCode;
    String organ;
    String signText;
    String payEvidence;

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    public String getPayEvidence() {
        return payEvidence;
    }

    public void setPayEvidence(String payEvidence) {
        this.payEvidence = payEvidence;
    }

    public String getMasterPerson() {
        return masterPerson;
    }

    public void setMasterPerson(String masterPerson) {
        this.masterPerson = masterPerson;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getCropCode() {
        return cropCode;
    }

    public void setCropCode(String cropCode) {
        this.cropCode = cropCode;
    }

    public String getLicenceSrc() {
        return licenceSrc;
    }

    public void setLicenceSrc(String licenceSrc) {
        this.licenceSrc = licenceSrc;
    }

    public String getCropLogo() {
        return cropLogo;
    }

    public void setCropLogo(String cropLogo) {
        this.cropLogo = cropLogo;
    }

    public String getMasterRealName() {
        return masterRealName;
    }

    public void setMasterRealName(String masterRealName) {
        this.masterRealName = masterRealName;
    }

    public String getMasterPhone() {
        return masterPhone;
    }

    public void setMasterPhone(String masterPhone) {
        this.masterPhone = masterPhone;
    }

    public int getOperatePeriod() {
        return operatePeriod;
    }

    public void setOperatePeriod(int operatePeriod) {
        this.operatePeriod = operatePeriod;
    }

    public long getFee() {
        return fee;
    }

    public void setFee(long fee) {
        this.fee = fee;
    }

    public int getPriviliegeLevel() {
        return priviliegeLevel;
    }

    public void setPriviliegeLevel(int priviliegeLevel) {
        this.priviliegeLevel = priviliegeLevel;
    }

    public String getBussinessScop() {
        return bussinessScop;
    }

    public void setBussinessScop(String bussinessScop) {
        this.bussinessScop = bussinessScop;
    }

    public String getBussinessAreaTitle() {
        return bussinessAreaTitle;
    }

    public void setBussinessAreaTitle(String bussinessAreaTitle) {
        this.bussinessAreaTitle = bussinessAreaTitle;
    }

    public String getBussinessAreaCode() {
        return bussinessAreaCode;
    }

    public void setBussinessAreaCode(String bussinessAreaCode) {
        this.bussinessAreaCode = bussinessAreaCode;
    }

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }

    public String getSignText() {
        return signText;
    }

    public void setSignText(String signText) {
        this.signText = signText;
    }

}
