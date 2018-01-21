package com.zhijiansihang.finger.gen.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zhijiansihang.finger.mmc.MobileMessage;

/**
 * 理财师详情.客户端请求
 * 
 * @author 代码生成器v1.0
 * 
 */
 @JsonIgnoreProperties(ignoreUnknown = true)
public class FinanceDetailRequest extends MobileMessage {


	private String financeUserid;

	public FinanceDetailRequest() {
		super();
	}	

	/**
	 * @return 第几页
	 */
	public String getFinanceUserid() {
		return financeUserid;
	}

	public void setFinanceUserid(String financeUserid) {
		this.financeUserid = financeUserid;
	}
	
}