package com.zhijiansihang.finger.gen.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zhijiansihang.finger.mmc.MobileMessage;

/**
 * 需求所匹配的方案列表.客户端请求
 * 
 * @author 代码生成器v1.0
 * 
 */
 @JsonIgnoreProperties(ignoreUnknown = true)
public class SingleDemandSolutionListRequest extends MobileMessage {


	private String currentPage;
	private String demandId;
	private String type;

	public SingleDemandSolutionListRequest() {
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
	 * @return 需求id
	 */
	public String getDemandId() {
		return demandId;
	}

	public void setDemandId(String demandId) {
		this.demandId = demandId;
	}

	/**
	 * @return 0:未读，1已读，2已采纳
	 */
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}