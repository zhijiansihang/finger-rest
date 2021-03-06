package com.zhijiansihang.finger.gen.entity;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.zhijiansihang.finger.mmc.MobileMessage;


/**
 * Y我的方案.服务端响应
 * 
 * @author 代码生成器v1.0
 * 
 */
@JsonInclude(Include.NON_NULL)
public class MySolutionResponse extends MobileMessage {


	/**
	 * @see com.zhijiansihang.finger.gen.entity.MySolutionResponse#getSolutionList
	 * 
	 */
	@JsonInclude(Include.NON_NULL)
	public static class SolutionListElement {

		private String createTime;
		private String earningType;
		private String expectedDeadline;
		private String id;
		private String isClosed;
		private String matchDemandCount;
		private String moneySituation;
		private String riskAssessmentLevel;
		private String serialNumber;
		private String solution;

		/**
		 * @return 创建时间
		 */
		public String getCreateTime() {
			return createTime;
		}

		public void setCreateTime(String createTime) {
			this.createTime = createTime;
		}

		/**
		 * @return 收益类型:1:固定收益2:浮动+保底3:浮动收益
		 */
		public String getEarningType() {
			return earningType;
		}

		public void setEarningType(String earningType) {
			this.earningType = earningType;
		}

		/**
		 * @return 期望期限:1:6个月以内2:6到12个月3:12到24个月4:24个月以上
		 */
		public String getExpectedDeadline() {
			return expectedDeadline;
		}

		public void setExpectedDeadline(String expectedDeadline) {
			this.expectedDeadline = expectedDeadline;
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
		 * @return 是否关闭1:为关闭0:未关闭
		 */
		public String getIsClosed() {
			return isClosed;
		}

		public void setIsClosed(String isClosed) {
			this.isClosed = isClosed;
		}

		/**
		 * @return 跑批匹配需求数
		 */
		public String getMatchDemandCount() {
			return matchDemandCount;
		}

		public void setMatchDemandCount(String matchDemandCount) {
			this.matchDemandCount = matchDemandCount;
		}

		/**
		 * @return 我的资金:1:50万以下2:50万到100万3:100万到300万4:300万以上
		 */
		public String getMoneySituation() {
			return moneySituation;
		}

		public void setMoneySituation(String moneySituation) {
			this.moneySituation = moneySituation;
		}

		/**
		 * @return 分险等级
		 */
		public String getRiskAssessmentLevel() {
			return riskAssessmentLevel;
		}

		public void setRiskAssessmentLevel(String riskAssessmentLevel) {
			this.riskAssessmentLevel = riskAssessmentLevel;
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

		/**
		 * @return 投顾方案
		 */
		public String getSolution() {
			return solution;
		}

		public void setSolution(String solution) {
			this.solution = solution;
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

	public MySolutionResponse() {
		super();
		StringBuffer sb = new StringBuffer();
		
		
		String eps = sb.toString();
		if(eps.endsWith(",")){
			eps = eps.substring(0, eps.length() - 1);
		}
		this.setMsgeps(eps);
	}

	public MySolutionResponse(String statusCode, String statusMessage) {
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
	public List<SolutionListElement> getSolutionList() {
		return solutionList;
	}

	public void setSolutionList(List<SolutionListElement> solutionList) {
		this.solutionList = solutionList;
	}

}