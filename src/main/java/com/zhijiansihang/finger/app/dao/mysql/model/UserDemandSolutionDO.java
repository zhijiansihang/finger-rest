package com.zhijiansihang.finger.app.dao.mysql.model;

import java.io.Serializable;
import java.util.Date;

public class UserDemandSolutionDO implements Serializable {
    /**
     * 需求方案匹配id
     */
    private Long id;

    /**
     * 需求用户id
     */
    private Long demandUserId;

    /**
     * 需求表id
     */
    private Long demandId;

    /**
     * 方案用户id
     */
    private Long solutionUserId;

    /**
     * 方案表id
     */
    private Long solutionId;

    /**
     * 理财师是否已读匹配需求 1:为已读 0:未读
     */
    private Byte isReadDemand;

    /**
     * 投资人是否操作匹配方案 2:已采纳1:为已读 0:未读
     */
    private Byte isOperateSolution;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * user_demand_solution
     */
    private static final long serialVersionUID = 1L;

    /**
     * 需求方案匹配id
     * @return id 需求方案匹配id
     */
    public Long getId() {
        return id;
    }

    /**
     * 需求方案匹配id
     * @param id 需求方案匹配id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 需求用户id
     * @return demand_user_id 需求用户id
     */
    public Long getDemandUserId() {
        return demandUserId;
    }

    /**
     * 需求用户id
     * @param demandUserId 需求用户id
     */
    public void setDemandUserId(Long demandUserId) {
        this.demandUserId = demandUserId;
    }

    /**
     * 需求表id
     * @return demand_id 需求表id
     */
    public Long getDemandId() {
        return demandId;
    }

    /**
     * 需求表id
     * @param demandId 需求表id
     */
    public void setDemandId(Long demandId) {
        this.demandId = demandId;
    }

    /**
     * 方案用户id
     * @return solution_user_id 方案用户id
     */
    public Long getSolutionUserId() {
        return solutionUserId;
    }

    /**
     * 方案用户id
     * @param solutionUserId 方案用户id
     */
    public void setSolutionUserId(Long solutionUserId) {
        this.solutionUserId = solutionUserId;
    }

    /**
     * 方案表id
     * @return solution_id 方案表id
     */
    public Long getSolutionId() {
        return solutionId;
    }

    /**
     * 方案表id
     * @param solutionId 方案表id
     */
    public void setSolutionId(Long solutionId) {
        this.solutionId = solutionId;
    }

    /**
     * 理财师是否已读匹配需求 1:为已读 0:未读
     * @return is_read_demand 理财师是否已读匹配需求 1:为已读 0:未读
     */
    public Byte getIsReadDemand() {
        return isReadDemand;
    }

    /**
     * 理财师是否已读匹配需求 1:为已读 0:未读
     * @param isReadDemand 理财师是否已读匹配需求 1:为已读 0:未读
     */
    public void setIsReadDemand(Byte isReadDemand) {
        this.isReadDemand = isReadDemand;
    }

    /**
     * 投资人是否操作匹配方案 2:已采纳1:为已读 0:未读
     * @return is_operate_solution 投资人是否操作匹配方案 2:已采纳1:为已读 0:未读
     */
    public Byte getIsOperateSolution() {
        return isOperateSolution;
    }

    /**
     * 投资人是否操作匹配方案 2:已采纳1:为已读 0:未读
     * @param isOperateSolution 投资人是否操作匹配方案 2:已采纳1:为已读 0:未读
     */
    public void setIsOperateSolution(Byte isOperateSolution) {
        this.isOperateSolution = isOperateSolution;
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
        sb.append(", demandUserId=").append(demandUserId);
        sb.append(", demandId=").append(demandId);
        sb.append(", solutionUserId=").append(solutionUserId);
        sb.append(", solutionId=").append(solutionId);
        sb.append(", isReadDemand=").append(isReadDemand);
        sb.append(", isOperateSolution=").append(isOperateSolution);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}