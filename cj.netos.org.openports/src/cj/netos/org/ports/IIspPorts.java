package cj.netos.org.ports;

import cj.netos.org.bo.IspApplyBO;
import cj.netos.org.model.OrgIsp;
import cj.netos.org.result.OrgLicenceResult;
import cj.netos.org.result.WorkItem;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.PKeyInRequest;
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


    @CjOpenport(usage = "分页运营商及其执照")
    List<OrgLicenceResult> pageIspWithLicence(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "分页大小", name = "limit") int limit,
            @CjOpenportParameter(usage = "偏移", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "获取运营商营业牌照及运营商信息")
    OrgLicenceResult getLicence(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "运营商标识", name = "ispid") String ispid
    ) throws CircuitException;

    @CjOpenport(usage = "公众申请成为运营商。该公众会被作为所有人", command = "post")
    WorkItem applyRegisterByPerson(ISecuritySession securitySession,
                                   @CjOpenportParameter(usage = "注册流程", name = "workflow") String workflow,
                                   @CjOpenportParameter(usage = "运营商申请单", name = "ispApplyBO", in = PKeyInRequest.content, simpleModelFile = "/ispApplyBO.md") IspApplyBO ispApplyBO
    ) throws CircuitException;

    @CjOpenport(usage = "确认付款单")
    WorkItem confirmPayOrder(ISecuritySession securitySession,
                             @CjOpenportParameter(usage = "我的注册流程实例", name = "workinst") String workinst,
                             @CjOpenportParameter(usage = "上传的付款单地址", name = "payEvidence") String payEvidence
    ) throws CircuitException;

    @CjOpenport(usage = "平台审核运营商申请")
    WorkItem checkApplyRegisterByPlatform(ISecuritySession securitySession,
                                          @CjOpenportParameter(usage = "我的注册流程实例", name = "workinst") String workinst,
                                          @CjOpenportParameter(usage = "审查是否通过", name = "checkPass") boolean checkPass
    ) throws CircuitException;

    @CjOpenport(usage = "平台直接吊销运营商牌照")
    void forceRevokeIspByPlatfrom(
            ISecuritySession securitySession,
            String ispid
    ) throws CircuitException;
}
