package com.zhijiansihang.finger.gen.service;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.GetLoanDetailRequest;
import com.zhijiansihang.finger.gen.entity.GetLoanDetailResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 获取标详情
 * 
 */
@Component("gengetLoanDetailService")
public class GetLoanDetailService implements MessageService<GetLoanDetailRequest, Response<GetLoanDetailResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(GetLoanDetailService.class);
	private static final String SERVICE_DESC = "获取标详情";

	@Override
	public void execute(GetLoanDetailRequest request, Response<GetLoanDetailResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		response.getBody().setLoanId("1");
		response.getBody().setAdaptationDeadline("1");
		response.getBody().setAmount("1");
		response.getBody().setBeginAmount("1");
		response.getBody().setBrightSpot("");
		response.getBody().setCapitalType("1");
		response.getBody().setCreateTime("1");
		response.getBody().setDistributionRegion("1");
		response.getBody().setEarningDesc("1");
		response.getBody().setFinanceIntroduce("1");
		response.getBody().setFundType("1");
		response.getBody().setHasBuyNum("1");
		response.getBody().setInstitutionUserId("1");
		response.getBody().setInterestRate("1");
		response.getBody().setInvestmentDeadline("1");
		response.getBody().setIsDisplay("1");
		response.getBody().setIsRateFloating("1");
		response.getBody().setIssuer("1");
		response.getBody().setLoanStatus("1");
		response.getBody().setLoanType("1");
		response.getBody().setLocationSize("1");
		response.getBody().setManageRate("1");
		response.getBody().setMoneyUse("1");
		response.getBody().setOrganizeForm("1");
		response.getBody().setProductDesc("1");
		response.getBody().setProductDescFiles("1");
		response.getBody().setProductDirection("1");
		response.getBody().setProductType("1");
		response.getBody().setRatioType("1");
		response.getBody().setRepaySource("1");
		response.getBody().setReserveAmount("1");
		response.getBody().setRiskAlert("1");
		response.getBody().setRiskControl("1");
		response.getBody().setSafeguardWay("1");
		response.getBody().setServicingWay("1");
		response.getBody().setTitle("1");
	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
