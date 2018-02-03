package com.zhijiansihang.finger.gen.entity;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.zhijiansihang.finger.mmc.MobileMessage;


/**
 * 获取标的理财师列表.服务端响应
 * 
 * @author 代码生成器v1.0
 * 
 */
@JsonInclude(Include.NON_NULL)
public class GetLoanFinanceResponse extends MobileMessage {


	/**
	 * @see com.zhijiansihang.finger.gen.entity.GetLoanFinanceResponse#getFinanceList
	 * 
	 */
	@JsonInclude(Include.NON_NULL)
	public static class FinanceListElement {

		private String logo;
		private String realName;
		private String userId;
		private String workAge;

		/**
		 * @return 头像
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

		/**
		 * @return 理财师的userid
		 */
		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		/**
		 * @return 从业年限
		 */
		public String getWorkAge() {
			return workAge;
		}

		public void setWorkAge(String workAge) {
			this.workAge = workAge;
		}
	
		@Override
		public String toString() {
			String str = ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
			return str;
		}
	}

	private List<FinanceListElement> financeList;

	public GetLoanFinanceResponse() {
		super();
		StringBuffer sb = new StringBuffer();
		
		
		String eps = sb.toString();
		if(eps.endsWith(",")){
			eps = eps.substring(0, eps.length() - 1);
		}
		this.setMsgeps(eps);
	}

	public GetLoanFinanceResponse(String statusCode, String statusMessage) {
		this.setStatusCode(statusCode);
		this.setStatusMessage(statusMessage);
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