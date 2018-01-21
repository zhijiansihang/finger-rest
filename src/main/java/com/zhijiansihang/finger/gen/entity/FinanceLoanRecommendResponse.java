package com.zhijiansihang.finger.gen.entity;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.zhijiansihang.finger.mmc.MobileMessage;


/**
 * 理财师标推荐.服务端响应
 * 
 * @author 代码生成器v1.0
 * 
 */
@JsonInclude(Include.NON_NULL)
public class FinanceLoanRecommendResponse extends MobileMessage {


	/**
	 * @see com.zhijiansihang.finger.gen.entity.FinanceLoanRecommendResponse#getLoanList
	 * 
	 */
	@JsonInclude(Include.NON_NULL)
	public static class LoanListElement {

		private String adaptationDeadline;
		private String beginAmount;
		private String brightSpot;
		private String interestRate;
		private String investmentDeadline;
		private String isRateFloating;
		private String loanId;
		private String loanStatus;
		private String loanType;
		private String productType;
		private String productType;
		private String progress;
		private String safeguardWay;
		private String title;

		/**
		 * @return 续存期限（年）
		 */
		public String getAdaptationDeadline() {
			return adaptationDeadline;
		}

		public void setAdaptationDeadline(String adaptationDeadline) {
			this.adaptationDeadline = adaptationDeadline;
		}

		/**
		 * @return 起头金额
		 */
		public String getBeginAmount() {
			return beginAmount;
		}

		public void setBeginAmount(String beginAmount) {
			this.beginAmount = beginAmount;
		}

		/**
		 * @return 产品卖点（产品亮点）
		 */
		public String getBrightSpot() {
			return brightSpot;
		}

		public void setBrightSpot(String brightSpot) {
			this.brightSpot = brightSpot;
		}

		/**
		 * @return 公墓利率
		 */
		public String getInterestRate() {
			return interestRate;
		}

		public void setInterestRate(String interestRate) {
			this.interestRate = interestRate;
		}

		/**
		 * @return 投资期限（月）
		 */
		public String getInvestmentDeadline() {
			return investmentDeadline;
		}

		public void setInvestmentDeadline(String investmentDeadline) {
			this.investmentDeadline = investmentDeadline;
		}

		/**
		 * @return 公墓是否浮动1位浮动0不浮动
		 */
		public String getIsRateFloating() {
			return isRateFloating;
		}

		public void setIsRateFloating(String isRateFloating) {
			this.isRateFloating = isRateFloating;
		}

		/**
		 * @return 标id
		 */
		public String getLoanId() {
			return loanId;
		}

		public void setLoanId(String loanId) {
			this.loanId = loanId;
		}

		/**
		 * @return 状态
		 */
		public String getLoanStatus() {
			return loanStatus;
		}

		public void setLoanStatus(String loanStatus) {
			this.loanStatus = loanStatus;
		}

		/**
		 * @return （1:公墓，2私募）
		 */
		public String getLoanType() {
			return loanType;
		}

		public void setLoanType(String loanType) {
			this.loanType = loanType;
		}

		/**
		 * @return 产品类型基金类型
		 */
		public String getProductType() {
			return productType;
		}

		public void setProductType(String productType) {
			this.productType = productType;
		}

		/**
		 * @return 产品类型:1.信托；2.资管；3.其他资产,4私募
		 */
		public String getProductType() {
			return productType;
		}

		public void setProductType(String productType) {
			this.productType = productType;
		}

		/**
		 * @return 进度
		 */
		public String getProgress() {
			return progress;
		}

		public void setProgress(String progress) {
			this.progress = progress;
		}

		/**
		 * @return 保障方式
		 */
		public String getSafeguardWay() {
			return safeguardWay;
		}

		public void setSafeguardWay(String safeguardWay) {
			this.safeguardWay = safeguardWay;
		}

		/**
		 * @return 标名称
		 */
		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
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
	private List<LoanListElement> loanList;

	public FinanceLoanRecommendResponse() {
		super();
		StringBuffer sb = new StringBuffer();
		
		
		String eps = sb.toString();
		if(eps.endsWith(",")){
			eps = eps.substring(0, eps.length() - 1);
		}
		this.setMsgeps(eps);
	}

	public FinanceLoanRecommendResponse(String statusCode, String statusMessage) {
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
	public List<LoanListElement> getLoanList() {
		return loanList;
	}

	public void setLoanList(List<LoanListElement> loanList) {
		this.loanList = loanList;
	}

}