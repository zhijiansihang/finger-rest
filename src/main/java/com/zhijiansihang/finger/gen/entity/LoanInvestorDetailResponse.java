package com.zhijiansihang.finger.gen.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.zhijiansihang.finger.mmc.MobileMessage;


/**
 * 预约详情.服务端响应
 * 
 * @author 代码生成器v1.0
 * 
 */
@JsonInclude(Include.NON_NULL)
public class LoanInvestorDetailResponse extends MobileMessage {


	private String amount;
	private String basisIntere;
	private String createTime;
	private String financeRealName;
	private String financeUserId;
	private String investorRealName;
	private String investorUserId;
	private String isDeal;
	private String loanId;
	private String logo;
	private String mobile;
	private String servicingWay;
	private String title;

	public LoanInvestorDetailResponse() {
		super();
		StringBuffer sb = new StringBuffer();
		
		
		String eps = sb.toString();
		if(eps.endsWith(",")){
			eps = eps.substring(0, eps.length() - 1);
		}
		this.setMsgeps(eps);
	}

	public LoanInvestorDetailResponse(String statusCode, String statusMessage) {
		this.setStatusCode(statusCode);
		this.setStatusMessage(statusMessage);
	}


	/**
	 * @return 金额
	 */
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * @return 预期年化收益
	 */
	public String getBasisIntere() {
		return basisIntere;
	}

	public void setBasisIntere(String basisIntere) {
		this.basisIntere = basisIntere;
	}

	/**
	 * @return 预约时间
	 */
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return 理财名字
	 */
	public String getFinanceRealName() {
		return financeRealName;
	}

	public void setFinanceRealName(String financeRealName) {
		this.financeRealName = financeRealName;
	}

	/**
	 * @return 理财userid
	 */
	public String getFinanceUserId() {
		return financeUserId;
	}

	public void setFinanceUserId(String financeUserId) {
		this.financeUserId = financeUserId;
	}

	/**
	 * @return 客户姓名
	 */
	public String getInvestorRealName() {
		return investorRealName;
	}

	public void setInvestorRealName(String investorRealName) {
		this.investorRealName = investorRealName;
	}

	/**
	 * @return 客户userid
	 */
	public String getInvestorUserId() {
		return investorUserId;
	}

	public void setInvestorUserId(String investorUserId) {
		this.investorUserId = investorUserId;
	}

	/**
	 * @return 是否理财师处理
	 */
	public String getIsDeal() {
		return isDeal;
	}

	public void setIsDeal(String isDeal) {
		this.isDeal = isDeal;
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
	 * @return 理财师logo
	 */
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	/**
	 * @return 手机号
	 */
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return 付息方式
	 */
	public String getServicingWay() {
		return servicingWay;
	}

	public void setServicingWay(String servicingWay) {
		this.servicingWay = servicingWay;
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

}