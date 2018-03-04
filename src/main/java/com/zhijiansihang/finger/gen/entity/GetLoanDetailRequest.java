package com.zhijiansihang.finger.gen.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zhijiansihang.finger.mmc.MobileMessage;

/**
 * 获取标详情.客户端请求
 * 
 * @author 代码生成器v1.0
 * 
 */
 @JsonIgnoreProperties(ignoreUnknown = true)
public class GetLoanDetailRequest extends MobileMessage {


	private String loanId;

	public GetLoanDetailRequest() {
		super();
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
	
}