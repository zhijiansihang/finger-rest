package com.zhijiansihang.finger.gen.entity;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

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


	/**
	 * @see com.zhijiansihang.finger.gen.entity.FinanceDetailResponse#getFinanceList
	 * 
	 */
	@JsonInclude(Include.NON_NULL)
	public static class FinanceListElement {

		private String adoptCount;
		private String collectionCount;

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
		 * @return 收藏次数粉丝数
		 */
		public String getCollectionCount() {
			return collectionCount;
		}

		public void setCollectionCount(String collectionCount) {
			this.collectionCount = collectionCount;
		}
	
		@Override
		public String toString() {
			String str = ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
			return str;
		}
	}

	private String educationLevel;
	private String institutionName;
	private String isCollection;
	private String isFriend;
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
	private List<FinanceListElement> financeList;

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
	 * @return 文化程度
	 */
	public String getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
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

	/**
	 * @return 
	 */
	public List<FinanceListElement> getFinanceList() {
		return financeList;
	}

	public void setFinanceList(List<FinanceListElement> financeList) {
		this.financeList = financeList;
	}

}