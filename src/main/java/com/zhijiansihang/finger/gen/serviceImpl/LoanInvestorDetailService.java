package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.LoanInvestorDetailRequest;
import com.zhijiansihang.finger.gen.entity.LoanInvestorDetailResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 预约详情
 * 
 */
@Component("loanInvestorDetailService")
public class LoanInvestorDetailService implements MessageService<LoanInvestorDetailRequest, Response<LoanInvestorDetailResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(LoanInvestorDetailService.class);
	private static final String SERVICE_DESC = "预约详情";

	@Override
	public void execute(LoanInvestorDetailRequest request, Response<LoanInvestorDetailResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		response.getBody().setAmount("10");
		response.getBody().setBasisIntere("1");
		response.getBody().setCreateTime("1");
		response.getBody().setFinanceRealName("11");
		response.getBody().setFinanceUserId("11");
		response.getBody().setInvestorRealName("1");
		response.getBody().setInvestorUserId("1");
		response.getBody().setIsDeal("1");
		response.getBody().setLoanId("10");
		response.getBody().setLogo("11");
		response.getBody().setMobile("10");
		response.getBody().setServicingWay("1");
		response.getBody().setTitle("10");
	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
