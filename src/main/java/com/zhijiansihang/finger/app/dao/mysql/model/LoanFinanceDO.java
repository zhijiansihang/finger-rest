package com.zhijiansihang.finger.app.dao.mysql.model;

import java.io.Serializable;
import java.util.Date;

public class LoanFinanceDO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 标id
     */
    private Long loanId;

    /**
     * 理财师用户id
     */
    private Long financeUserId;

    /**
     * 是否逻辑删除 1:删除 0:未删除
     */
    private Byte isDeleted;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * loan_finance
     */
    private static final long serialVersionUID = 1L;

    /**
     * id
     * @return id id
     */
    public Long getId() {
        return id;
    }

    /**
     * id
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 标id
     * @return loan_id 标id
     */
    public Long getLoanId() {
        return loanId;
    }

    /**
     * 标id
     * @param loanId 标id
     */
    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    /**
     * 理财师用户id
     * @return finance_user_id 理财师用户id
     */
    public Long getFinanceUserId() {
        return financeUserId;
    }

    /**
     * 理财师用户id
     * @param financeUserId 理财师用户id
     */
    public void setFinanceUserId(Long financeUserId) {
        this.financeUserId = financeUserId;
    }

    /**
     * 是否逻辑删除 1:删除 0:未删除
     * @return is_deleted 是否逻辑删除 1:删除 0:未删除
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * 是否逻辑删除 1:删除 0:未删除
     * @param isDeleted 是否逻辑删除 1:删除 0:未删除
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * 更新时间
     * @return update_time 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", loanId=").append(loanId);
        sb.append(", financeUserId=").append(financeUserId);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}