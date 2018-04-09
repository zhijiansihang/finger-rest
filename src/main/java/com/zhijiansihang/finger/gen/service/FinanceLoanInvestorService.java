package com.zhijiansihang.finger.gen.service;

import java.util.ArrayList;
import java.util.List;

import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.FinanceLoanInvestorRequest;
import com.zhijiansihang.finger.gen.entity.FinanceLoanInvestorResponse;
import com.zhijiansihang.finger.gen.entity.FinanceLoanInvestorResponse.LoanInvestorListElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Y理财师查看属于预约自己的记录
 * 
 */
@Component("genfinanceLoanInvestorService")
public class FinanceLoanInvestorService implements MessageService<FinanceLoanInvestorRequest, Response<FinanceLoanInvestorResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(FinanceLoanInvestorService.class);
	private static final String SERVICE_DESC = "Y理财师查看属于预约自己的记录";

	@Override
	public void execute(FinanceLoanInvestorRequest request, Response<FinanceLoanInvestorResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		response.getBody().setCurrentPage("1");
		response.getBody().setPageCount("1");
		response.getBody().setPageSize("10");
		response.getBody().setRecordCount("10");
		response.getBody().setLoanInvestorList(getLoanInvestorList());
	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}

	private List<LoanInvestorListElement> getLoanInvestorList() {
		List<LoanInvestorListElement> elems = new ArrayList<LoanInvestorListElement>();
		LoanInvestorListElement elem = new LoanInvestorListElement();
		elems.add(elem);

		elem.setAmount("2017-12-12");
		elem.setCreatetime("2017-01-01");
		elem.setId("1");
		elem.setLogo("1");
		elem.setRealName("2017-12-12");
		elem.setTitle("1");

		return elems;
	}
}
