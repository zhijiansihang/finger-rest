package com.zhijiansihang.finger.app.dao.mysql.model;

import java.io.Serializable;
import java.util.Date;

public class UserSolutionDO implements Serializable {
    /**
     * 方案id
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
     * 投顾方案
     */
    private String solution;

    /**
     * 对应需求人风险测评等级
     */
    private String riskAssessmentLevel;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否删除 1:为删除 0:未删除
     */
    private Byte isDeleted;

    /**
     * 是否关闭 1:为关闭 0:未关闭
     */
    private Byte isClosed;

    /**
     * 跑批匹配需求数
     */
    private Long matchDemandCount;

    /**
     * 方案已读数
     */
    private Long readCount;

    /**
     * 方案采纳数
     */
    private Long adoptCount;

    /**
     * 方案编号
     */
    private Long serialNumber;

    /**
     * user_solution
     */
    private static final long serialVersionUID = 1L;

    /**
     * 方案id
     * @return id 方案id
     */
    public Long getId() {
        return id;
    }

    /**
     * 方案id
     * @param id 方案id
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
     * 投顾方案
     * @return solution 投顾方案
     */
    public String getSolution() {
        return solution;
    }

    /**
     * 投顾方案
     * @param solution 投顾方案
     */
    public void setSolution(String solution) {
        this.solution = solution == null ? null : solution.trim();
    }

    /**
     * 对应需求人风险测评等级
     * @return risk_assessment_level 对应需求人风险测评等级
     */
    public String getRiskAssessmentLevel() {
        return riskAssessmentLevel;
    }

    /**
     * 对应需求人风险测评等级
     * @param riskAssessmentLevel 对应需求人风险测评等级
     */
    public void setRiskAssessmentLevel(String riskAssessmentLevel) {
        this.riskAssessmentLevel = riskAssessmentLevel == null ? null : riskAssessmentLevel.trim();
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
     * 跑批匹配需求数
     * @return match_demand_count 跑批匹配需求数
     */
    public Long getMatchDemandCount() {
        return matchDemandCount;
    }

    /**
     * 跑批匹配需求数
     * @param matchDemandCount 跑批匹配需求数
     */
    public void setMatchDemandCount(Long matchDemandCount) {
        this.matchDemandCount = matchDemandCount;
    }

    /**
     * 方案已读数
     * @return read_count 方案已读数
     */
    public Long getReadCount() {
        return readCount;
    }

    /**
     * 方案已读数
     * @param readCount 方案已读数
     */
    public void setReadCount(Long readCount) {
        this.readCount = readCount;
    }

    /**
     * 方案采纳数
     * @return adopt_count 方案采纳数
     */
    public Long getAdoptCount() {
        return adoptCount;
    }

    /**
     * 方案采纳数
     * @param adoptCount 方案采纳数
     */
    public void setAdoptCount(Long adoptCount) {
        this.adoptCount = adoptCount;
    }

    /**
     * 方案编号
     * @return serial_number 方案编号
     */
    public Long getSerialNumber() {
        return serialNumber;
    }

    /**
     * 方案编号
     * @param serialNumber 方案编号
     */
    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
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
        sb.append(", solution=").append(solution);
        sb.append(", riskAssessmentLevel=").append(riskAssessmentLevel);
        sb.append(", createTime=").append(createTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", isClosed=").append(isClosed);
        sb.append(", matchDemandCount=").append(matchDemandCount);
        sb.append(", readCount=").append(readCount);
        sb.append(", adoptCount=").append(adoptCount);
        sb.append(", serialNumber=").append(serialNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}