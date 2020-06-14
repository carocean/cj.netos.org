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
    public List<OrgLicence> pageLicence(ISecuritySession securitySession, String organ, int privilegeLevel, int limit, long offset) throws CircuitException {
        return null;
    }

    @Override
    public OrgLicence getLicenceByOrg(ISecuritySession securitySession, String organ, int privilegeLevel) throws CircuitException {
        return null;
    }

    @Override
    public OrgLicence getLicenceByID(ISecuritySession securitySession, String licenceid) throws CircuitException {
        return null;
    }

    @Override
    public void revokeLicenceByIsp(ISecuritySession securitySession, String licenceid) throws CircuitException {

    }

    @Override
    public void checkRevokeLicenceByPlatfrom(ISecuritySession securitySession, String licenceid) throws CircuitException {

    }

    @Override
    public void forceRevokeLicenceByPlatform(ISecuritySession securitySession, String licenceid) throws CircuitException {

    }
}
