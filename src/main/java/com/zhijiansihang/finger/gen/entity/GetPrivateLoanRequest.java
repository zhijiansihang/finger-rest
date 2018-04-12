package com.zhijiansihang.finger.gen.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zhijiansihang.finger.mmc.MobileMessage;

/**
 * 获取私募的产品.客户端请求
 * 
 * @author 代码生成器v1.0
 * 
 */
 @JsonIgnoreProperties(ignoreUnknown = true)
public class GetPrivateLoanRequest extends MobileMessage {


	private String capitalType;
	private String currentPage;
	private String fundType;
	private String organizeForm;
	private String sort;

	public GetPrivateLoanRequest() {
		super();
	}	

	/**
	 * @return 1.天使基金；2.创业基金；3.成长基金；4.FOF基金；5.并购基金；6.政府引导基金；7.基础设施基金；8.房地产基金；9.其他 空为全部
	 */
	public String getCapitalType() {
		return capitalType;
	}

	public void setCapitalType(String capitalType) {
		this.capitalType = capitalType;
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
	 * @return 基金类型 1.本土；2.合资；3.外资；4.其他；空为全部
	 */
	public String getFundType() {
		return fundType;
	}

	public void setFundType(String fundType) {
		this.fundType = fundType;
	}

	/**
	 * @return 组织形式1.公司式；2.信托制；3.有限合伙制；4.虚拟式；5.组合式；6.契约式；7.其他； 空为全部
	 */
	public String getOrganizeForm() {
		return organizeForm;
	}

	public void setOrganizeForm(String organizeForm) {
		this.organizeForm = organizeForm;
	}

	/**
	 * @return 0：综合排序   1：按预期收益  2：按投资期限  3：按起投金额
	 */
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
}