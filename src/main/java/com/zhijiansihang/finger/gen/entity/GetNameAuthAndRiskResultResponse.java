package com.zhijiansihang.finger.gen.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.zhijiansihang.finger.mmc.MobileMessage;


/**
 * Y是否实名认证和评测.服务端响应
 * 
 * @author 代码生成器v1.0
 * 
 */
@JsonInclude(Include.NON_NULL)
public class GetNameAuthAndRiskResultResponse extends MobileMessage {


	private String isNameAuth;
	private String riskAssessmentLevel;

	public GetNameAuthAndRiskResultResponse() {
		super();
		StringBuffer sb = new StringBuffer();
		
		
		String eps = sb.toString();
		if(eps.endsWith(",")){
			eps = eps.substring(0, eps.length() - 1);
		}
		this.setMsgeps(eps);
	}

	public GetNameAuthAndRiskResultResponse(String statusCode, String statusMessage) {
		this.setStatusCode(statusCode);
		this.setStatusMessage(statusMessage);
	}


	/**
	 * @return 1为已实名0未实名
	 */
	public String getIsNameAuth() {
		return isNameAuth;
	}

	public void setIsNameAuth(String isNameAuth) {
		this.isNameAuth = isNameAuth;
	}

	/**
	 * @return 评测结果为空是未评测
	 */
	public String getRiskAssessmentLevel() {
		return riskAssessmentLevel;
	}

	public void setRiskAssessmentLevel(String riskAssessmentLevel) {
		this.riskAssessmentLevel = riskAssessmentLevel;
	}

}