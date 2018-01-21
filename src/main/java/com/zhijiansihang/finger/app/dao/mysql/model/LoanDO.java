package com.zhijiansihang.finger.app.dao.mysql.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LoanDO implements Serializable {
    /**
     * 标id
     */
    private Long loanId;

    /**
     * 所属机构id即userid
     */
    private Long institutionUserId;

    /**
     * 产品名称
     */
    private String title;

    /**
     * 1:公墓，2私募
     */
    private Byte loanType;

    /**
     * 产品类型:1.信托；2.资管；3.其他资产, 4私募
     */
    private Short productType;

    /**
     * 投资规模
     */
    private BigDecimal amount;

    /**
     * 公墓利率
     */
    private BigDecimal interestRate;

    /**
     * 公墓是否浮动 1位浮动 0 不浮动
     */
    private Byte isRateFloating;

    /**
     * 已预约金额
     */
    private BigDecimal reserveAmount;

    /**
     * 机构操作：100 初始化审核中 200募集中 300 结束 400 已删除
     */
    private Short loanStatus;

    /**
     * 是否前台显示 1位显示 0 不显示
     */
    private Byte isDisplay;

    /**
     * 置顶功能,值越大，显示越靠前
     */
    private Integer locationSize;

    /**
     * 产品方向（投资方向）
     */
    private String productDirection;

    /**
     * 保障方式
     */
    private String safeguardWay;

    /**
     * 起投金额
     */
    private BigDecimal beginAmount;

    /**
     * 收益描述
     */
    private String earningDesc;

    /**
     * 发行机构
     */
    private String issuer;

    /**
     * 基金类型:1.本土；2.合资；3.外资；4.其他；
     */
    private Short fundType;

    /**
     * 付息方式:1.按月付息；2.按季付息；3.半年付息；4.按年付息；5.到期付息；6.其他
     */
    private Short servicingWay;

    /**
     * 续存期限（年）
     */
    private Short adaptationDeadline;

    /**
     * 投资期限（月）
     */
    private Short investmentDeadline;

    /**
     * 发行地区
     */
    private String distributionRegion;

    /**
     * 大小配比:1.小额畅打；2.已配出小额；3.严格配比；4.全大额
     */
    private Short ratioType;

    /**
     * 产品卖点（产品亮点）
     */
    private String brightSpot;

    /**
     * 融资方介绍
     */
    private String financeIntroduce;

    /**
     * 资金用途
     */
    private String moneyUse;

    /**
     * 还款来源
     */
    private String repaySource;

    /**
     * 风险控制
     */
    private String riskControl;

    /**
     * 项目说明
     */
    private String productDesc;

    /**
     * 项目文件名称列表json
     */
    private String productDescFiles;

    /**
     * 风险提示
     */
    private String riskAlert;

    /**
     * 资本类型
     */
    private String capitalType;

    /**
     * 组织形式
     */
    private String organizeForm;

    /**
     * 管理费率
     */
    private BigDecimal manageRate;

    /**
     * 审核结果
     */
    private String reviewCode;

    /**
     * 审核描述
     */
    private String reviewDesc;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * loan
     */
    private static final long serialVersionUID = 1L;

    /**
     * 标id
     * @return loan_id 标id
     */
    public Long getLoanId() {
        return loanId;
    }

    /**
     * 标id
     * @param loanId 标id
     */
    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    /**
     * 所属机构id即userid
     * @return institution_user_id 所属机构id即userid
     */
    public Long getInstitutionUserId() {
        return institutionUserId;
    }

    /**
     * 所属机构id即userid
     * @param institutionUserId 所属机构id即userid
     */
    public void setInstitutionUserId(Long institutionUserId) {
        this.institutionUserId = institutionUserId;
    }

    /**
     * 产品名称
     * @return title 产品名称
     */
    public String getTitle() {
        return title;
    }

    /**
     * 产品名称
     * @param title 产品名称
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 1:公墓，2私募
     * @return loan_type 1:公墓，2私募
     */
    public Byte getLoanType() {
        return loanType;
    }

    /**
     * 1:公墓，2私募
     * @param loanType 1:公墓，2私募
     */
    public void setLoanType(Byte loanType) {
        this.loanType = loanType;
    }

    /**
     * 产品类型:1.信托；2.资管；3.其他资产, 4私募
     * @return product_type 产品类型:1.信托；2.资管；3.其他资产, 4私募
     */
    public Short getProductType() {
        return productType;
    }

    /**
     * 产品类型:1.信托；2.资管；3.其他资产, 4私募
     * @param productType 产品类型:1.信托；2.资管；3.其他资产, 4私募
     */
    public void setProductType(Short productType) {
        this.productType = productType;
    }

    /**
     * 投资规模
     * @return amount 投资规模
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 投资规模
     * @param amount 投资规模
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 公墓利率
     * @return interest_rate 公墓利率
     */
    public BigDecimal getInterestRate() {
        return interestRate;
    }

    /**
     * 公墓利率
     * @param interestRate 公墓利率
     */
    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * 公墓是否浮动 1位浮动 0 不浮动
     * @return is_rate_floating 公墓是否浮动 1位浮动 0 不浮动
     */
    public Byte getIsRateFloating() {
        return isRateFloating;
    }

    /**
     * 公墓是否浮动 1位浮动 0 不浮动
     * @param isRateFloating 公墓是否浮动 1位浮动 0 不浮动
     */
    public void setIsRateFloating(Byte isRateFloating) {
        this.isRateFloating = isRateFloating;
    }

    /**
     * 已预约金额
     * @return reserve_amount 已预约金额
     */
    public BigDecimal getReserveAmount() {
        return reserveAmount;
    }

    /**
     * 已预约金额
     * @param reserveAmount 已预约金额
     */
    public void setReserveAmount(BigDecimal reserveAmount) {
        this.reserveAmount = reserveAmount;
    }

    /**
     * 机构操作：100 初始化审核中 200募集中 300 结束 400 已删除
     * @return loan_status 机构操作：100 初始化审核中 200募集中 300 结束 400 已删除
     */
    public Short getLoanStatus() {
        return loanStatus;
    }

    /**
     * 机构操作：100 初始化审核中 200募集中 300 结束 400 已删除
     * @param loanStatus 机构操作：100 初始化审核中 200募集中 300 结束 400 已删除
     */
    public void setLoanStatus(Short loanStatus) {
        this.loanStatus = loanStatus;
    }

    /**
     * 是否前台显示 1位显示 0 不显示
     * @return is_display 是否前台显示 1位显示 0 不显示
     */
    public Byte getIsDisplay() {
        return isDisplay;
    }

    /**
     * 是否前台显示 1位显示 0 不显示
     * @param isDisplay 是否前台显示 1位显示 0 不显示
     */
    public void setIsDisplay(Byte isDisplay) {
        this.isDisplay = isDisplay;
    }

    /**
     * 置顶功能,值越大，显示越靠前
     * @return location_size 置顶功能,值越大，显示越靠前
     */
    public Integer getLocationSize() {
        return locationSize;
    }

    /**
     * 置顶功能,值越大，显示越靠前
     * @param locationSize 置顶功能,值越大，显示越靠前
     */
    public void setLocationSize(Integer locationSize) {
        this.locationSize = locationSize;
    }

    /**
     * 产品方向（投资方向）
     * @return product_direction 产品方向（投资方向）
     */
    public String getProductDirection() {
        return productDirection;
    }

    /**
     * 产品方向（投资方向）
     * @param productDirection 产品方向（投资方向）
     */
    public void setProductDirection(String productDirection) {
        this.productDirection = productDirection == null ? null : productDirection.trim();
    }

    /**
     * 保障方式
     * @return safeguard_way 保障方式
     */
    public String getSafeguardWay() {
        return safeguardWay;
    }

    /**
     * 保障方式
     * @param safeguardWay 保障方式
     */
    public void setSafeguardWay(String safeguardWay) {
        this.safeguardWay = safeguardWay == null ? null : safeguardWay.trim();
    }

    /**
     * 起投金额
     * @return begin_amount 起投金额
     */
    public BigDecimal getBeginAmount() {
        return beginAmount;
    }

    /**
     * 起投金额
     * @param beginAmount 起投金额
     */
    public void setBeginAmount(BigDecimal beginAmount) {
        this.beginAmount = beginAmount;
    }

    /**
     * 收益描述
     * @return earning_desc 收益描述
     */
    public String getEarningDesc() {
        return earningDesc;
    }

    /**
     * 收益描述
     * @param earningDesc 收益描述
     */
    public void setEarningDesc(String earningDesc) {
        this.earningDesc = earningDesc == null ? null : earningDesc.trim();
    }

    /**
     * 发行机构
     * @return issuer 发行机构
     */
    public String getIssuer() {
        return issuer;
    }

    /**
     * 发行机构
     * @param issuer 发行机构
     */
    public void setIssuer(String issuer) {
        this.issuer = issuer == null ? null : issuer.trim();
    }

    /**
     * 基金类型:1.本土；2.合资；3.外资；4.其他；
     * @return fund_type 基金类型:1.本土；2.合资；3.外资；4.其他；
     */
    public Short getFundType() {
        return fundType;
    }

    /**
     * 基金类型:1.本土；2.合资；3.外资；4.其他；
     * @param fundType 基金类型:1.本土；2.合资；3.外资；4.其他；
     */
    public void setFundType(Short fundType) {
        this.fundType = fundType;
    }

    /**
     * 付息方式:1.按月付息；2.按季付息；3.半年付息；4.按年付息；5.到期付息；6.其他
     * @return servicing_way 付息方式:1.按月付息；2.按季付息；3.半年付息；4.按年付息；5.到期付息；6.其他
     */
    public Short getServicingWay() {
        return servicingWay;
    }

    /**
     * 付息方式:1.按月付息；2.按季付息；3.半年付息；4.按年付息；5.到期付息；6.其他
     * @param servicingWay 付息方式:1.按月付息；2.按季付息；3.半年付息；4.按年付息；5.到期付息；6.其他
     */
    public void setServicingWay(Short servicingWay) {
        this.servicingWay = servicingWay;
    }

    /**
     * 续存期限（年）
     * @return adaptation_deadline 续存期限（年）
     */
    public Short getAdaptationDeadline() {
        return adaptationDeadline;
    }

    /**
     * 续存期限（年）
     * @param adaptationDeadline 续存期限（年）
     */
    public void setAdaptationDeadline(Short adaptationDeadline) {
        this.adaptationDeadline = adaptationDeadline;
    }

    /**
     * 投资期限（月）
     * @return investment_deadline 投资期限（月）
     */
    public Short getInvestmentDeadline() {
        return investmentDeadline;
    }

    /**
     * 投资期限（月）
     * @param investmentDeadline 投资期限（月）
     */
    public void setInvestmentDeadline(Short investmentDeadline) {
        this.investmentDeadline = investmentDeadline;
    }

    /**
     * 发行地区
     * @return distribution_region 发行地区
     */
    public String getDistributionRegion() {
        return distributionRegion;
    }

    /**
     * 发行地区
     * @param distributionRegion 发行地区
     */
    public void setDistributionRegion(String distributionRegion) {
        this.distributionRegion = distributionRegion == null ? null : distributionRegion.trim();
    }

    /**
     * 大小配比:1.小额畅打；2.已配出小额；3.严格配比；4.全大额
     * @return ratio_type 大小配比:1.小额畅打；2.已配出小额；3.严格配比；4.全大额
     */
    public Short getRatioType() {
        return ratioType;
    }

    /**
     * 大小配比:1.小额畅打；2.已配出小额；3.严格配比；4.全大额
     * @param ratioType 大小配比:1.小额畅打；2.已配出小额；3.严格配比；4.全大额
     */
    public void setRatioType(Short ratioType) {
        this.ratioType = ratioType;
    }

    /**
     * 产品卖点（产品亮点）
     * @return bright_spot 产品卖点（产品亮点）
     */
    public String getBrightSpot() {
        return brightSpot;
    }

    /**
     * 产品卖点（产品亮点）
     * @param brightSpot 产品卖点（产品亮点）
     */
    public void setBrightSpot(String brightSpot) {
        this.brightSpot = brightSpot == null ? null : brightSpot.trim();
    }

    /**
     * 融资方介绍
     * @return finance_introduce 融资方介绍
     */
    public String getFinanceIntroduce() {
        return financeIntroduce;
    }

    /**
     * 融资方介绍
     * @param financeIntroduce 融资方介绍
     */
    public void setFinanceIntroduce(String financeIntroduce) {
        this.financeIntroduce = financeIntroduce == null ? null : financeIntroduce.trim();
    }

    /**
     * 资金用途
     * @return money_use 资金用途
     */
    public String getMoneyUse() {
        return moneyUse;
    }

    /**
     * 资金用途
     * @param moneyUse 资金用途
     */
    public void setMoneyUse(String moneyUse) {
        this.moneyUse = moneyUse == null ? null : moneyUse.trim();
    }

    /**
     * 还款来源
     * @return repay_source 还款来源
     */
    public String getRepaySource() {
        return repaySource;
    }

    /**
     * 还款来源
     * @param repaySource 还款来源
     */
    public void setRepaySource(String repaySource) {
        this.repaySource = repaySource == null ? null : repaySource.trim();
    }

    /**
     * 风险控制
     * @return risk_control 风险控制
     */
    public String getRiskControl() {
        return riskControl;
    }

    /**
     * 风险控制
     * @param riskControl 风险控制
     */
    public void setRiskControl(String riskControl) {
        this.riskControl = riskControl == null ? null : riskControl.trim();
    }

    /**
     * 项目说明
     * @return product_desc 项目说明
     */
    public String getProductDesc() {
        return productDesc;
    }

    /**
     * 项目说明
     * @param productDesc 项目说明
     */
    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc == null ? null : productDesc.trim();
    }

    /**
     * 项目文件名称列表json
     * @return product_desc_files 项目文件名称列表json
     */
    public String getProductDescFiles() {
        return productDescFiles;
    }

    /**
     * 项目文件名称列表json
     * @param productDescFiles 项目文件名称列表json
     */
    public void setProductDescFiles(String productDescFiles) {
        this.productDescFiles = productDescFiles == null ? null : productDescFiles.trim();
    }

    /**
     * 风险提示
     * @return risk_alert 风险提示
     */
    public String getRiskAlert() {
        return riskAlert;
    }

    /**
     * 风险提示
     * @param riskAlert 风险提示
     */
    public void setRiskAlert(String riskAlert) {
        this.riskAlert = riskAlert == null ? null : riskAlert.trim();
    }

    /**
     * 资本类型
     * @return capital_type 资本类型
     */
    public String getCapitalType() {
        return capitalType;
    }

    /**
     * 资本类型
     * @param capitalType 资本类型
     */
    public void setCapitalType(String capitalType) {
        this.capitalType = capitalType == null ? null : capitalType.trim();
    }

    /**
     * 组织形式
     * @return organize_form 组织形式
     */
    public String getOrganizeForm() {
        return organizeForm;
    }

    /**
     * 组织形式
     * @param organizeForm 组织形式
     */
    public void setOrganizeForm(String organizeForm) {
        this.organizeForm = organizeForm == null ? null : organizeForm.trim();
    }

    /**
     * 管理费率
     * @return manage_rate 管理费率
     */
    public BigDecimal getManageRate() {
        return manageRate;
    }

    /**
     * 管理费率
     * @param manageRate 管理费率
     */
    public void setManageRate(BigDecimal manageRate) {
        this.manageRate = manageRate;
    }

    /**
     * 审核结果
     * @return review_code 审核结果
     */
    public String getReviewCode() {
        return reviewCode;
    }

    /**
     * 审核结果
     * @param reviewCode 审核结果
     */
    public void setReviewCode(String reviewCode) {
        this.reviewCode = reviewCode == null ? null : reviewCode.trim();
    }

    /**
     * 审核描述
     * @return review_desc 审核描述
     */
    public String getReviewDesc() {
        return reviewDesc;
    }

    /**
     * 审核描述
     * @param reviewDesc 审核描述
     */
    public void setReviewDesc(String reviewDesc) {
        this.reviewDesc = reviewDesc == null ? null : reviewDesc.trim();
    }

    /**
     * 更新时间
     * @return update_time 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", loanId=").append(loanId);
        sb.append(", institutionUserId=").append(institutionUserId);
        sb.append(", title=").append(title);
        sb.append(", loanType=").append(loanType);
        sb.append(", productType=").append(productType);
        sb.append(", amount=").append(amount);
        sb.append(", interestRate=").append(interestRate);
        sb.append(", isRateFloating=").append(isRateFloating);
        sb.append(", reserveAmount=").append(reserveAmount);
        sb.append(", loanStatus=").append(loanStatus);
        sb.append(", isDisplay=").append(isDisplay);
        sb.append(", locationSize=").append(locationSize);
        sb.append(", productDirection=").append(productDirection);
        sb.append(", safeguardWay=").append(safeguardWay);
        sb.append(", beginAmount=").append(beginAmount);
        sb.append(", earningDesc=").append(earningDesc);
        sb.append(", issuer=").append(issuer);
        sb.append(", fundType=").append(fundType);
        sb.append(", servicingWay=").append(servicingWay);
        sb.append(", adaptationDeadline=").append(adaptationDeadline);
        sb.append(", investmentDeadline=").append(investmentDeadline);
        sb.append(", distributionRegion=").append(distributionRegion);
        sb.append(", ratioType=").append(ratioType);
        sb.append(", brightSpot=").append(brightSpot);
        sb.append(", financeIntroduce=").append(financeIntroduce);
        sb.append(", moneyUse=").append(moneyUse);
        sb.append(", repaySource=").append(repaySource);
        sb.append(", riskControl=").append(riskControl);
        sb.append(", productDesc=").append(productDesc);
        sb.append(", productDescFiles=").append(productDescFiles);
        sb.append(", riskAlert=").append(riskAlert);
        sb.append(", capitalType=").append(capitalType);
        sb.append(", organizeForm=").append(organizeForm);
        sb.append(", manageRate=").append(manageRate);
        sb.append(", reviewCode=").append(reviewCode);
        sb.append(", reviewDesc=").append(reviewDesc);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}