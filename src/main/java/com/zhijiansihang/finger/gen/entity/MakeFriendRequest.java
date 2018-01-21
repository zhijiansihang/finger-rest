package com.zhijiansihang.finger.gen.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zhijiansihang.finger.mmc.MobileMessage;

/**
 * 交朋友.客户端请求
 * 
 * @author 代码生成器v1.0
 * 
 */
 @JsonIgnoreProperties(ignoreUnknown = true)
public class MakeFriendRequest extends MobileMessage {


	private String friendUserid;

	public MakeFriendRequest() {
		super();
	}	

	/**
	 * @return 朋友的userid
	 */
	public String getFriendUserid() {
		return friendUserid;
	}

	public void setFriendUserid(String friendUserid) {
		this.friendUserid = friendUserid;
	}
	
}