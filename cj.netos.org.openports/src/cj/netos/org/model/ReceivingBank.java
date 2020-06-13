package cj.netos.org.model;

/**
 * Table: receiving_bank
 */
public class ReceivingBank {
    /**
     * Column: id
     */
    private String id;

    /**
     * Column: bank_name
     * Remark: 行名
     */
    private String bankName;

    /**
     * Column: account_name
     * Remark: 账户名
     */
    private String accountName;

    /**
     * Column: account_no
     * Remark: 账号
     */
    private String accountNo;

    /**
     * Column: note
     * Remark: 备注
     */
    private String note;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}