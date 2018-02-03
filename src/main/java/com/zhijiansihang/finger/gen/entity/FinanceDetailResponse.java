package com.zhijiansihang.finger.gen.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.zhijiansihang.finger.mmc.MobileMessage;


/**
 * 理财师详情.服务端响应
 * 
 * @author 代码生成器v1.0
 * 
 */
@JsonInclude(Include.NON_NULL)
public class FinanceDetailResponse extends MobileMessage {


	private String adoptCount;
	private String educationLevel;
	private String friendCount;
	private String institutionName;
	private String isCollection;
	private String isFriend;
	private String isPerson;
	private String loanCount;
	private String logo;
	private String personalProfile;
	private String position;
	private String realName;
	private String schoolName;
	private String sellingloanCount;
	private String serviceConcept;
	private String serviceDirection;
	private String servicePersonCount;
	private String userId;
	private String userOrderCount;
	private String workAge;
	private String workingExperience;

	public FinanceDetailResponse() {
		super();
		StringBuffer sb = new StringBuffer();
		
		
		String eps = sb.toString();
		if(eps.endsWith(",")){
			eps = eps.substring(0, eps.length() - 1);
		}
		this.setMsgeps(eps);
	}

	public FinanceDetailResponse(String statusCode, String statusMessage) {
		this.setStatusCode(statusCode);
		this.setStatusMessage(statusMessage);
	}


	/**
	 * @return 总采纳数
	 */
	public String getAdoptCount() {
		return adoptCount;
	}

	public void setAdoptCount(String adoptCount) {
		this.adoptCount = adoptCount;
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
	 * @return 粉丝数
	 */
	public String getFriendCount() {
		return friendCount;
	}

	public void setFriendCount(String friendCount) {
		this.friendCount = friendCount;
	}

	/**
	 * @return 机构名称
	 */
	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	/**
	 * @return 是否已经收藏1位是
	 */
	public String getIsCollection() {
		return isCollection;
	}

	public void setIsCollection(String isCollection) {
		this.isCollection = isCollection;
	}

	/**
	 * @return 是否是好友
	 */
	public String getIsFriend() {
		return isFriend;
	}

	public void setIsFriend(String isFriend) {
		this.isFriend = isFriend;
	}

	/**
	 * @return 是否个人机构 1:为个人机构 2:企业机构
	 */
	public String getIsPerson() {
		return isPerson;
	}

	public void setIsPerson(String isPerson) {
		this.isPerson = isPerson;
	}

	/**
	 * @return 关联产品数量
	 */
	public String getLoanCount() {
		return loanCount;
	}

	public void setLoanCount(String loanCount) {
		this.loanCount = loanCount;
	}

	/**
	 * @return 头像路径
	 */
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
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
	 * @return 姓名
	 */
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
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
	 * @return 在卖产品数量
	 */
	public String getSellingloanCount() {
		return sellingloanCount;
	}

	public void setSellingloanCount(String sellingloanCount) {
		this.sellingloanCount = sellingloanCount;
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
	 * @return 服务的人数
	 */
	public String getServicePersonCount() {
		return servicePersonCount;
	}

	public void setServicePersonCount(String servicePersonCount) {
		this.servicePersonCount = servicePersonCount;
	}

	/**
	 * @return 理财师id
	 */
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return 用户预约数
	 */
	public String getUserOrderCount() {
		return userOrderCount;
	}

	public void setUserOrderCount(String userOrderCount) {
		this.userOrderCount = userOrderCount;
	}

	/**
	 * @return 从业年限
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