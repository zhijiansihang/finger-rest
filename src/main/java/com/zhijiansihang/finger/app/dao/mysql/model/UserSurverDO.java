package com.zhijiansihang.finger.app.dao.mysql.model;

import java.io.Serializable;
import java.util.Date;

public class UserSurverDO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;


    /**
     * 答案记录
     */
    private String answers;



    /**
     * 风险测评等级
     */
    private Short riskAssessmentLevel;


    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * user_surver
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
     * 答案记录
     * @return answers 答案记录
     */
    public String getAnswers() {
        return answers;
    }

    /**
     * 答案记录
     * @param answers 答案记录
     */
    public void setAnswers(String answers) {
        this.answers = answers == null ? null : answers.trim();
    }


    /**
     * 风险测评等级
     * @return risk_assessment_level 风险测评等级
     */
    public Short getRiskAssessmentLevel() {
        return riskAssessmentLevel;
    }

    /**
     * 风险测评等级
     * @param riskAssessmentLevel 风险测评等级
     */
    public void setRiskAssessmentLevel(Short riskAssessmentLevel) {
        this.riskAssessmentLevel = riskAssessmentLevel;
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
        sb.append(", userId=").append(userId);
        sb.append(", answers=").append(answers);
        sb.append(", riskAssessmentLevel=").append(riskAssessmentLevel);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}