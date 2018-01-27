package com.zhijiansihang.finger.gen.service;

import java.util.ArrayList;
import java.util.List;

import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.MyLoanInvestorRequest;
import com.zhijiansihang.finger.gen.entity.MyLoanInvestorResponse;
import com.zhijiansihang.finger.gen.entity.MyLoanInvestorResponse.LoanInvestorListElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 我的预约
 * 
 */
@Component("genmyLoanInvestorService")
public class MyLoanInvestorService implements MessageService<MyLoanInvestorRequest, Response<MyLoanInvestorResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(MyLoanInvestorService.class);
	private static final String SERVICE_DESC = "我的预约";

	@Override
	public void execute(MyLoanInvestorRequest request, Response<MyLoanInvestorResponse> response) {
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
		elem.setId("1");
		elem.setTitle("1");

		return elems;
	}
}
