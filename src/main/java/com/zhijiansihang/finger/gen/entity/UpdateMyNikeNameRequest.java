package com.zhijiansihang.finger.gen.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zhijiansihang.finger.mmc.MobileMessage;

/**
 * Y更新我的昵称.客户端请求
 * 
 * @author 代码生成器v1.0
 * 
 */
 @JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateMyNikeNameRequest extends MobileMessage {


	private String nikeName;

	public UpdateMyNikeNameRequest() {
		super();
	}	

	/**
	 * @return 昵称
	 */
	public String getNikeName() {
		return nikeName;
	}

	public void setNikeName(String nikeName) {
		this.nikeName = nikeName;
	}
	
}