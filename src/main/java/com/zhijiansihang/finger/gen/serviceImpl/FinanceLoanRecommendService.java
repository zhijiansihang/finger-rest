package com.zhijiansihang.finger.gen.serviceImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.zhijiansihang.common.ResponseHeader;
import com.zhijiansihang.common.ResponseHeaderBuilder;
import com.zhijiansihang.finger.app.dao.mysql.mapper.LoanDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.LoanDO;
import com.zhijiansihang.finger.app.tool.Page;
import com.zhijiansihang.finger.gen.entity.MyCollectionLoanResponse;
import com.zhijiansihang.finger.gen.tool.CheckTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.FinanceLoanRecommendRequest;
import com.zhijiansihang.finger.gen.entity.FinanceLoanRecommendResponse;
import com.zhijiansihang.finger.gen.entity.FinanceLoanRecommendResponse.LoanListElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 理财师标推荐
 * 
 */
@Component("financeLoanRecommendService")
public class FinanceLoanRecommendService implements MessageService<FinanceLoanRecommendRequest, Response<FinanceLoanRecommendResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(FinanceLoanRecommendService.class);
	private static final String SERVICE_DESC = "理财师标推荐";

	@Autowired
	LoanDAO loanDAO;
	@Override
	public void execute(FinanceLoanRecommendRequest request, Response<FinanceLoanRecommendResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		String currentPage = request.getCurrentPage();
		if (currentPage == null || currentPage.trim().length() ==0){
			currentPage ="1";
		}else {
			currentPage = currentPage.trim();
		}
		String financeUserid = request.getFinanceUserid();
		if (financeUserid == null || financeUserid.trim().length() ==0){
			ResponseHeader responseHeader = ResponseHeaderBuilder.buildValidateError("请求参数financeUserid错误");
			response.setHeader(responseHeader);
			return;
		}else {
			financeUserid = financeUserid.trim();
		}

		Page<Long, LoanDO> page = Page.create();
		page.setCurrentPage(CheckTools.isInteger(request.getCurrentPage()) ? Integer.parseInt(request.getCurrentPage()) : 1);
		page.setPageSize(10);
		page.setSelect(Long.parseLong(financeUserid));

		int count = loanDAO.countByFinanceLoan(page.getSelect());
		page.setRecordCount(count);
		if (count > 0) {
			List<LoanDO> loanDOS = loanDAO.selectByFinanceLoan(page.getSelect(), page.getRowBounds());
			response.getBody().setLoanList(getLoanList(loanDOS));
		} else {
			response.getBody().setLoanList(new ArrayList<>());
		}


		response.getBody().setCurrentPage(page.getCurrentPage() + "");
		response.getBody().setPageCount(page.getPageCount() + "");
		response.getBody().setPageSize(page.getPageSize() + "");
		response.getBody().setRecordCount(page.getRecordCount() + "");
	}

	private List<LoanListElement> getLoanList(List<LoanDO> loanDOS) {
		List<LoanListElement> elems = new ArrayList<LoanListElement>();
		if (loanDOS == null || loanDOS.size() == 0){
			return elems;
		}
		for (LoanDO loanDO : loanDOS){
			LoanListElement elem = new LoanListElement();
			elems.add(elem);

			elem.setAdaptationDeadline(loanDO.getAdaptationDeadline() == null?"":loanDO.getAdaptationDeadline().toString());
			elem.setBeginAmount(loanDO.getBeginAmount()==null?"":loanDO.getBeginAmount().toString());
			elem.setBrightSpot(loanDO.getBrightSpot());
			elem.setInterestRate(loanDO.getInterestRate()==null?"":loanDO.getInterestRate().toString());
			elem.setInvestmentDeadline(loanDO.getInvestmentDeadline()==null?"":loanDO.getInvestmentDeadline().toString());
			elem.setIsRateFloating(loanDO.getIsRateFloating().toString());
			elem.setLoanId(loanDO.getLoanId().toString());
			elem.setLoanStatus(loanDO.getLoanStatus().toString());
			elem.setLoanType(loanDO.getLoanType().toString());
			elem.setProductType(loanDO.getProductType() == null? "":loanDO.getProductType().toString());
			BigDecimal amount = loanDO.getAmount();
			BigDecimal reserveAmount = loanDO.getReserveAmount();
			elem.setProgress(reserveAmount.divide(amount,2, RoundingMode.HALF_UP).toEngineeringString());
			elem.setSafeguardWay(loanDO.getSafeguardWay());
			elem.setTitle(loanDO.getTitle());
			elem.setProductDirection(loanDO.getProductDirection());
			elem.setFundType(loanDO.getFundType() == null ?"":loanDO.getFundType().toString());
		}


		return elems;
	}
}
