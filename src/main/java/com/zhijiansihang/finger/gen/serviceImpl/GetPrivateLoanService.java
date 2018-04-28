package com.zhijiansihang.finger.gen.serviceImpl;

import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.app.dao.mysql.mapper.LoanDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.CmsDO;
import com.zhijiansihang.finger.app.dao.mysql.model.LoanDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import com.zhijiansihang.finger.app.tool.Page;
import com.zhijiansihang.finger.gen.entity.GetPrivateLoanRequest;
import com.zhijiansihang.finger.gen.entity.GetPrivateLoanResponse;
import com.zhijiansihang.finger.gen.entity.GetPrivateLoanResponse.LoanListElement;
import com.zhijiansihang.finger.gen.tool.CheckTools;
import com.zhijiansihang.finger.mmc.MessageService;
import org.apache.ibatis.jdbc.Null;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取私募的产品
 * 
 */
@Component("getPrivateLoanService")
public class GetPrivateLoanService implements MessageService<GetPrivateLoanRequest, Response<GetPrivateLoanResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(GetPrivateLoanService.class);
	private static final String SERVICE_DESC = "获取私募的产品";

	@Autowired
	LoanDAO loanDAO;
	@Override
	public void execute(GetPrivateLoanRequest request, Response<GetPrivateLoanResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		//资本类型
		String capitalType = request.getCapitalType();
		if (capitalType == null || capitalType.trim().length() ==0){
			capitalType = null;
		}else {
			capitalType = capitalType.trim();
		}
		String currentPage = request.getCurrentPage();
		if (currentPage == null || currentPage.trim().length() ==0){
			currentPage ="1";
		}else {
			currentPage = currentPage.trim();
		}

		//0：综合排序 1：按预期收益 2：按投资期限 3：按起投金额
		String requestSort = request.getSort();
		if (requestSort== null || requestSort.length() == 0){
			requestSort = "0";
		}



		//基金类型
		String fundType = request.getFundType();
		if (fundType == null || fundType.trim().length() ==0){
			fundType = null;
		}else {
			fundType = fundType.trim();
		}
		//组织形式
		String organizeForm = request.getOrganizeForm();
		if (organizeForm == null || organizeForm.trim().length() ==0){
			organizeForm = null;
		}else {
			organizeForm = organizeForm.trim();
		}

		Page<LoanDO, LoanDO> page = Page.create();
		page.setCurrentPage(CheckTools.isInteger(request.getCurrentPage()) ? Integer.parseInt(request.getCurrentPage()) : 1);
		page.setPageSize(10);
		LoanDO select = new LoanDO();
		select.setCapitalType(capitalType);
		select.setFundType(fundType==null?null:Short.parseShort(fundType));
		select.setOrganizeForm(organizeForm);
		/**
		 * 1:公墓，2私募
		 */
		select.setLoanType((byte)2);
		page.setSelect(select);
		if (requestSort.equals("3")){
			//3：按起投金额
			select.setRequestSort(",begin_amount desc ");
		}else {
			select.setRequestSort(",release_time desc ");
		}

		int count = loanDAO.countByLoan(select);
		page.setRecordCount(count);
		if (count > 0) {
			List<LoanDO> loanDOS = loanDAO.selectByLoan(select, page.getRowBounds());
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
		}


		return elems;
	}

}
