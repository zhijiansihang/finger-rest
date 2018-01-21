package com.zhijiansihang.finger.gen.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zhijiansihang.finger.mmc.MobileMessage;

/**
 * 删除关闭我的需求.客户端请求
 * 
 * @author 代码生成器v1.0
 * 
 */
 @JsonIgnoreProperties(ignoreUnknown = true)
public class OperateMyDemandRequest extends MobileMessage {


	private String id;
	private String type;

	public OperateMyDemandRequest() {
		super();
	}	

	/**
	 * @return 需求id
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return 操作类型:1:关闭2:删除
	 */
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}