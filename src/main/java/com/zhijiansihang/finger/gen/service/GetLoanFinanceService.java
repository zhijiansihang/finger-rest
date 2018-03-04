package com.zhijiansihang.finger.gen.service;

import java.util.ArrayList;
import java.util.List;

import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.GetLoanFinanceRequest;
import com.zhijiansihang.finger.gen.entity.GetLoanFinanceResponse;
import com.zhijiansihang.finger.gen.entity.GetLoanFinanceResponse.FinanceListElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Y获取标的理财师列表
 * 
 */
@Component("gengetLoanFinanceService")
public class GetLoanFinanceService implements MessageService<GetLoanFinanceRequest, Response<GetLoanFinanceResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(GetLoanFinanceService.class);
	private static final String SERVICE_DESC = "Y获取标的理财师列表";

	@Override
	public void execute(GetLoanFinanceRequest request, Response<GetLoanFinanceResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		response.getBody().setFinanceList(getFinanceList());
	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}

	private List<FinanceListElement> getFinanceList() {
		List<FinanceListElement> elems = new ArrayList<FinanceListElement>();
		FinanceListElement elem = new FinanceListElement();
		elems.add(elem);

		elem.setLogo("111");
		elem.setRealName("张经理");
		elem.setUserId("10000");
		elem.setWorkAge("1000");

		return elems;
	}
}
