package cj.netos.org.service;

import cj.netos.org.IReceivingBankService;
import cj.netos.org.mapper.ReceivingBankMapper;
import cj.netos.org.model.ReceivingBank;
import cj.netos.org.model.ReceivingBankExample;
import cj.netos.org.util.IdWorker;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.util.List;

@CjBridge(aspects = "@transaction")
@CjService(name = "receivingBankService")
public class ReceivingBankService implements IReceivingBankService {
    @CjServiceRef(refByName = "mybatis.cj.netos.org.mapper.ReceivingBankMapper")
    ReceivingBankMapper receivingBankMapper;

    @CjTransaction
    @Override
    public ReceivingBank getReceivingBank(String principal, String bankid) {
        return receivingBankMapper.selectByPrimaryKey(bankid);
    }

    @CjTransaction
    @Override
    public List<ReceivingBank> getAll() {
        ReceivingBankExample example = new ReceivingBankExample();
        example.createCriteria();
        return receivingBankMapper.selectByExample(example);
    }

    @CjTransaction
    @Override
    public void addReceivingBank(String principal, String bankName, String accountName, String accountNo, String note) {
        ReceivingBank bank = new ReceivingBank();
        bank.setAccountName(accountName);
        bank.setAccountNo(accountNo);
        bank.setBankName(bankName);
        bank.setId(new IdWorker().nextId());
        bank.setNote(note);
        receivingBankMapper.insert(bank);
    }

    @CjTransaction
    @Override
    public void remove(String bankid) {
        receivingBankMapper.deleteByPrimaryKey(bankid);
    }
}
