package com.zhijiansihang.finger.gen.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.SelectFinanceRequest;
import com.zhijiansihang.finger.gen.entity.SelectFinanceResponse;
import com.zhijiansihang.finger.gen.entity.SelectFinanceResponse.FinanceListElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 发现投顾
 * 
 */
@Component("selectFinanceService")
public class SelectFinanceService implements MessageService<SelectFinanceRequest, Response<SelectFinanceResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(SelectFinanceService.class);
	private static final String SERVICE_DESC = "发现投顾";

	@Override
	public void execute(SelectFinanceRequest request, Response<SelectFinanceResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		response.getBody().setCurrentPage("1");
		response.getBody().setPageCount("1");
		response.getBody().setPageSize("10");
		response.getBody().setRecordCount("10");
		response.getBody().setFinanceList(getFinanceList());
	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}

	private List<FinanceListElement> getFinanceList() {
		List<FinanceListElement> elems = new ArrayList<FinanceListElement>();
		FinanceListElement elem = new FinanceListElement();
		elems.add(elem);

		elem.setAdoptCount("10");
		elem.setInstitutionName("1");
		elem.setLoanCount("1");
		elem.setLogo("1");
		elem.setPosition("10");
		elem.setRealName("paul");
		elem.setServiceDirection("0");
		elem.setUserId("1");
		elem.setUserOrderCount("1");

		return elems;
	}
}
