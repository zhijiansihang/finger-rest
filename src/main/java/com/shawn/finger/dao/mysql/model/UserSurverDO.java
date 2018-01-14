package com.shawn.finger.dao.mysql.model;

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
     * 考试id
     */
    private Long examId;

    /**
     * 答案记录
     */
    private String answers;

    /**
     * 考试结果
     */
    private String examResult;

    /**
     * 风险测评等级
     */
    private Short riskAssessmentLevel;

    /**
     * 得分
     */
    private Short score;

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
     * 考试id
     * @return exam_id 考试id
     */
    public Long getExamId() {
        return examId;
    }

    /**
     * 考试id
     * @param examId 考试id
     */
    public void setExamId(Long examId) {
        this.examId = examId;
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
     * 考试结果
     * @return exam_result 考试结果
     */
    public String getExamResult() {
        return examResult;
    }

    /**
     * 考试结果
     * @param examResult 考试结果
     */
    public void setExamResult(String examResult) {
        this.examResult = examResult == null ? null : examResult.trim();
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
     * 得分
     * @return score 得分
     */
    public Short getScore() {
        return score;
    }

    /**
     * 得分
     * @param score 得分
     */
    public void setScore(Short score) {
        this.score = score;
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
        sb.append(", examId=").append(examId);
        sb.append(", answers=").append(answers);
        sb.append(", examResult=").append(examResult);
        sb.append(", riskAssessmentLevel=").append(riskAssessmentLevel);
        sb.append(", score=").append(score);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}