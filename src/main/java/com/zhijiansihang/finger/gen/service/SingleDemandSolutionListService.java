package com.zhijiansihang.finger.gen.service;

import java.util.ArrayList;
import java.util.List;

import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.SingleDemandSolutionListRequest;
import com.zhijiansihang.finger.gen.entity.SingleDemandSolutionListResponse;
import com.zhijiansihang.finger.gen.entity.SingleDemandSolutionListResponse.SolutionListElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 需求所匹配的方案列表
 * 
 */
@Component("gensingleDemandSolutionListService")
public class SingleDemandSolutionListService implements MessageService<SingleDemandSolutionListRequest, Response<SingleDemandSolutionListResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(SingleDemandSolutionListService.class);
	private static final String SERVICE_DESC = "需求所匹配的方案列表";

	@Override
	public void execute(SingleDemandSolutionListRequest request, Response<SingleDemandSolutionListResponse> response) {
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

		elem.setAdoptCount("1");
		elem.setFriendCount("1");
		elem.setId("1");
		elem.setInstitutionName("0");
		elem.setIsOperateSolution("2");
		elem.setLogo("//www.baidu.com/1.png");
		elem.setRealName("//www.baidu.com/1.png");
		elem.setSerialNumber("1");
		elem.setServiceDirection("1");
		elem.setSolutionId("1");
		elem.setSolutionUserId("1");

		return elems;
	}
}
