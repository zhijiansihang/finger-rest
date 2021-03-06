package com.zhijiansihang.finger.gen.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zhijiansihang.finger.mmc.MobileMessage;

/**
 * Y更新我的资料.客户端请求
 * 
 * @author 代码生成器v1.0
 * 
 */
 @JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateFinanceDetailRequest extends MobileMessage {


	private String educationLevel;
	private String personalProfile;
	private String position;
	private String schoolName;
	private String serviceConcept;
	private String serviceDirection;
	private String workAge;
	private String workingExperience;

	public UpdateFinanceDetailRequest() {
		super();
	}	

	/**
	 * @return 文化程度
	 */
	public String getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	/**
	 * @return 个人简介
	 */
	public String getPersonalProfile() {
		return personalProfile;
	}

	public void setPersonalProfile(String personalProfile) {
		this.personalProfile = personalProfile;
	}

	/**
	 * @return 职位
	 */
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return 毕业院校
	 */
	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	/**
	 * @return 服务理念
	 */
	public String getServiceConcept() {
		return serviceConcept;
	}

	public void setServiceConcept(String serviceConcept) {
		this.serviceConcept = serviceConcept;
	}

	/**
	 * @return 服务方向
	 */
	public String getServiceDirection() {
		return serviceDirection;
	}

	public void setServiceDirection(String serviceDirection) {
		this.serviceDirection = serviceDirection;
	}

	/**
	 * @return 工作时间
	 */
	public String getWorkAge() {
		return workAge;
	}

	public void setWorkAge(String workAge) {
		this.workAge = workAge;
	}

	/**
	 * @return 从业经历
	 */
	public String getWorkingExperience() {
		return workingExperience;
	}

	public void setWorkingExperience(String workingExperience) {
		this.workingExperience = workingExperience;
	}
	
}