package com.zhijiansihang.finger.gen.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.zhijiansihang.finger.mmc.MobileMessage;


/**
 * Y方案详情.服务端响应
 * 
 * @author 代码生成器v1.0
 * 
 */
@JsonInclude(Include.NON_NULL)
public class SolutionDetailResponse extends MobileMessage {


	private String earningType;
	private String expectedDeadline;
	private String isFinanceDeleted;
	private String moneySituation;
	private String riskAssessmentLevel;
	private String solution;

	public SolutionDetailResponse() {
		super();
		StringBuffer sb = new StringBuffer();
		
		
		String eps = sb.toString();
		if(eps.endsWith(",")){
			eps = eps.substring(0, eps.length() - 1);
		}
		this.setMsgeps(eps);
	}

	public SolutionDetailResponse(String statusCode, String statusMessage) {
		this.setStatusCode(statusCode);
		this.setStatusMessage(statusMessage);
	}


	/**
	 * @return 收益类型:1:固定收益2:浮动+保底3:浮动收益
	 */
	public String getEarningType() {
		return earningType;
	}

	public void setEarningType(String earningType) {
		this.earningType = earningType;
	}

	/**
	 * @return 期望期限:1:6个月以内2:6到12个月3:12到24个月4:24个月以上
	 */
	public String getExpectedDeadline() {
		return expectedDeadline;
	}

	public void setExpectedDeadline(String expectedDeadline) {
		this.expectedDeadline = expectedDeadline;
	}

	/**
	 * @return 对应的理财师是否删除1:为删除0:未删除
	 */
	public String getIsFinanceDeleted() {
		return isFinanceDeleted;
	}

	public void setIsFinanceDeleted(String isFinanceDeleted) {
		this.isFinanceDeleted = isFinanceDeleted;
	}

	/**
	 * @return 我的资金:1:50万以下2:50万到100万3:100万到300万4:300万以上
	 */
	public String getMoneySituation() {
		return moneySituation;
	}

	public void setMoneySituation(String moneySituation) {
		this.moneySituation = moneySituation;
	}

	/**
	 * @return 风险评测等级
	 */
	public String getRiskAssessmentLevel() {
		return riskAssessmentLevel;
	}

	public void setRiskAssessmentLevel(String riskAssessmentLevel) {
		this.riskAssessmentLevel = riskAssessmentLevel;
	}

	/**
	 * @return 投顾建议
	 */
	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

}