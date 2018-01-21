package com.zhijiansihang.finger.gen.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.zhijiansihang.finger.mmc.MobileMessage;


/**
 * 需求详情.服务端响应
 * 
 * @author 代码生成器v1.0
 * 
 */
@JsonInclude(Include.NON_NULL)
public class DemandDetailResponse extends MobileMessage {


	private String additionalRemarks;
	private String demandUserid;
	private String earningType;
	private String expectedDeadline;
	private String moneySituation;
	private String serialNumber;

	public DemandDetailResponse() {
		super();
		StringBuffer sb = new StringBuffer();
		
		
		String eps = sb.toString();
		if(eps.endsWith(",")){
			eps = eps.substring(0, eps.length() - 1);
		}
		this.setMsgeps(eps);
	}

	public DemandDetailResponse(String statusCode, String statusMessage) {
		this.setStatusCode(statusCode);
		this.setStatusMessage(statusMessage);
	}


	/**
	 * @return 补充说明
	 */
	public String getAdditionalRemarks() {
		return additionalRemarks;
	}

	public void setAdditionalRemarks(String additionalRemarks) {
		this.additionalRemarks = additionalRemarks;
	}

	/**
	 * @return 需求的用户id
	 */
	public String getDemandUserid() {
		return demandUserid;
	}

	public void setDemandUserid(String demandUserid) {
		this.demandUserid = demandUserid;
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
	 * @return 需求编号
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

}