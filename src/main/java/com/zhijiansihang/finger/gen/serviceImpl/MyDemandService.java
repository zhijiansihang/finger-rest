package com.zhijiansihang.finger.gen.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.MyDemandRequest;
import com.zhijiansihang.finger.gen.entity.MyDemandResponse;
import com.zhijiansihang.finger.gen.entity.MyDemandResponse.DemandListElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 我的需求
 * 
 */
@Component("myDemandService")
public class MyDemandService implements MessageService<MyDemandRequest, Response<MyDemandResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(MyDemandService.class);
	private static final String SERVICE_DESC = "我的需求";

	@Override
	public void execute(MyDemandRequest request, Response<MyDemandResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		response.getBody().setCurrentPage("1");
		response.getBody().setPageCount("1");
		response.getBody().setPageSize("10");
		response.getBody().setRecordCount("10");
		response.getBody().setDemandList(getDemandList());
	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}

	private List<DemandListElement> getDemandList() {
		List<DemandListElement> elems = new ArrayList<DemandListElement>();
		DemandListElement elem = new DemandListElement();
		elems.add(elem);

		elem.setAdditionalRemarks("10");
		elem.setCreateTime("2017-12-12");
		elem.setEarningType("1");
		elem.setExpectedDeadline("1");
		elem.setId("1");
		elem.setIsClosed("0");
		elem.setMatchSolutionCount("10");
		elem.setMoneySituation("1");
		elem.setSerialNumber("1");

		return elems;
	}
}
