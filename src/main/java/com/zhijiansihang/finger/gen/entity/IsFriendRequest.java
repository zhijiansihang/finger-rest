package com.zhijiansihang.finger.gen.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zhijiansihang.finger.mmc.MobileMessage;

/**
 * 是否是好友关系.客户端请求
 * 
 * @author 代码生成器v1.0
 * 
 */
 @JsonIgnoreProperties(ignoreUnknown = true)
public class IsFriendRequest extends MobileMessage {


	private String friendUserid;

	public IsFriendRequest() {
		super();
	}	

	/**
	 * @return 好友id
	 */
	public String getFriendUserid() {
		return friendUserid;
	}

	public void setFriendUserid(String friendUserid) {
		this.friendUserid = friendUserid;
	}
	
}