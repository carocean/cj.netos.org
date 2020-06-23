package cj.netos.org;

import cj.netos.org.bo.IspApplyBO;
import cj.netos.org.bo.LaApplyBO;
import cj.netos.org.model.OrgLicence;

import java.util.List;

public interface ILicenceService {
    void publishLaLicence(LaApplyBO laApplyBO);

    void publishIspLicence(IspApplyBO ispApplyBO);

    OrgLicence getLicence(String organ, int privilegeLevel);

    void revoke(String organ, int privilegeLevel);

    void revokeById(String licenceid);

    List<OrgLicence> pageLicence( int limit, long offset);

    OrgLicence getlicenceByID(String licenceid);

    List<OrgLicence> pageLicenceByIsp(String isp, int limit, long offset);

    OrgLicence getLicenceByAreaCode(String businessAreaCode, int privilegeLevel);

}
