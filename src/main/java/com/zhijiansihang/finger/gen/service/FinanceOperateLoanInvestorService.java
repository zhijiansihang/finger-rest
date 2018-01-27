package com.zhijiansihang.finger.gen.service;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.FinanceOperateLoanInvestorRequest;
import com.zhijiansihang.finger.gen.entity.FinanceOperateLoanInvestorResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Y理财师操作预约记录
 * 
 */
@Component("genfinanceOperateLoanInvestorService")
public class FinanceOperateLoanInvestorService implements MessageService<FinanceOperateLoanInvestorRequest, Response<FinanceOperateLoanInvestorResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(FinanceOperateLoanInvestorService.class);
	private static final String SERVICE_DESC = "Y理财师操作预约记录";

	@Override
	public void execute(FinanceOperateLoanInvestorRequest request, Response<FinanceOperateLoanInvestorResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
