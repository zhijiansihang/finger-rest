package com.zhijiansihang.finger.gen.service;

import java.util.ArrayList;
import java.util.List;

import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.GetSolutionTop10Request;
import com.zhijiansihang.finger.gen.entity.GetSolutionTop10Response;
import com.zhijiansihang.finger.gen.entity.GetSolutionTop10Response.SolutionListElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 取采纳次数最高的top10方案
 * 
 */
@Component("gengetSolutionTop10Service")
public class GetSolutionTop10Service implements MessageService<GetSolutionTop10Request, Response<GetSolutionTop10Response>> {

	private static final Logger LOG = LoggerFactory.getLogger(GetSolutionTop10Service.class);
	private static final String SERVICE_DESC = "取采纳次数最高的top10方案";

	@Override
	public void execute(GetSolutionTop10Request request, Response<GetSolutionTop10Response> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

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
		elem.setInstitutionName("0");
		elem.setLogo("//www.baidu.com/1.png");
		elem.setRealName("//www.baidu.com/1.png");
		elem.setSerialNumber("1");
		elem.setServiceDirection("1");
		elem.setSolutionId("1");
		elem.setSolutionUserId("1");

		return elems;
	}
}
