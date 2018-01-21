package com.zhijiansihang.finger.gen.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.MySolutionRequest;
import com.zhijiansihang.finger.gen.entity.MySolutionResponse;
import com.zhijiansihang.finger.gen.entity.MySolutionResponse.SolutionListElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 我的方案
 * 
 */
@Component("mySolutionService")
public class MySolutionService implements MessageService<MySolutionRequest, Response<MySolutionResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(MySolutionService.class);
	private static final String SERVICE_DESC = "我的方案";

	@Override
	public void execute(MySolutionRequest request, Response<MySolutionResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		response.getBody().setCurrentPage("1");
		response.getBody().setPageCount("1");
		response.getBody().setPageSize("10");
		response.getBody().setRecordCount("10");
		response.getBody().setSolutionList(getSolutionList());
	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}

	private List<SolutionListElement> getSolutionList() {
		List<SolutionListElement> elems = new ArrayList<SolutionListElement>();
		SolutionListElement elem = new SolutionListElement();
		elems.add(elem);

		elem.setCreateTime("2017-12-12");
		elem.setEarningType("1");
		elem.setExpectedDeadline("1");
		elem.setId("1");
		elem.setIsClosed("0");
		elem.setMatchDemandCount("10");
		elem.setMoneySituation("1");
		elem.setRiskAssessmentLevel("1");
		elem.setSerialNumber("1");
		elem.setSolution("哈哈");

		return elems;
	}
}
