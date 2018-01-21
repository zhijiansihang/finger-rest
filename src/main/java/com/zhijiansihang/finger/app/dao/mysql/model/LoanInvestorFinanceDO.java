package com.zhijiansihang.finger.app.dao.mysql.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LoanInvestorFinanceDO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 标id
     */
    private Long loanId;

    /**
     * 预约用户id
     */
    private Long userId;

    /**
     * 用户姓名
     */
    private String realName;

    /**
     * 用户手机号
     */
    private String mobile;

    /**
     * 预约金额
     */
    private BigDecimal amount;

    /**
     * 预约人使用的理财师用户id
     */
    private Long financeUserId;

    /**
     * 理财师是否处理 1:已处理 0:处理中
     */
    private Byte isDeal;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * loan_investor_finance
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
     * 预约用户id
     * @return user_id 预约用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 预约用户id
     * @param userId 预约用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 用户姓名
     * @return real_name 用户姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 用户姓名
     * @param realName 用户姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 用户手机号
     * @return mobile 用户手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 用户手机号
     * @param mobile 用户手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 预约金额
     * @return amount 预约金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 预约金额
     * @param amount 预约金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 预约人使用的理财师用户id
     * @return finance_user_id 预约人使用的理财师用户id
     */
    public Long getFinanceUserId() {
        return financeUserId;
    }

    /**
     * 预约人使用的理财师用户id
     * @param financeUserId 预约人使用的理财师用户id
     */
    public void setFinanceUserId(Long financeUserId) {
        this.financeUserId = financeUserId;
    }

    /**
     * 理财师是否处理 1:已处理 0:处理中
     * @return is_deal 理财师是否处理 1:已处理 0:处理中
     */
    public Byte getIsDeal() {
        return isDeal;
    }

    /**
     * 理财师是否处理 1:已处理 0:处理中
     * @param isDeal 理财师是否处理 1:已处理 0:处理中
     */
    public void setIsDeal(Byte isDeal) {
        this.isDeal = isDeal;
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
        sb.append(", userId=").append(userId);
        sb.append(", realName=").append(realName);
        sb.append(", mobile=").append(mobile);
        sb.append(", amount=").append(amount);
        sb.append(", financeUserId=").append(financeUserId);
        sb.append(", isDeal=").append(isDeal);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}