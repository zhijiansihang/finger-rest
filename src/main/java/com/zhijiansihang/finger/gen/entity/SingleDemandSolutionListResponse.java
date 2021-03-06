package com.zhijiansihang.finger.gen.entity;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.zhijiansihang.finger.mmc.MobileMessage;


/**
 * Y需求所匹配的方案列表.服务端响应
 * 
 * @author 代码生成器v1.0
 * 
 */
@JsonInclude(Include.NON_NULL)
public class SingleDemandSolutionListResponse extends MobileMessage {


	/**
	 * @see com.zhijiansihang.finger.gen.entity.SingleDemandSolutionListResponse#getSolutionList
	 * 
	 */
	@JsonInclude(Include.NON_NULL)
	public static class SolutionListElement {

		private String adoptCount;
		private String friendCount;
		private String id;
		private String institutionName;
		private String isOperateSolution;
		private String logo;
		private String realName;
		private String serialNumber;
		private String serviceDirection;
		private String solutionId;
		private String solutionUserId;

		/**
		 * @return 采纳数
		 */
		public String getAdoptCount() {
			return adoptCount;
		}

		public void setAdoptCount(String adoptCount) {
			this.adoptCount = adoptCount;
		}

		/**
		 * @return 好友数粉丝
		 */
		public String getFriendCount() {
			return friendCount;
		}

		public void setFriendCount(String friendCount) {
			this.friendCount = friendCount;
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
		 * @return 机构名称
		 */
		public String getInstitutionName() {
			return institutionName;
		}

		public void setInstitutionName(String institutionName) {
			this.institutionName = institutionName;
		}

		/**
		 * @return 投资人是否操作匹配方案2:已采纳1:为已读0:未读
		 */
		public String getIsOperateSolution() {
			return isOperateSolution;
		}

		public void setIsOperateSolution(String isOperateSolution) {
			this.isOperateSolution = isOperateSolution;
		}

		/**
		 * @return 理财师头像链接
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
		 * @return 方案编号
		 */
		public String getSerialNumber() {
			return serialNumber;
		}

		public void setSerialNumber(String serialNumber) {
			this.serialNumber = serialNumber;
		}

		/**
		 * @return 服务方向
		 */
		public String getServiceDirection() {
			return serviceDirection;
		}

		public void setServiceDirection(String serviceDirection) {
			this.serviceDirection = serviceDirection;
		}

		/**
		 * @return 方案id
		 */
		public String getSolutionId() {
			return solutionId;
		}

		public void setSolutionId(String solutionId) {
			this.solutionId = solutionId;
		}

		/**
		 * @return 理财师id
		 */
		public String getSolutionUserId() {
			return solutionUserId;
		}

		public void setSolutionUserId(String solutionUserId) {
			this.solutionUserId = solutionUserId;
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
	private List<SolutionListElement> solutionList;

	public SingleDemandSolutionListResponse() {
		super();
		StringBuffer sb = new StringBuffer();
		
		
		String eps = sb.toString();
		if(eps.endsWith(",")){
			eps = eps.substring(0, eps.length() - 1);
		}
		this.setMsgeps(eps);
	}

	public SingleDemandSolutionListResponse(String statusCode, String statusMessage) {
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
	 * @return 方案list
	 */
	public List<SolutionListElement> getSolutionList() {
		return solutionList;
	}

	public void setSolutionList(List<SolutionListElement> solutionList) {
		this.solutionList = solutionList;
	}

}