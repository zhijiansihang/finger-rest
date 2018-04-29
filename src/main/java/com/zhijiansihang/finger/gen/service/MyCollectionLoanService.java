package com.zhijiansihang.finger.gen.service;

import java.util.ArrayList;
import java.util.List;

import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.MyCollectionLoanRequest;
import com.zhijiansihang.finger.gen.entity.MyCollectionLoanResponse;
import com.zhijiansihang.finger.gen.entity.MyCollectionLoanResponse.LoanListElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 我的收藏标的
 * 
 */
@Component("genmyCollectionLoanService")
public class MyCollectionLoanService implements MessageService<MyCollectionLoanRequest, Response<MyCollectionLoanResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(MyCollectionLoanService.class);
	private static final String SERVICE_DESC = "我的收藏标的";

	@Override
	public void execute(MyCollectionLoanRequest request, Response<MyCollectionLoanResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		response.getBody().setCurrentPage("1");
		response.getBody().setFundType("");
		response.getBody().setPageCount("1");
		response.getBody().setPageSize("10");
		response.getBody().setRecordCount("10");
		response.getBody().setLoanList(getLoanList());
	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}

	private List<LoanListElement> getLoanList() {
		List<LoanListElement> elems = new ArrayList<LoanListElement>();
		LoanListElement elem = new LoanListElement();
		elems.add(elem);

		elem.setAdaptationDeadline("10");
		elem.setBeginAmount("1");
		elem.setBrightSpot("0");
		elem.setFundType("1");
		elem.setId("");
		elem.setInterestRate("10");
		elem.setInvestmentDeadline("10");
		elem.setIsRateFloating("0");
		elem.setLoanId("1");
		elem.setLoanStatus("10");
		elem.setLoanType("1");
		elem.setProductDirection("1");
		elem.setProductType("10");
		elem.setProgress("40");
		elem.setSafeguardWay("1");
		elem.setTitle("1");

		return elems;
	}
}
