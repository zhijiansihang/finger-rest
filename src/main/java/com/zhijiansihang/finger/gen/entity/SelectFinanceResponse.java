package com.zhijiansihang.finger.gen.entity;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.zhijiansihang.finger.mmc.MobileMessage;


/**
 * Y发现投顾.服务端响应
 * 
 * @author 代码生成器v1.0
 * 
 */
@JsonInclude(Include.NON_NULL)
public class SelectFinanceResponse extends MobileMessage {


	/**
	 * @see com.zhijiansihang.finger.gen.entity.SelectFinanceResponse#getFinanceList
	 * 
	 */
	@JsonInclude(Include.NON_NULL)
	public static class FinanceListElement {

		private String adoptCount;
		private String institutionName;
		private String loanCount;
		private String logo;
		private String position;
		private String realName;
		private String serviceDirection;
		private String userId;
		private String userOrderCount;

		/**
		 * @return 总采纳数
		 */
		public String getAdoptCount() {
			return adoptCount;
		}

		public void setAdoptCount(String adoptCount) {
			this.adoptCount = adoptCount;
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
		 * @return 关联产品数量
		 */
		public String getLoanCount() {
			return loanCount;
		}

		public void setLoanCount(String loanCount) {
			this.loanCount = loanCount;
		}

		/**
		 * @return 头像路径
		 */
		public String getLogo() {
			return logo;
		}

		public void setLogo(String logo) {
			this.logo = logo;
		}

		/**
		 * @return 职位
		 */
		public String getPosition() {
			return position;
		}

		public void setPosition(String position) {
			this.position = position;
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
		 * @return 理财师id
		 */
		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		/**
		 * @return 用户预约数
		 */
		public String getUserOrderCount() {
			return userOrderCount;
		}

		public void setUserOrderCount(String userOrderCount) {
			this.userOrderCount = userOrderCount;
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
	private List<FinanceListElement> financeList;

	public SelectFinanceResponse() {
		super();
		StringBuffer sb = new StringBuffer();
		
		
		String eps = sb.toString();
		if(eps.endsWith(",")){
			eps = eps.substring(0, eps.length() - 1);
		}
		this.setMsgeps(eps);
	}

	public SelectFinanceResponse(String statusCode, String statusMessage) {
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
	 * @return 
	 */
	public List<FinanceListElement> getFinanceList() {
		return financeList;
	}

	public void setFinanceList(List<FinanceListElement> financeList) {
		this.financeList = financeList;
	}

}