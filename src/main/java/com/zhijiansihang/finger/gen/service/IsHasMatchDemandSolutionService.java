package com.zhijiansihang.finger.gen.service;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.IsHasMatchDemandSolutionRequest;
import com.zhijiansihang.finger.gen.entity.IsHasMatchDemandSolutionResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 是否有匹配需求的方案
 * 
 */
@Component("genisHasMatchDemandSolutionService")
public class IsHasMatchDemandSolutionService implements MessageService<IsHasMatchDemandSolutionRequest, Response<IsHasMatchDemandSolutionResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(IsHasMatchDemandSolutionService.class);
	private static final String SERVICE_DESC = "是否有匹配需求的方案";

	@Override
	public void execute(IsHasMatchDemandSolutionRequest request, Response<IsHasMatchDemandSolutionResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		response.getBody().setIsHas("1");
	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
