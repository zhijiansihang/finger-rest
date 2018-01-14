package com.shawn.finger.dao.mysql.model;

import java.io.Serializable;
import java.util.Date;

public class UserDemandDO implements Serializable {
    /**
     * 需求id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 我的资金:1:50万以下 2:50万到100万 3:100万到300万 4:300万以上
     */
    private Short moneySituation;

    /**
     * 收益类型:1:固定收益 2:浮动+保底 3:浮动收益 
     */
    private Short earningType;

    /**
     * 期望期限:1:6个月以内 2:6到12个月 3:12到24个月 4:24个月以上 
     */
    private Short expectedDeadline;

    /**
     * 补充说明
     */
    private String additionalRemarks;

    /**
     * 是否删除 1:为删除 0:未删除
     */
    private Byte isDeleted;

    /**
     * 是否关闭 1:为关闭 0:未关闭
     */
    private Byte isClosed;

    /**
     * 上一次跑批匹配方案的id
     */
    private Long lastBatchSid;

    /**
     * 跑批匹配方案数
     */
    private Long matchSolutionCount;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * user_demand
     */
    private static final long serialVersionUID = 1L;

    /**
     * 需求id
     * @return id 需求id
     */
    public Long getId() {
        return id;
    }

    /**
     * 需求id
     * @param id 需求id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 用户id
     * @return user_id 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户id
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 我的资金:1:50万以下 2:50万到100万 3:100万到300万 4:300万以上
     * @return money_situation 我的资金:1:50万以下 2:50万到100万 3:100万到300万 4:300万以上
     */
    public Short getMoneySituation() {
        return moneySituation;
    }

    /**
     * 我的资金:1:50万以下 2:50万到100万 3:100万到300万 4:300万以上
     * @param moneySituation 我的资金:1:50万以下 2:50万到100万 3:100万到300万 4:300万以上
     */
    public void setMoneySituation(Short moneySituation) {
        this.moneySituation = moneySituation;
    }

    /**
     * 收益类型:1:固定收益 2:浮动+保底 3:浮动收益 
     * @return earning_type 收益类型:1:固定收益 2:浮动+保底 3:浮动收益 
     */
    public Short getEarningType() {
        return earningType;
    }

    /**
     * 收益类型:1:固定收益 2:浮动+保底 3:浮动收益 
     * @param earningType 收益类型:1:固定收益 2:浮动+保底 3:浮动收益 
     */
    public void setEarningType(Short earningType) {
        this.earningType = earningType;
    }

    /**
     * 期望期限:1:6个月以内 2:6到12个月 3:12到24个月 4:24个月以上 
     * @return expected_deadline 期望期限:1:6个月以内 2:6到12个月 3:12到24个月 4:24个月以上 
     */
    public Short getExpectedDeadline() {
        return expectedDeadline;
    }

    /**
     * 期望期限:1:6个月以内 2:6到12个月 3:12到24个月 4:24个月以上 
     * @param expectedDeadline 期望期限:1:6个月以内 2:6到12个月 3:12到24个月 4:24个月以上 
     */
    public void setExpectedDeadline(Short expectedDeadline) {
        this.expectedDeadline = expectedDeadline;
    }

    /**
     * 补充说明
     * @return additional_remarks 补充说明
     */
    public String getAdditionalRemarks() {
        return additionalRemarks;
    }

    /**
     * 补充说明
     * @param additionalRemarks 补充说明
     */
    public void setAdditionalRemarks(String additionalRemarks) {
        this.additionalRemarks = additionalRemarks == null ? null : additionalRemarks.trim();
    }

    /**
     * 是否删除 1:为删除 0:未删除
     * @return is_deleted 是否删除 1:为删除 0:未删除
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * 是否删除 1:为删除 0:未删除
     * @param isDeleted 是否删除 1:为删除 0:未删除
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * 是否关闭 1:为关闭 0:未关闭
     * @return is_closed 是否关闭 1:为关闭 0:未关闭
     */
    public Byte getIsClosed() {
        return isClosed;
    }

    /**
     * 是否关闭 1:为关闭 0:未关闭
     * @param isClosed 是否关闭 1:为关闭 0:未关闭
     */
    public void setIsClosed(Byte isClosed) {
        this.isClosed = isClosed;
    }

    /**
     * 上一次跑批匹配方案的id
     * @return last_batch_sid 上一次跑批匹配方案的id
     */
    public Long getLastBatchSid() {
        return lastBatchSid;
    }

    /**
     * 上一次跑批匹配方案的id
     * @param lastBatchSid 上一次跑批匹配方案的id
     */
    public void setLastBatchSid(Long lastBatchSid) {
        this.lastBatchSid = lastBatchSid;
    }

    /**
     * 跑批匹配方案数
     * @return match_solution_count 跑批匹配方案数
     */
    public Long getMatchSolutionCount() {
        return matchSolutionCount;
    }

    /**
     * 跑批匹配方案数
     * @param matchSolutionCount 跑批匹配方案数
     */
    public void setMatchSolutionCount(Long matchSolutionCount) {
        this.matchSolutionCount = matchSolutionCount;
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

    /**
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", moneySituation=").append(moneySituation);
        sb.append(", earningType=").append(earningType);
        sb.append(", expectedDeadline=").append(expectedDeadline);
        sb.append(", additionalRemarks=").append(additionalRemarks);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", isClosed=").append(isClosed);
        sb.append(", lastBatchSid=").append(lastBatchSid);
        sb.append(", matchSolutionCount=").append(matchSolutionCount);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}