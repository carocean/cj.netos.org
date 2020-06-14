package cj.netos.org.ports;

import cj.netos.org.ILaService;
import cj.netos.org.model.OrgIsp;
import cj.netos.org.model.OrgLa;
import cj.netos.org.model.OrgLicence;
import cj.netos.org.model.WorkEvent;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;

import java.util.List;

@CjService(name = "/la.ports")
public class LaPorts implements ILaPorts {
    @CjServiceRef
    ILaService laService;
    @Override
    public OrgLa getLa(ISecuritySession securitySession, String laid) throws CircuitException {
        return null;
    }

    @Override
    public List<OrgLa> pageLa(ISecuritySession securitySession, int limit, long offset) throws CircuitException {
        return null;
    }

    @Override
    public List<OrgLa> pageLaOfIsp(ISecuritySession securitySession, String ispid, int limit, long offset) throws CircuitException {
        return null;
    }

    @Override
    public WorkEvent applyRegisterByPerson(ISecuritySession securitySession, String cropName, String simpleName, String cropCode, String licenceSrc, String cropLogo, String isp, String masterRealName, String masterPhone) throws CircuitException {
        return null;
    }

    @Override
    public WorkEvent checkApplyRegisterByIsp(ISecuritySession securitySession, String workitem) throws CircuitException {
        return null;
    }

    @Override
    public WorkEvent checkApplyRegisterByPlatform(ISecuritySession securitySession, String workitem) throws CircuitException {
        return null;
    }

    @Override
    public OrgLicence getLicence(ISecuritySession securitySession, String laid) throws CircuitException {
        return null;
    }

    @Override
    public void revokeLaByIsp(ISecuritySession securitySession, String licenceid) throws CircuitException {

    }

    @Override
    public void checkRevokeLaByPlatfrom(ISecuritySession securitySession, String licenceid) throws CircuitException {

    }

    @Override
    public void forceRevokeLaByPlatfrom(ISecuritySession securitySession, String licenceid) throws CircuitException {

    }
}
