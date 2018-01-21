package com.zhijiansihang.finger.gen.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zhijiansihang.finger.mmc.MobileMessage;

/**
 * 点咨询记录.客户端请求
 * 
 * @author 代码生成器v1.0
 * 
 */
 @JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultingRecordRequest extends MobileMessage {


	private String consultingUserid;
	private String type;

	public ConsultingRecordRequest() {
		super();
	}	

	/**
	 * @return 朋友的userid
	 */
	public String getConsultingUserid() {
		return consultingUserid;
	}

	public void setConsultingUserid(String consultingUserid) {
		this.consultingUserid = consultingUserid;
	}

	/**
	 * @return 1咨询2预约
	 */
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}