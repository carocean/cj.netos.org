package cj.netos.org.ports;

import cj.netos.org.IReceivingBankService;
import cj.netos.org.mapper.ReceivingBankMapper;
import cj.netos.org.model.ReceivingBank;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;

import java.util.List;

@CjService(name = "/receivingBank.ports")
public class ReceivingBankPorts implements IReceivingBankPorts {
    @CjServiceRef
    IReceivingBankService receivingBankService;
    @Override
    public ReceivingBank getReceivingBank(ISecuritySession securitySession, String bankid) throws CircuitException {
        return receivingBankService.getReceivingBank(securitySession.principal(),bankid);
    }

    @Override
    public List<ReceivingBank> getAll(ISecuritySession securitySession) {
        return receivingBankService.getAll();
    }

    @Override
    public void addReceivingBank(ISecuritySession securitySession, String bankName, String accountName, String accountNo, String note) throws CircuitException {
        if (!securitySession.roleIn("platform:administrators")) {
            throw new CircuitException("800",String.format("无权访问"));
        }
        receivingBankService.addReceivingBank(securitySession.principal(),bankName,accountName,accountNo,note);
    }

    @Override
    public void remove(ISecuritySession securitySession, String bankid) throws CircuitException {
        if (!securitySession.roleIn("platform:administrators")) {
            throw new CircuitException("800",String.format("无权访问"));
        }
        receivingBankService.remove(bankid);
    }
}
