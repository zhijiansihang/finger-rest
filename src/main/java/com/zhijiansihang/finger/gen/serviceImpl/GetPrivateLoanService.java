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
		select.setLoanType((byte)1);
		page.setSelect(select);

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
		LoanListElement elem = new LoanListElement();
		elems.add(elem);

		elem.setAdaptationDeadline("10");
		elem.setBeginAmount("1");
		elem.setBrightSpot("0");
		elem.setFundType("1");
		elem.setInterestRate("10");
		elem.setInvestmentDeadline("10");
		elem.setIsRateFloating("0");
		elem.setLoanId("1");
		elem.setLoanStatus("10");
		elem.setLoanType("1");
		elem.setProductType("10");
		elem.setProgress("40");
		elem.setSafeguardWay("1");
		elem.setTitle("1");

		return elems;
	}
}
