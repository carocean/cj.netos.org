package cj.netos.org.ports;

import cj.netos.org.IIspService;
import cj.netos.org.ILicenceService;
import cj.netos.org.IWorkflowService;
import cj.netos.org.bo.IspApplyBO;
import cj.netos.org.model.OrgIsp;
import cj.netos.org.model.OrgLicence;
import cj.netos.org.model.Workflow;
import cj.netos.org.result.WorkItem;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;
import cj.ultimate.gson2.com.google.gson.Gson;

import java.util.List;

@CjService(name = "/isp.ports")
public class IspPorts implements IIspPorts {
    @CjServiceRef
    IIspService ispService;
    @CjServiceRef
    ILicenceService licenceService;
    @CjServiceRef
    IWorkflowService workflowService;

    @Override
    public OrgIsp getIsp(ISecuritySession securitySession, String ispid) throws CircuitException {
        return ispService.getIsp(ispid);
    }

    @Override
    public List<OrgIsp> pageIsp(ISecuritySession securitySession, int limit, long offset) throws CircuitException {
        return ispService.pageIsp(limit, offset);
    }

    @Override
    public OrgLicence getLicence(ISecuritySession securitySession, String ispid) throws CircuitException {
        return ispService.getLicence(ispid);
    }

    @Override
    public WorkItem applyRegisterByPerson(ISecuritySession securitySession, String workflow, IspApplyBO bo) throws CircuitException {
        Workflow workflow1 = workflowService.getWorkflow(workflow);
        if (workflow1 == null) {
            throw new CircuitException("404", String.format("工作流:%s不存在。", workflow));
        }
        bo.setMasterPerson(securitySession.principal());
        ispService.doRegisterIsp(securitySession.principal(), bo);

        WorkItem workItem = workflowService.createWorkInstance(securitySession.principal(), workflow,  new Gson().toJson(bo));
        workflowService.doWorkItemAndSend(securitySession.principal(), workItem.getWorkInst().getId(), "doRegister", securitySession.principal(), "payConfirm", "付款确认");
        return workItem;
    }

    @Override
    public WorkItem confirmPayOrder(ISecuritySession securitySession, String workinst, String payEvidence) throws CircuitException {
        WorkItem workItem = workflowService.getMyLastWorkItemOnInstance(securitySession.principal(), workinst);
        if (workItem == null || workItem.getWorkEvent() == null) {
            throw new CircuitException("404", String.format("用户:%s当前没有工作事件。", securitySession.principal()));
        }
        String json = workItem.getWorkInst().getData();
        IspApplyBO ispApplyBO = new Gson().fromJson(json, IspApplyBO.class);
        ispApplyBO.setPayEvidence(payEvidence);
        workflowService.updateWorkInstData(workinst, new Gson().toJson(ispApplyBO));
        workflowService.doWorkItemAndSend(securitySession.principal(), workItem.getWorkInst().getId(), "doConfirm", "$g.netos.market.checker", "platformChecker", "平台审核");
        return workItem;
    }

    @Override
    public WorkItem checkApplyRegisterByPlatform(ISecuritySession securitySession, String workinst, boolean checkPass) throws CircuitException {
        WorkItem workItem = workflowService.getMyLastWorkItemOnInstance(securitySession.principal(), workinst);
        if (workItem == null || workItem.getWorkEvent() == null) {
            throw new CircuitException("404", String.format("用户:%s当前没有工作事件。", securitySession.principal()));
        }
        if (checkPass) {
            workflowService.doMyWorkItem(securitySession.principal(), workinst, "adopt", true);
            String json = workItem.getWorkInst().getData();
            IspApplyBO ispApplyBO = new Gson().fromJson(json, IspApplyBO.class);
            licenceService.publishIspLicence(ispApplyBO);
        } else {
            workflowService.doWorkItemAndSend(securitySession.principal(), workinst, "return", workItem.getWorkEvent().getSender(), "return", "退回");
        }
        return workItem;
    }

    @Override
    public void forceRevokeIspByPlatfrom(ISecuritySession securitySession, String ispid) throws CircuitException {
        if (!securitySession.roleIn("platform:administrators")) {
            throw new CircuitException("800",String.format("拒绝访问"));
        }
        licenceService.revoke(ispid,2);
    }
}
