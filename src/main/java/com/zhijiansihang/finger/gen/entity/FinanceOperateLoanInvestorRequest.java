package com.zhijiansihang.finger.gen.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zhijiansihang.finger.mmc.MobileMessage;

/**
 * 理财师操作预约记录.客户端请求
 * 
 * @author 代码生成器v1.0
 * 
 */
 @JsonIgnoreProperties(ignoreUnknown = true)
public class FinanceOperateLoanInvestorRequest extends MobileMessage {


	private String id;

	public FinanceOperateLoanInvestorRequest() {
		super();
	}	

	/**
	 * @return 预约记录id
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}