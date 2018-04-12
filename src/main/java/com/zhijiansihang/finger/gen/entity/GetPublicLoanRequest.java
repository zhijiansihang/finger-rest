package com.zhijiansihang.finger.gen.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zhijiansihang.finger.mmc.MobileMessage;

/**
 * 获取公募产品列表.客户端请求
 * 
 * @author 代码生成器v1.0
 * 
 */
 @JsonIgnoreProperties(ignoreUnknown = true)
public class GetPublicLoanRequest extends MobileMessage {


	private String currentPage;
	private String investmentDeadline;
	private String productDirection;
	private String productType;
	private String ratioType;
	private String servicingWay;
	private String sort;

	public GetPublicLoanRequest() {
		super();
	}	

	/**
	 * @return 当前页数
	 */
	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return 投资期限：空：全部、1：12个月以内、2：13~23个月:3：24个月、4：24个月以上
	 */
	public String getInvestmentDeadline() {
		return investmentDeadline;
	}

	public void setInvestmentDeadline(String investmentDeadline) {
		this.investmentDeadline = investmentDeadline;
	}

	/**
	 * @return （投资方向）产品方向：1.工商企业；2.金融市场；3.基础设施；4.房地产；5.资金池；6.其他； 空位全部
	 */
	public String getProductDirection() {
		return productDirection;
	}

	public void setProductDirection(String productDirection) {
		this.productDirection = productDirection;
	}

	/**
	 * @return 公墓类型：产品类型：1.信托；2.资管；3.其他资产；必填
	 */
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	/**
	 * @return 大小配比:1.小额畅打；2.已配出小额；3.严格配比；4.全大额 传空为全部
	 */
	public String getRatioType() {
		return ratioType;
	}

	public void setRatioType(String ratioType) {
		this.ratioType = ratioType;
	}

	/**
	 * @return 付息方式:1.按月付息；2.按季付息；3.半年付息；4.按年付息；5.到期付息；6.其他 空为全部
	 */
	public String getServicingWay() {
		return servicingWay;
	}

	public void setServicingWay(String servicingWay) {
		this.servicingWay = servicingWay;
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