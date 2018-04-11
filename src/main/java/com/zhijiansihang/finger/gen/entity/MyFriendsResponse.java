package com.zhijiansihang.finger.gen.entity;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.zhijiansihang.finger.mmc.MobileMessage;


/**
 * Y我的好友.服务端响应
 * 
 * @author 代码生成器v1.0
 * 
 */
@JsonInclude(Include.NON_NULL)
public class MyFriendsResponse extends MobileMessage {


	/**
	 * @see com.zhijiansihang.finger.gen.entity.MyFriendsResponse#getFriendList
	 * 
	 */
	@JsonInclude(Include.NON_NULL)
	public static class FriendListElement {

		private String friendUserId;
		private String jgName;
		private String logo;
		private String realName;

		/**
		 * @return 好友id
		 */
		public String getFriendUserId() {
			return friendUserId;
		}

		public void setFriendUserId(String friendUserId) {
			this.friendUserId = friendUserId;
		}

		/**
		 * @return 机构名称
		 */
		public String getJgName() {
			return jgName;
		}

		public void setJgName(String jgName) {
			this.jgName = jgName;
		}

		/**
		 * @return 好友头像
		 */
		public String getLogo() {
			return logo;
		}

		public void setLogo(String logo) {
			this.logo = logo;
		}

		/**
		 * @return 姓名
		 */
		public String getRealName() {
			return realName;
		}

		public void setRealName(String realName) {
			this.realName = realName;
		}
	
		@Override
		public String toString() {
			String str = ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
			return str;
		}
	}

	private String currentPage;
	private String pageCount;
	private String pageSize;
	private String recordCount;
	private List<FriendListElement> friendList;

	public MyFriendsResponse() {
		super();
		StringBuffer sb = new StringBuffer();
		
		
		String eps = sb.toString();
		if(eps.endsWith(",")){
			eps = eps.substring(0, eps.length() - 1);
		}
		this.setMsgeps(eps);
	}

	public MyFriendsResponse(String statusCode, String statusMessage) {
		this.setStatusCode(statusCode);
		this.setStatusMessage(statusMessage);
	}


	/**
	 * @return 当前页
	 */
	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return 总页数
	 */
	public String getPageCount() {
		return pageCount;
	}

	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
	}

	/**
	 * @return 每页多少条
	 */
	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return 总记录数
	 */
	public String getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(String recordCount) {
		this.recordCount = recordCount;
	}

	/**
	 * @return 好友list
	 */
	public List<FriendListElement> getFriendList() {
		return friendList;
	}

	public void setFriendList(List<FriendListElement> friendList) {
		this.friendList = friendList;
	}

}