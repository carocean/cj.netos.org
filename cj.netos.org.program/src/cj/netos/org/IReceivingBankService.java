package cj.netos.org;

import cj.netos.org.model.ReceivingBank;

import java.util.List;

public interface IReceivingBankService {
    ReceivingBank getReceivingBank(String principal, String bankid);

    List<ReceivingBank> getAll();

    void addReceivingBank(String principal, String bankName, String accountName, String accountNo, String note);

    void remove(String bankid);

}
