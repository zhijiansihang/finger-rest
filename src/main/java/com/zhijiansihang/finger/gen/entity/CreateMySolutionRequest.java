package com.zhijiansihang.finger.gen.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zhijiansihang.finger.mmc.MobileMessage;

/**
 * Y发布我的方案.客户端请求
 * 
 * @author 代码生成器v1.0
 * 
 */
 @JsonIgnoreProperties(ignoreUnknown = true)
public class CreateMySolutionRequest extends MobileMessage {


	private String earningType;
	private String expectedDeadline;
	private String moneySituation;
	private String riskAssessmentLevel;
	private String solution;

	public CreateMySolutionRequest() {
		super();
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
	 * @return 我的资金:1:50万以下2:50万到100万3:100万到300万4:300万以上
	 */
	public String getMoneySituation() {
		return moneySituation;
	}

	public void setMoneySituation(String moneySituation) {
		this.moneySituation = moneySituation;
	}

	/**
	 * @return 分险等级
	 */
	public String getRiskAssessmentLevel() {
		return riskAssessmentLevel;
	}

	public void setRiskAssessmentLevel(String riskAssessmentLevel) {
		this.riskAssessmentLevel = riskAssessmentLevel;
	}

	/**
	 * @return 投顾方案
	 */
	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}
	
}