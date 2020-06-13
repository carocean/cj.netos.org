package cj.netos.org.ports;

import cj.netos.org.model.OrgIsp;
import cj.netos.org.model.OrgLicence;
import cj.netos.org.model.WorkEvent;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

@CjOpenports(usage = "运营商管理服务")
public interface IIspPorts extends IOpenportService {
    @CjOpenport(usage = "获取运营商")
    OrgIsp getIsp(ISecuritySession securitySession,
                  @CjOpenportParameter(usage = "运营商标识", name = "ispid") String ispid
    ) throws CircuitException;

    @CjOpenport(usage = "分页运营商")
    List<OrgIsp> pageIsp(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "分页大小", name = "limit") int limit,
            @CjOpenportParameter(usage = "偏移", name = "offset") long offset
    ) throws CircuitException;


    @CjOpenport(usage = "获取地商营业牌照")
    OrgLicence getLicence(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "地商标识", name = "laid") String laid
    ) throws CircuitException;

    @CjOpenport(usage = "公众申请成为运营商。该公众会被作为所有人")
    WorkEvent applyRegisterByPerson(ISecuritySession securitySession,
                                    @CjOpenportParameter(usage = "公司名", name = "cropName") String cropName,
                                    @CjOpenportParameter(usage = "公司简称", name = "simpleName") String simpleName,
                                    @CjOpenportParameter(usage = "统一社会信用代码（营业执照上的）", name = "cropCode") String cropCode,
                                    @CjOpenportParameter(usage = "营业执照地址", name = "licenceSrc") String licenceSrc,
                                    @CjOpenportParameter(usage = "公司logo", name = "cropLogo") String cropLogo,
                                    @CjOpenportParameter(usage = "所有人真实名", name = "masterRealName") String masterRealName,
                                    @CjOpenportParameter(usage = "所有人电话", name = "masterPhone") String masterPhone
    ) throws CircuitException;

    @CjOpenport(usage = "平台审核运营商申请")
    WorkEvent checkApplyRegisterByPlatform(ISecuritySession securitySession,
                                           String workitem
    ) throws CircuitException;

    @CjOpenport(usage = "平台直接吊销运营商牌照")
    void forceRevokeIspByPlatfrom(
            ISecuritySession securitySession,
            String ispid
    ) throws CircuitException;
}
