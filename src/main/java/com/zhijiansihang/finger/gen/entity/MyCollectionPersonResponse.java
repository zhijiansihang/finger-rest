package com.zhijiansihang.finger.gen.entity;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.zhijiansihang.finger.mmc.MobileMessage;


/**
 * 我的收藏-店铺.服务端响应
 * 
 * @author 代码生成器v1.0
 * 
 */
@JsonInclude(Include.NON_NULL)
public class MyCollectionPersonResponse extends MobileMessage {


	/**
	 * @see com.zhijiansihang.finger.gen.entity.MyCollectionPersonResponse#getFinanceList
	 * 
	 */
	@JsonInclude(Include.NON_NULL)
	public static class FinanceListElement {

		private String adoptCount;
		private String financeUserId;
		private String institutionName;
		private String isNameAuth;
		private String loanCount;
		private String logo;
		private String realName;
		private String serviceDirection;
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
		 * @return 理财师用户id
		 */
		public String getFinanceUserId() {
			return financeUserId;
		}

		public void setFinanceUserId(String financeUserId) {
			this.financeUserId = financeUserId;
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
		 * @return 是否认证1为是0位否
		 */
		public String getIsNameAuth() {
			return isNameAuth;
		}

		public void setIsNameAuth(String isNameAuth) {
			this.isNameAuth = isNameAuth;
		}

		/**
		 * @return 产品数量
		 */
		public String getLoanCount() {
			return loanCount;
		}

		public void setLoanCount(String loanCount) {
			this.loanCount = loanCount;
		}

		/**
		 * @return 理财头像路径
		 */
		public String getLogo() {
			return logo;
		}

		public void setLogo(String logo) {
			this.logo = logo;
		}

		/**
		 * @return 用户名称
		 */
		public String getRealName() {
			return realName;
		}

		public void setRealName(String realName) {
			this.realName = realName;
		}

		/**
		 * @return 理财师服务方向
		 */
		public String getServiceDirection() {
			return serviceDirection;
		}

		public void setServiceDirection(String serviceDirection) {
			this.serviceDirection = serviceDirection;
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

	public MyCollectionPersonResponse() {
		super();
		StringBuffer sb = new StringBuffer();
		
		
		String eps = sb.toString();
		if(eps.endsWith(",")){
			eps = eps.substring(0, eps.length() - 1);
		}
		this.setMsgeps(eps);
	}

	public MyCollectionPersonResponse(String statusCode, String statusMessage) {
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