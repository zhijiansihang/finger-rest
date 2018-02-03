package com.zhijiansihang.finger.gen.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zhijiansihang.finger.mmc.MobileMessage;

/**
 * 预约.客户端请求
 * 
 * @author 代码生成器v1.0
 * 
 */
 @JsonIgnoreProperties(ignoreUnknown = true)
public class InvestRequest extends MobileMessage {


	private String amount;
	private String financeUserId;
	private String loanId;
	private String realName;

	public InvestRequest() {
		super();
	}	

	/**
	 * @return 金额
	 */
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * @return 理财师userid
	 */
	public String getFinanceUserId() {
		return financeUserId;
	}

	public void setFinanceUserId(String financeUserId) {
		this.financeUserId = financeUserId;
	}

	/**
	 * @return 标id
	 */
	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
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
	
}