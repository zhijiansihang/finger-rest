package com.zhijiansihang.finger.gen.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.zhijiansihang.finger.mmc.MobileMessage;


/**
 * Y是否有匹配需求的方案.服务端响应
 * 
 * @author 代码生成器v1.0
 * 
 */
@JsonInclude(Include.NON_NULL)
public class IsHasMatchDemandSolutionResponse extends MobileMessage {


	private String isHas;

	public IsHasMatchDemandSolutionResponse() {
		super();
		StringBuffer sb = new StringBuffer();
		
		
		String eps = sb.toString();
		if(eps.endsWith(",")){
			eps = eps.substring(0, eps.length() - 1);
		}
		this.setMsgeps(eps);
	}

	public IsHasMatchDemandSolutionResponse(String statusCode, String statusMessage) {
		this.setStatusCode(statusCode);
		this.setStatusMessage(statusMessage);
	}


	/**
	 * @return 是否有 1为有 0为无
	 */
	public String getIsHas() {
		return isHas;
	}

	public void setIsHas(String isHas) {
		this.isHas = isHas;
	}

}