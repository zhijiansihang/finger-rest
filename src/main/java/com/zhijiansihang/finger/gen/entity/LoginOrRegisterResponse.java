package com.zhijiansihang.finger.gen.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.zhijiansihang.finger.mmc.MobileMessage;


/**
 * 注册或者登陆.服务端响应
 * 
 * @author 代码生成器v1.0
 * 
 */
@JsonInclude(Include.NON_NULL)
public class LoginOrRegisterResponse extends MobileMessage {


	private String idCard;
	private String isNameAuth;
	private String isRegisterJg;
	private String logo;
	private String mobile;
	private String nickName;
	private String realName;
	private String riskAssessmentLevel;
	private String roles;
	private String sessionId;
	private String userId;

	public LoginOrRegisterResponse() {
		super();
		StringBuffer sb = new StringBuffer();
		
		
		String eps = sb.toString();
		if(eps.endsWith(",")){
			eps = eps.substring(0, eps.length() - 1);
		}
		this.setMsgeps(eps);
	}

	public LoginOrRegisterResponse(String statusCode, String statusMessage) {
		this.setStatusCode(statusCode);
		this.setStatusMessage(statusMessage);
	}


	/**
	 * @return 身份证号
	 */
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	/**
	 * @return 是否实名认证
	 */
	public String getIsNameAuth() {
		return isNameAuth;
	}

	public void setIsNameAuth(String isNameAuth) {
		this.isNameAuth = isNameAuth;
	}

	/**
	 * @return 是否注册极光
	 */
	public String getIsRegisterJg() {
		return isRegisterJg;
	}

	public void setIsRegisterJg(String isRegisterJg) {
		this.isRegisterJg = isRegisterJg;
	}

	/**
	 * @return logo
	 */
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	/**
	 * @return 手机号
	 */
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return 昵称
	 */
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @return 真实姓名
	 */
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	/**
	 * @return 风险测评等级冗余
	 */
	public String getRiskAssessmentLevel() {
		return riskAssessmentLevel;
	}

	public void setRiskAssessmentLevel(String riskAssessmentLevel) {
		this.riskAssessmentLevel = riskAssessmentLevel;
	}

	/**
	 * @return 用户角色:3:用户投资人4:个人理财师5:机构理财师
	 */
	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	/**
	 * @return 登陆凭证,通过凭证获取用户信息
	 */
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return 用户id
	 */
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}