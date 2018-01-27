package com.zhijiansihang.finger.gen.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zhijiansihang.finger.mmc.MobileMessage;

/**
 * Y方案已读需求.客户端请求
 * 
 * @author 代码生成器v1.0
 * 
 */
 @JsonIgnoreProperties(ignoreUnknown = true)
public class OperateMySolutiondemandRequest extends MobileMessage {


	private String id;

	public OperateMySolutiondemandRequest() {
		super();
	}	

	/**
	 * @return 方案需求记录id
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}