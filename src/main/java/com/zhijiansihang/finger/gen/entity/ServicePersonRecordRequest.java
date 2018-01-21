package com.zhijiansihang.finger.gen.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zhijiansihang.finger.mmc.MobileMessage;

/**
 * 点咨询和预约客户.客户端请求
 * 
 * @author 代码生成器v1.0
 * 
 */
 @JsonIgnoreProperties(ignoreUnknown = true)
public class ServicePersonRecordRequest extends MobileMessage {


	private String currentPage;
	private String financeUserid;
	private String pageSize;

	public ServicePersonRecordRequest() {
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
	 * @return 理财师id
	 */
	public String getFinanceUserid() {
		return financeUserid;
	}

	public void setFinanceUserid(String financeUserid) {
		this.financeUserid = financeUserid;
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