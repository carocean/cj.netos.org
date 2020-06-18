package cj.netos.org.result;

import cj.netos.org.model.OrgIsp;
import cj.netos.org.model.OrgLicence;

public class OrgLicenceResult {
    OrgIsp orgIsp;
    OrgLicence orgLicence;

    public OrgLicenceResult() {
    }

    public OrgLicenceResult(OrgIsp orgIsp, OrgLicence orgLicence) {
        this.orgIsp = orgIsp;
        this.orgLicence = orgLicence;
    }

    public OrgIsp getOrgIsp() {
        return orgIsp;
    }

    public void setOrgIsp(OrgIsp orgIsp) {
        this.orgIsp = orgIsp;
    }

    public OrgLicence getOrgLicence() {
        return orgLicence;
    }

    public void setOrgLicence(OrgLicence orgLicence) {
        this.orgLicence = orgLicence;
    }
}
