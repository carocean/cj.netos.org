package cj.netos.org.ports;

import cj.netos.org.model.OrgLicence;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

@CjOpenports(usage = "运营牌照管理服务")
public interface ILicencePorts extends IOpenportService {
    @CjOpenport(usage = "分页经营牌照。平台和归属的运营才有权限")
    List<OrgLicence> pageLicence(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "机构", name = "organ") String organ,
            @CjOpenportParameter(usage = "权限等级。\n" +
                    "0地商\n" +
                    "1市商\n" +
                    "2运营商", name = "privilegeLevel") int privilegeLevel,
            @CjOpenportParameter(usage = "分页大小", name = "limit") int limit,
            @CjOpenportParameter(usage = "偏移", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "获取经营牌照")
    OrgLicence getLicenceByOrg(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "机构", name = "organ") String organ,
            @CjOpenportParameter(usage = "权限等级。\n" +
                    "0地商\n" +
                    "1市商\n" +
                    "2运营商", name = "privilegeLevel") int privilegeLevel
            ) throws CircuitException;

    @CjOpenport(usage = "获取经营牌照")
    OrgLicence getLicenceByID(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "经营牌照", name = "licenceid") String licenceid
    ) throws CircuitException;

    @CjOpenport(usage = "运营商申请吊销所辖地商的经营牌照")
    void revokeLicenceByIsp(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "经营牌照", name = "licenceid") String licenceid
    ) throws CircuitException;

    @CjOpenport(usage = "平台审批运营商的吊销申请")
    void checkRevokeLicenceByPlatfrom(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "经营牌照", name = "licenceid") String licenceid
    ) throws CircuitException;

    @CjOpenport(usage = "平台直接吊销相应的经营牌照，并发出流程通知")
    void forceRevokeLicenceByPlatform(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "经营牌照", name = "licenceid") String licenceid
    ) throws CircuitException;
}
