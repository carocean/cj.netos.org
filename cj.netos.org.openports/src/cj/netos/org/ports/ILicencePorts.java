package cj.netos.org.ports;

import cj.netos.org.model.OrgLicence;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.AccessTokenIn;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportAppSecurity;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

@CjOpenports(usage = "运营牌照管理服务")
public interface ILicencePorts extends IOpenportService {
    @CjOpenport(usage = "分页经营牌照。平台和归属的运营才有权限")
    List<OrgLicence> pageLicence(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "分页大小", name = "limit") int limit,
            @CjOpenportParameter(usage = "偏移", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "分页运营商颁发的经营牌照。")
    List<OrgLicence> pageLicenceByIsp(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "运营商标识", name = "isp") String isp,
            @CjOpenportParameter(usage = "分页大小", name = "limit") int limit,
            @CjOpenportParameter(usage = "偏移", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "分页运营商颁发的经营牌照。")
    List<OrgLicence> pageLicenceByIsps(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "运营商标识集合", name = "isps") List<String> isps,
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

    @CjOpenport(usage = "按地区代码获取经营牌照")
    OrgLicence getLicenceByAreaCode(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "经营区域", name = "businessAreaCode") String businessAreaCode,
            @CjOpenportParameter(usage = "权限等级。\n" +
                    "0地商\n" +
                    "1市商\n" +
                    "2运营商", name = "privilegeLevel") int privilegeLevel
    ) throws CircuitException;


    @CjOpenportAppSecurity
    @CjOpenport(usage = "获取平台自运营的营业执照", tokenIn = AccessTokenIn.nope)
    List<OrgLicence> listLicenceOfPlatformSelf(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "分页大小", name = "limit") int limit,
            @CjOpenportParameter(usage = "偏移", name = "offset") long offset
    ) throws CircuitException;
}
