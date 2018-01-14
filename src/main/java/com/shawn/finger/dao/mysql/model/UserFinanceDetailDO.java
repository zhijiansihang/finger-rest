package com.shawn.finger.dao.mysql.model;

import java.io.Serializable;
import java.util.Date;

public class UserFinanceDetailDO implements Serializable {
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 文化程度
     */
    private String educationLevel;

    /**
     * 毕业院校
     */
    private String schoolName;

    /**
     * 从业年限
     */
    private Short workAge;

    /**
     * 职位
     */
    private String position;

    /**
     * 服务方向
     */
    private String serviceDirection;

    /**
     * 服务理念
     */
    private String serviceConcept;

    /**
     * 从业经历
     */
    private String workingExperience;

    /**
     * 个人简介
     */
    private String personalProfile;

    /**
     * 是否删除 1:为删除 0:未删除
     */
    private Byte isDeleted;

    /**
     * 关联产品数量
     */
    private Long loanCount;

    /**
     * 用户预约数
     */
    private Long userOrderCount;

    /**
     * 总采纳数
     */
    private Long adoptCount;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * user_finance_detail
     */
    private static final long serialVersionUID = 1L;

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
     * 文化程度
     * @return education_level 文化程度
     */
    public String getEducationLevel() {
        return educationLevel;
    }

    /**
     * 文化程度
     * @param educationLevel 文化程度
     */
    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel == null ? null : educationLevel.trim();
    }

    /**
     * 毕业院校
     * @return school_name 毕业院校
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * 毕业院校
     * @param schoolName 毕业院校
     */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }

    /**
     * 从业年限
     * @return work_age 从业年限
     */
    public Short getWorkAge() {
        return workAge;
    }

    /**
     * 从业年限
     * @param workAge 从业年限
     */
    public void setWorkAge(Short workAge) {
        this.workAge = workAge;
    }

    /**
     * 职位
     * @return position 职位
     */
    public String getPosition() {
        return position;
    }

    /**
     * 职位
     * @param position 职位
     */
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    /**
     * 服务方向
     * @return service_direction 服务方向
     */
    public String getServiceDirection() {
        return serviceDirection;
    }

    /**
     * 服务方向
     * @param serviceDirection 服务方向
     */
    public void setServiceDirection(String serviceDirection) {
        this.serviceDirection = serviceDirection == null ? null : serviceDirection.trim();
    }

    /**
     * 服务理念
     * @return service_concept 服务理念
     */
    public String getServiceConcept() {
        return serviceConcept;
    }

    /**
     * 服务理念
     * @param serviceConcept 服务理念
     */
    public void setServiceConcept(String serviceConcept) {
        this.serviceConcept = serviceConcept == null ? null : serviceConcept.trim();
    }

    /**
     * 从业经历
     * @return working_experience 从业经历
     */
    public String getWorkingExperience() {
        return workingExperience;
    }

    /**
     * 从业经历
     * @param workingExperience 从业经历
     */
    public void setWorkingExperience(String workingExperience) {
        this.workingExperience = workingExperience == null ? null : workingExperience.trim();
    }

    /**
     * 个人简介
     * @return personal_profile 个人简介
     */
    public String getPersonalProfile() {
        return personalProfile;
    }

    /**
     * 个人简介
     * @param personalProfile 个人简介
     */
    public void setPersonalProfile(String personalProfile) {
        this.personalProfile = personalProfile == null ? null : personalProfile.trim();
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
     * 关联产品数量
     * @return loan_count 关联产品数量
     */
    public Long getLoanCount() {
        return loanCount;
    }

    /**
     * 关联产品数量
     * @param loanCount 关联产品数量
     */
    public void setLoanCount(Long loanCount) {
        this.loanCount = loanCount;
    }

    /**
     * 用户预约数
     * @return user_order_count 用户预约数
     */
    public Long getUserOrderCount() {
        return userOrderCount;
    }

    /**
     * 用户预约数
     * @param userOrderCount 用户预约数
     */
    public void setUserOrderCount(Long userOrderCount) {
        this.userOrderCount = userOrderCount;
    }

    /**
     * 总采纳数
     * @return adopt_count 总采纳数
     */
    public Long getAdoptCount() {
        return adoptCount;
    }

    /**
     * 总采纳数
     * @param adoptCount 总采纳数
     */
    public void setAdoptCount(Long adoptCount) {
        this.adoptCount = adoptCount;
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
        sb.append(", userId=").append(userId);
        sb.append(", educationLevel=").append(educationLevel);
        sb.append(", schoolName=").append(schoolName);
        sb.append(", workAge=").append(workAge);
        sb.append(", position=").append(position);
        sb.append(", serviceDirection=").append(serviceDirection);
        sb.append(", serviceConcept=").append(serviceConcept);
        sb.append(", workingExperience=").append(workingExperience);
        sb.append(", personalProfile=").append(personalProfile);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", loanCount=").append(loanCount);
        sb.append(", userOrderCount=").append(userOrderCount);
        sb.append(", adoptCount=").append(adoptCount);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}