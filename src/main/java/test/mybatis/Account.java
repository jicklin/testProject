package test.mybatis;

import java.util.Date;

public class Account {
    private Long acctId;

    private Long custId;

    private String acctName;

    private String contractNo;

    private String removeTag;

    private Date openDate;

    private Date removeDate;

    public Long getAcctId() {
        return acctId;
    }

    public void setAcctId(Long acctId) {
        this.acctId = acctId;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName == null ? null : acctName.trim();
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public String getRemoveTag() {
        return removeTag;
    }

    public void setRemoveTag(String removeTag) {
        this.removeTag = removeTag == null ? null : removeTag.trim();
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Date getRemoveDate() {
        return removeDate;
    }

    public void setRemoveDate(Date removeDate) {
        this.removeDate = removeDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", acctId=").append(acctId);
        sb.append(", custId=").append(custId);
        sb.append(", acctName=").append(acctName);
        sb.append(", contractNo=").append(contractNo);
        sb.append(", removeTag=").append(removeTag);
        sb.append(", openDate=").append(openDate);
        sb.append(", removeDate=").append(removeDate);
        sb.append("]");
        return sb.toString();
    }
}
