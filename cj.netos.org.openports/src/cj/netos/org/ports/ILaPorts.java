package cj.netos.org.ports;

import cj.netos.org.bo.LaApplyBO;
import cj.netos.org.model.OrgLa;
import cj.netos.org.model.OrgLicence;
import cj.netos.org.result.WorkItem;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.PKeyInRequest;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

@CjOpenports(usage = "地商管理服务")
public interface ILaPorts extends IOpenportService {
    @CjOpenport(usage = "获取地商")
    OrgLa getLa(ISecuritySession securitySession,
                @CjOpenportParameter(usage = "地商标识", name = "laid") String laid
    ) throws CircuitException;

    @CjOpenport(usage = "分页地商")
    List<OrgLa> pageLa(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "分页大小", name = "limit") int limit,
            @CjOpenportParameter(usage = "偏移", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "分页运营商所辖的地商")
    List<OrgLa> pageLaOfIsp(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "运营商标识", name = "ispid") String ispid,
            @CjOpenportParameter(usage = "分页大小", name = "limit") int limit,
            @CjOpenportParameter(usage = "偏移", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "公众申请成为地商。该公众会被作为所有人", command = "post")
    WorkItem applyRegisterByPerson(ISecuritySession securitySession,
                                   @CjOpenportParameter(usage = "注册流程", name = "workflow") String workflow,
                                   @CjOpenportParameter(usage = "公司名", name = "laApplyBO", in = PKeyInRequest.content, simpleModelFile = "laApplyBO.md") LaApplyBO laApplyBO
    ) throws CircuitException;

    @CjOpenport(usage = "公众申请成为地商。运营商申批")
    WorkItem reviewByIsp(ISecuritySession securitySession,
                         @CjOpenportParameter(usage = "工作实例", name = "workinst") String workinst
    ) throws CircuitException;

    @CjOpenport(usage = "地商确认付款")
    WorkItem confirmPayOrder(ISecuritySession securitySession,
                             @CjOpenportParameter(usage = "我的注册流程实例", name = "workinst") String workinst,
                             @CjOpenportParameter(usage = "上传的付款单地址", name = "payEvidence") String payEvidence
    ) throws CircuitException;

    @CjOpenport(usage = "公众申请成为地商。平台申批")
    WorkItem checkApplyRegisterByPlatform(ISecuritySession securitySession,
                                          @CjOpenportParameter(usage = "工作实例", name = "workinst") String workinst,
                                          @CjOpenportParameter(usage = "审查确认，true为通过", name = "checkPass") boolean checkPass,
                                          @CjOpenportParameter(usage = "分配的运营商", name = "ispid") String ispid
    ) throws CircuitException;

    @CjOpenport(usage = "获取地商营业牌照")
    OrgLicence getLicence(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "地商标识", name = "laid") String laid
    ) throws CircuitException;

    @CjOpenport(usage = "运营商申请吊销地商牌照")
    WorkItem revokeLaLicenceByIsp(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "注册流程", name = "workflow") String workflow,
            @CjOpenportParameter(usage = "牌照标识", name = "licenceid") String licenceid
    ) throws CircuitException;

    @CjOpenport(usage = "平台批准运营商吊销地商牌照")
    WorkItem checkRevokeLaByPlatfrom(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "工作实例", name = "workinst") String workinst,
            @CjOpenportParameter(usage = "审批是否通过", name = "checkPass") boolean checkPass
    ) throws CircuitException;

    @CjOpenport(usage = "平台直接吊销地商牌照")
    void forceRevokeLaByPlatfrom(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "牌照标识", name = "licenceid") String licenceid
    ) throws CircuitException;
}
