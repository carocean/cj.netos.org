package cj.netos.org.ports;

import cj.netos.org.model.ReceivingBank;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

@CjOpenports(usage = "平台收款行管理服务")
public interface IReceivingBankPorts extends IOpenportService {
    @CjOpenport(usage = "获取收款行")
    ReceivingBank getReceivingBank(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "收款行标识", name = "bankid") String bankid
    ) throws CircuitException;

    @CjOpenport(usage = "获取所有收款行")
    List<ReceivingBank> getAll();

    @CjOpenport(usage = "添加收款行")
    void addReceivingBank(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "行名", name = "bankName") String bankName,
            @CjOpenportParameter(usage = "户名", name = "accountName") String accountName,
            @CjOpenportParameter(usage = "账号", name = "accountNo") String accountNo,
            @CjOpenportParameter(usage = "备注", name = "note") String note
    ) throws CircuitException;

    @CjOpenport(usage = "移除收款行")
    void remove(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "收款行标识", name = "bankid") String bankid
    ) throws CircuitException;
}
