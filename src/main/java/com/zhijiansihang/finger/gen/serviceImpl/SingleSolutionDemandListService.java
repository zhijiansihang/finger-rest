package com.zhijiansihang.finger.gen.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.SingleSolutionDemandListRequest;
import com.zhijiansihang.finger.gen.entity.SingleSolutionDemandListResponse;
import com.zhijiansihang.finger.gen.entity.SingleSolutionDemandListResponse.DemandListElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 方案所匹配的需求列表
 * 
 */
@Component("singleSolutionDemandListService")
public class SingleSolutionDemandListService implements MessageService<SingleSolutionDemandListRequest, Response<SingleSolutionDemandListResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(SingleSolutionDemandListService.class);
	private static final String SERVICE_DESC = "方案所匹配的需求列表";

	@Override
	public void execute(SingleSolutionDemandListRequest request, Response<SingleSolutionDemandListResponse> response) {
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

		elem.setDemandId("1");
		elem.setDemandUserId("1");
		elem.setId("1");
		elem.setIsRead("2");
		elem.setLogo("//www.baidu.com/1.png");
		elem.setRealName("//www.baidu.com/1.png");
		elem.setSerialNumber("1");

		return elems;
	}
}
