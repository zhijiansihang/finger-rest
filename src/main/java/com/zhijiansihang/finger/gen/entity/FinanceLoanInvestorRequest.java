package com.zhijiansihang.finger.gen.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zhijiansihang.finger.mmc.MobileMessage;

/**
 * 理财师查看属于预约自己的记录.客户端请求
 * 
 * @author 代码生成器v1.0
 * 
 */
 @JsonIgnoreProperties(ignoreUnknown = true)
public class FinanceLoanInvestorRequest extends MobileMessage {


	private String currentPage;
	private String isDeal;
	private String pageSize;

	public FinanceLoanInvestorRequest() {
		super();
	}	

	/**
	 * @return 第几页
	 */
	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return 1:已处理0:处理中
	 */
	public String getIsDeal() {
		return isDeal;
	}

	public void setIsDeal(String isDeal) {
		this.isDeal = isDeal;
	}

	/**
	 * @return 一页的条数
	 */
	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	
}