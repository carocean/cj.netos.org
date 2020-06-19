package cj.netos.org.ports;

import cj.netos.org.ILaService;
import cj.netos.org.ILicenceService;
import cj.netos.org.IWorkflowService;
import cj.netos.org.bo.LaApplyBO;
import cj.netos.org.model.*;
import cj.netos.org.result.WorkItem;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;
import cj.ultimate.gson2.com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CjService(name = "/la.ports")
public class LaPorts implements ILaPorts {
    @CjServiceRef
    ILaService laService;
    @CjServiceRef
    ILicenceService licenceService;
    @CjServiceRef
    IWorkflowService workflowService;

    @Override
    public OrgLa getLa(ISecuritySession securitySession, String laid) throws CircuitException {
        return laService.getLa(laid);
    }

    @Override
    public List<OrgLa> pageLa(ISecuritySession securitySession, int limit, long offset) throws CircuitException {
        return laService.pageLa(limit, offset);
    }

    @Override
    public List<OrgLa> pageLaOfIsp(ISecuritySession securitySession, String ispid, int limit, long offset) throws CircuitException {
        return laService.pageLaOfIsp(ispid, limit, offset);
    }

    @Override
    public List<OrgLa> listLaOfMasters(ISecuritySession securitySession, List<String> masters) throws CircuitException {
        return laService.listLaOfMasters(masters);
    }

    @Override
    public WorkItem applyRegisterByPerson(ISecuritySession securitySession, String workflow, LaApplyBO bo) throws CircuitException {
        Workflow flow = workflowService.getWorkflow(workflow);
        if (flow == null) {
            throw new CircuitException("404", String.format("工作流:%s不存在。", workflow));
        }
        bo.setMasterPerson(securitySession.principal());
        laService.doRegisterIsp(securitySession.principal(), bo);

        WorkItem workItem = workflowService.createWorkInstance(securitySession.principal(), workflow, new Gson().toJson(bo));
        workflowService.doWorkItemAndSend(securitySession.principal(), workItem.getWorkInst().getId(), "doRegister", "", securitySession.principal(), "payConfirm", "付款确认");
        return workItem;
    }

    @Override
    public WorkItem reviewByIsp(ISecuritySession securitySession, String workinst) throws CircuitException {
        workflowService.doMyWorkItem(securitySession.principal(), workinst, "reviewed", "", true);
        return null;
    }

    @Override
    public WorkItem confirmPayOrder(ISecuritySession securitySession, String workinst, String payEvidence) throws CircuitException {
        WorkItem workItem = workflowService.getMyLastWorkItemOnInstance(securitySession.principal(), workinst);
        if (workItem == null || workItem.getWorkEvent() == null) {
            throw new CircuitException("404", String.format("用户:%s当前没有工作事件。", securitySession.principal()));
        }
        String json = workItem.getWorkInst().getData();
        LaApplyBO laApplyBO = new Gson().fromJson(json, LaApplyBO.class);
        laApplyBO.setPayEvidence(payEvidence);
        workflowService.updateWorkInstData(workinst, new Gson().toJson(laApplyBO));
        workflowService.doWorkItemAndSend(securitySession.principal(), workItem.getWorkInst().getId(), "doConfirm", "", "$g.netos.market.checker", "platformChecker", "平台审核");
        return workItem;
    }

    @Override
    public WorkItem checkApplyRegisterByPlatform(ISecuritySession securitySession, String workinst, boolean checkPass, String ispid) throws CircuitException {
        WorkItem workItem = workflowService.getMyLastWorkItemOnInstance(securitySession.principal(), workinst);
        if (workItem == null || workItem.getWorkEvent() == null) {
            throw new CircuitException("404", String.format("用户:%s当前没有工作事件。", securitySession.principal()));
        }
        if (checkPass) {
            String json = workItem.getWorkInst().getData();
            LaApplyBO laApplyBO = new Gson().fromJson(json, LaApplyBO.class);
            laApplyBO.setIsp(ispid);
            laService.updateIsp(laApplyBO.getOrgan(),ispid);
            workflowService.updateWorkInstData(workinst, new Gson().toJson(laApplyBO));
            licenceService.publishLaLicence(laApplyBO);
            workflowService.doWorkItemAndSend(securitySession.principal(), workinst, "adopt", "", workItem.getWorkEvent().getSender(), "review", "地商查阅");
        } else {
            workflowService.doWorkItemAndSend(securitySession.principal(), workinst, "return", "", workItem.getWorkEvent().getSender(), "return", "退回");
        }
        return workItem;
    }

    @Override
    public OrgLicence getLicence(ISecuritySession securitySession, String laid) throws CircuitException {
        return licenceService.getLicence(laid, 0);
    }

    @Override
    public WorkItem revokeLaLicenceByIsp(ISecuritySession securitySession, String workflow, String licenceid) throws CircuitException {
        Workflow flow = workflowService.getWorkflow(workflow);
        if (flow == null) {
            throw new CircuitException("404", String.format("工作流:%s不存在。", workflow));
        }
        Map<String, Object> data = new HashMap<>();
        data.put("licenceid", licenceid);
        WorkItem workItem = workflowService.createWorkInstance(securitySession.principal(), workflow, new Gson().toJson(data));
        workflowService.doWorkItemAndSend(securitySession.principal(), workItem.getWorkInst().getId(), "ok", "", "$g.netos.market.checker", "platformCheck", "平台审核");
        return workItem;
    }

    @Override
    public WorkItem checkRevokeLaByPlatfrom(ISecuritySession securitySession, String workinst, boolean checkPass) throws CircuitException {
        WorkItem workItem = workflowService.getMyLastWorkItemOnInstance(securitySession.principal(), workinst);
        if (workItem == null || workItem.getWorkEvent() == null) {
            throw new CircuitException("404", String.format("用户:%s当前没有工作事件。", securitySession.principal()));
        }
        if (checkPass) {
            String json = workItem.getWorkInst().getData();
            HashMap map = new Gson().fromJson(json, HashMap.class);
            licenceService.revokeById(map.get("licenceid") + "");
            workflowService.doMyWorkItem(securitySession.principal(), workinst, "adopt", "", true);
        } else {
            workflowService.doWorkItemAndSend(securitySession.principal(), workinst, "return", "", workItem.getWorkEvent().getSender(), "return", "退回");
        }
        return workItem;
    }

    @Override
    public void forceRevokeLaByPlatfrom(ISecuritySession securitySession, String licenceid) throws CircuitException {
        if (!securitySession.roleIn("platform:administrators")) {
            throw new CircuitException("800", String.format("拒绝访问"));
        }
        licenceService.revokeById(licenceid);
    }
}
