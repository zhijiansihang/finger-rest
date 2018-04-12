package com.zhijiansihang.finger.gen.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.zhijiansihang.finger.mmc.MobileMessage;


/**
 * 获取标详情.服务端响应
 * 
 * @author 代码生成器v1.0
 * 
 */
@JsonInclude(Include.NON_NULL)
public class GetLoanDetailResponse extends MobileMessage {


	private String LoanId;
	private String adaptationDeadline;
	private String amount;
	private String beginAmount;
	private String brightSpot;
	private String capitalType;
	private String createTime;
	private String distributionRegion;
	private String earningDesc;
	private String financeIntroduce;
	private String fundType;
	private String hasBuyNum;
	private String institutionUserId;
	private String interestRate;
	private String investmentDeadline;
	private String isDisplay;
	private String isRateFloating;
	private String issuer;
	private String loanStatus;
	private String loanType;
	private String locationSize;
	private String manageRate;
	private String moneyUse;
	private String organizeForm;
	private String productDesc;
	private String productDescFiles;
	private String productDirection;
	private String productType;
	private String ratioType;
	private String repaySource;
	private String reserveAmount;
	private String riskAlert;
	private String riskControl;
	private String safeguardWay;
	private String servicingWay;
	private String title;

	public GetLoanDetailResponse() {
		super();
		StringBuffer sb = new StringBuffer();
		
		
		String eps = sb.toString();
		if(eps.endsWith(",")){
			eps = eps.substring(0, eps.length() - 1);
		}
		this.setMsgeps(eps);
	}

	public GetLoanDetailResponse(String statusCode, String statusMessage) {
		this.setStatusCode(statusCode);
		this.setStatusMessage(statusMessage);
	}


	/**
	 * @return 标id
	 */
	public String getLoanId() {
		return LoanId;
	}

	public void setLoanId(String LoanId) {
		this.LoanId = LoanId;
	}

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
	 * @return 投资规模
	 */
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * @return 起投金额
	 */
	public String getBeginAmount() {
		return beginAmount;
	}

	public void setBeginAmount(String beginAmount) {
		this.beginAmount = beginAmount;
	}

	/**
	 * @return 产品优势（产品亮点）
	 */
	public String getBrightSpot() {
		return brightSpot;
	}

	public void setBrightSpot(String brightSpot) {
		this.brightSpot = brightSpot;
	}

	/**
	 * @return 资本类型
	 */
	public String getCapitalType() {
		return capitalType;
	}

	public void setCapitalType(String capitalType) {
		this.capitalType = capitalType;
	}

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
	 * @return 发行地区
	 */
	public String getDistributionRegion() {
		return distributionRegion;
	}

	public void setDistributionRegion(String distributionRegion) {
		this.distributionRegion = distributionRegion;
	}

	/**
	 * @return 收益描述
	 */
	public String getEarningDesc() {
		return earningDesc;
	}

	public void setEarningDesc(String earningDesc) {
		this.earningDesc = earningDesc;
	}

	/**
	 * @return 融资方介绍
	 */
	public String getFinanceIntroduce() {
		return financeIntroduce;
	}

	public void setFinanceIntroduce(String financeIntroduce) {
		this.financeIntroduce = financeIntroduce;
	}

	/**
	 * @return 基金类型:1.本土；2.合资；3.外资；4.其他；
	 */
	public String getFundType() {
		return fundType;
	}

	public void setFundType(String fundType) {
		this.fundType = fundType;
	}

	/**
	 * @return 已经购买该标的次数
	 */
	public String getHasBuyNum() {
		return hasBuyNum;
	}

	public void setHasBuyNum(String hasBuyNum) {
		this.hasBuyNum = hasBuyNum;
	}

	/**
	 * @return 所属机构id即userid
	 */
	public String getInstitutionUserId() {
		return institutionUserId;
	}

	public void setInstitutionUserId(String institutionUserId) {
		this.institutionUserId = institutionUserId;
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
	 * @return 是否前台显示1位显示0不显示
	 */
	public String getIsDisplay() {
		return isDisplay;
	}

	public void setIsDisplay(String isDisplay) {
		this.isDisplay = isDisplay;
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
	 * @return 发行机构
	 */
	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	/**
	 * @return 机构操作：100初始化审核中200募集中300结束400已删除
	 */
	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

	/**
	 * @return 1:公墓，2私募
	 */
	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	/**
	 * @return 置顶功能,值越大，显示越靠前
	 */
	public String getLocationSize() {
		return locationSize;
	}

	public void setLocationSize(String locationSize) {
		this.locationSize = locationSize;
	}

	/**
	 * @return 管理费率
	 */
	public String getManageRate() {
		return manageRate;
	}

	public void setManageRate(String manageRate) {
		this.manageRate = manageRate;
	}

	/**
	 * @return 资金用途
	 */
	public String getMoneyUse() {
		return moneyUse;
	}

	public void setMoneyUse(String moneyUse) {
		this.moneyUse = moneyUse;
	}

	/**
	 * @return 组织形式
	 */
	public String getOrganizeForm() {
		return organizeForm;
	}

	public void setOrganizeForm(String organizeForm) {
		this.organizeForm = organizeForm;
	}

	/**
	 * @return 项目说明
	 */
	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	/**
	 * @return 项目文件名称列表json
	 */
	public String getProductDescFiles() {
		return productDescFiles;
	}

	public void setProductDescFiles(String productDescFiles) {
		this.productDescFiles = productDescFiles;
	}

	/**
	 * @return 产品方向（投资方向）产品方向：1.工商企业；2.金融市场；3.基础设施；4.房地产；5.资金池；6.其他；
	 */
	public String getProductDirection() {
		return productDirection;
	}

	public void setProductDirection(String productDirection) {
		this.productDirection = productDirection;
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
	 * @return 大小配比:1.小额畅打；2.已配出小额；3.严格配比；4.全大额
	 */
	public String getRatioType() {
		return ratioType;
	}

	public void setRatioType(String ratioType) {
		this.ratioType = ratioType;
	}

	/**
	 * @return 还款来源
	 */
	public String getRepaySource() {
		return repaySource;
	}

	public void setRepaySource(String repaySource) {
		this.repaySource = repaySource;
	}

	/**
	 * @return 已预约金额
	 */
	public String getReserveAmount() {
		return reserveAmount;
	}

	public void setReserveAmount(String reserveAmount) {
		this.reserveAmount = reserveAmount;
	}

	/**
	 * @return 风险提示
	 */
	public String getRiskAlert() {
		return riskAlert;
	}

	public void setRiskAlert(String riskAlert) {
		this.riskAlert = riskAlert;
	}

	/**
	 * @return 风险控制
	 */
	public String getRiskControl() {
		return riskControl;
	}

	public void setRiskControl(String riskControl) {
		this.riskControl = riskControl;
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
	 * @return 付息方式:1.按月付息；2.按季付息；3.半年付息；4.按年付息；5.到期付息；6.其他
	 */
	public String getServicingWay() {
		return servicingWay;
	}

	public void setServicingWay(String servicingWay) {
		this.servicingWay = servicingWay;
	}

	/**
	 * @return 产品名称
	 */
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}