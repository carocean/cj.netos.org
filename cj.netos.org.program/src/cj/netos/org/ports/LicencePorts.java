package cj.netos.org.ports;

import cj.netos.org.ILicenceService;
import cj.netos.org.model.OrgLicence;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;

import java.util.List;

@CjService(name = "/licence.ports")
public class LicencePorts implements ILicencePorts {
    @CjServiceRef
    ILicenceService licenceService;

    @Override
    public List<OrgLicence> pageLicence(ISecuritySession securitySession,  int limit, long offset) throws CircuitException {
        return licenceService.pageLicence(limit,offset);
    }

    @Override
    public List<OrgLicence> pageLicenceByIsp(ISecuritySession securitySession, String isp, int limit, long offset) throws CircuitException {
        return licenceService.pageLicenceByIsp(isp,limit,offset);
    }

    @Override
    public OrgLicence getLicenceByOrg(ISecuritySession securitySession, String organ, int privilegeLevel) throws CircuitException {
        return licenceService.getLicence(organ,privilegeLevel);
    }

    @Override
    public OrgLicence getLicenceByID(ISecuritySession securitySession, String licenceid) throws CircuitException {
        return licenceService.getlicenceByID(licenceid);
    }

    @Override
    public OrgLicence getLicenceByAreaCode(ISecuritySession securitySession, String businessAreaCode,int privilegeLevel) throws CircuitException {
        return licenceService.getLicenceByAreaCode(businessAreaCode,privilegeLevel);
    }
}
