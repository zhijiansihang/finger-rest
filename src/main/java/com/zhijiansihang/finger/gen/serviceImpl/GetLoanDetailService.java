package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.app.dao.mysql.mapper.LoanDAO;
import com.zhijiansihang.finger.app.dao.mysql.mapper.LoanInvestorFinanceDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.LoanDO;
import com.zhijiansihang.finger.app.dao.mysql.model.LoanInvestorFinanceDO;
import com.zhijiansihang.finger.gen.entity.GetLoanDetailRequest;
import com.zhijiansihang.finger.gen.entity.GetLoanDetailResponse;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 获取标详情
 */
@Component("getLoanDetailService")
public class GetLoanDetailService implements MessageService<GetLoanDetailRequest, Response<GetLoanDetailResponse>> {

    private static final Logger LOG = LoggerFactory.getLogger(GetLoanDetailService.class);
    private static final String SERVICE_DESC = "获取标详情";

    @Autowired
    LoanDAO loanDAO;
    @Autowired
    LoanInvestorFinanceDAO loanInvestorFinanceDAO;

    private String nullToEmptyString(Object o){
        if (o==null){
            return "";
        }
        return o.toString();
    }
    @Override
    public void execute(GetLoanDetailRequest request, Response<GetLoanDetailResponse> response) {
        LOG.info("[{}][request={}]", SERVICE_DESC, request);
        String loanId = request.getLoanId();
        Long userId = UserTools.getLoginUser().getId();

        LoanDO loanDO = loanDAO.selectByPrimaryKey(Long.parseLong(loanId));
        if (loanDO != null) {

            response.getBody().setLoanId(loanDO.getLoanId().toString());
            response.getBody().setAdaptationDeadline(nullToEmptyString(loanDO.getAdaptationDeadline()));
            response.getBody().setAmount(nullToEmptyString(loanDO.getAmount()));
            response.getBody().setBeginAmount(nullToEmptyString(loanDO.getBeginAmount()));
            response.getBody().setBrightSpot(nullToEmptyString(loanDO.getBrightSpot()));
            response.getBody().setCapitalType(nullToEmptyString(loanDO.getCapitalType()));
            response.getBody().setCreateTime(loanDO.getCreateTime()==null?"":(loanDO.getCreateTime().getTime()+""));
            response.getBody().setDistributionRegion(nullToEmptyString(loanDO.getDistributionRegion()));
            response.getBody().setEarningDesc(nullToEmptyString(loanDO.getEarningDesc()));
            response.getBody().setFinanceIntroduce(nullToEmptyString(loanDO.getFinanceIntroduce()));
            response.getBody().setFundType(nullToEmptyString(loanDO.getFundType()));
            LoanInvestorFinanceDO loanInvestorFinanceDO = new LoanInvestorFinanceDO();
            loanInvestorFinanceDO.setUserId(userId);
            loanInvestorFinanceDO.setLoanId(Long.parseLong(loanId));

            response.getBody().setHasBuyNum(loanInvestorFinanceDAO.countBuy(loanInvestorFinanceDO)+"");
            response.getBody().setInstitutionUserId(nullToEmptyString(loanDO.getInstitutionUserId()));
            response.getBody().setInterestRate(nullToEmptyString(loanDO.getInterestRate()));
            response.getBody().setInvestmentDeadline(nullToEmptyString(loanDO.getInvestmentDeadline()));
            response.getBody().setIsDisplay(nullToEmptyString(loanDO.getIsDisplay()));
            response.getBody().setIsRateFloating(nullToEmptyString(loanDO.getIsRateFloating()));
            response.getBody().setIssuer(nullToEmptyString(loanDO.getIssuer()));
            response.getBody().setLoanStatus(nullToEmptyString(loanDO.getLoanStatus()));
            response.getBody().setLoanType(nullToEmptyString(loanDO.getLoanType()));
            response.getBody().setLocationSize(nullToEmptyString(loanDO.getLocationSize()));
            response.getBody().setManageRate(nullToEmptyString(loanDO.getManageRate()));
            response.getBody().setMoneyUse(nullToEmptyString(loanDO.getMoneyUse()));
            response.getBody().setOrganizeForm(nullToEmptyString(loanDO.getOrganizeForm()));
            response.getBody().setProductDesc(nullToEmptyString(loanDO.getProductDesc()));
            response.getBody().setProductDescFiles(nullToEmptyString(loanDO.getProductDescFiles()));
            response.getBody().setProductDirection(nullToEmptyString(loanDO.getProductDirection()));
            response.getBody().setProductType(nullToEmptyString(loanDO.getProductType()));
            response.getBody().setRatioType(nullToEmptyString(loanDO.getRatioType()));
            response.getBody().setRepaySource(nullToEmptyString(loanDO.getRepaySource()));
            response.getBody().setReserveAmount(nullToEmptyString(loanDO.getReserveAmount()));
            response.getBody().setRiskAlert(nullToEmptyString(loanDO.getRiskAlert()));
            response.getBody().setRiskControl(nullToEmptyString(loanDO.getRiskControl()));
            response.getBody().setSafeguardWay(nullToEmptyString(loanDO.getSafeguardWay()));
            response.getBody().setServicingWay(nullToEmptyString(loanDO.getServicingWay()));
            response.getBody().setTitle(nullToEmptyString(loanDO.getTitle()));
        }
    }
}
