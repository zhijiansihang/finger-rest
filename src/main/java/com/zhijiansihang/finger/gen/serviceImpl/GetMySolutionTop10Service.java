package com.zhijiansihang.finger.gen.serviceImpl;

import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.GetMySolutionTop10Request;
import com.zhijiansihang.finger.gen.entity.GetMySolutionTop10Response;
import com.zhijiansihang.finger.gen.entity.GetMySolutionTop10Response.SolutionListElement;
import com.zhijiansihang.finger.mmc.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取用户匹配方案
 * 
 */
@Component("getMySolutionTop10Service")
public class GetMySolutionTop10Service implements MessageService<GetMySolutionTop10Request, Response<GetMySolutionTop10Response>> {

	private static final Logger LOG = LoggerFactory.getLogger(GetMySolutionTop10Service.class);
	private static final String SERVICE_DESC = "获取用户匹配方案";

	@Override
	public void execute(GetMySolutionTop10Request request, Response<GetMySolutionTop10Response> response) {
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
