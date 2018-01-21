package com.zhijiansihang.finger.gen.entity;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.zhijiansihang.finger.mmc.MobileMessage;


/**
 * 方案所匹配的需求列表.服务端响应
 * 
 * @author 代码生成器v1.0
 * 
 */
@JsonInclude(Include.NON_NULL)
public class SingleSolutionDemandListResponse extends MobileMessage {


	/**
	 * @see com.zhijiansihang.finger.gen.entity.SingleSolutionDemandListResponse#getDemandList
	 * 
	 */
	@JsonInclude(Include.NON_NULL)
	public static class DemandListElement {

		private String demandId;
		private String demandUserId;
		private String id;
		private String isRead;
		private String logo;
		private String realName;
		private String serialNumber;

		/**
		 * @return 需求id
		 */
		public String getDemandId() {
			return demandId;
		}

		public void setDemandId(String demandId) {
			this.demandId = demandId;
		}

		/**
		 * @return 需求userid
		 */
		public String getDemandUserId() {
			return demandUserId;
		}

		public void setDemandUserId(String demandUserId) {
			this.demandUserId = demandUserId;
		}

		/**
		 * @return 记录id
		 */
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		/**
		 * @return 投资人是否操作匹配方案2:已采纳1:为已读0:未读
		 */
		public String getIsRead() {
			return isRead;
		}

		public void setIsRead(String isRead) {
			this.isRead = isRead;
		}

		/**
		 * @return 需求userid头像链接
		 */
		public String getLogo() {
			return logo;
		}

		public void setLogo(String logo) {
			this.logo = logo;
		}

		/**
		 * @return 理财师名称
		 */
		public String getRealName() {
			return realName;
		}

		public void setRealName(String realName) {
			this.realName = realName;
		}

		/**
		 * @return 需求编号
		 */
		public String getSerialNumber() {
			return serialNumber;
		}

		public void setSerialNumber(String serialNumber) {
			this.serialNumber = serialNumber;
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
	private List<DemandListElement> demandList;

	public SingleSolutionDemandListResponse() {
		super();
		StringBuffer sb = new StringBuffer();
		
		
		String eps = sb.toString();
		if(eps.endsWith(",")){
			eps = eps.substring(0, eps.length() - 1);
		}
		this.setMsgeps(eps);
	}

	public SingleSolutionDemandListResponse(String statusCode, String statusMessage) {
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
	 * @return 需求
	 */
	public List<DemandListElement> getDemandList() {
		return demandList;
	}

	public void setDemandList(List<DemandListElement> demandList) {
		this.demandList = demandList;
	}

}