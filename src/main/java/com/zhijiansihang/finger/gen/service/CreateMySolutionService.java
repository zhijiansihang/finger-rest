package com.zhijiansihang.finger.gen.service;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.CreateMySolutionRequest;
import com.zhijiansihang.finger.gen.entity.CreateMySolutionResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 发布我的方案
 * 
 */
@Component("gencreateMySolutionService")
public class CreateMySolutionService implements MessageService<CreateMySolutionRequest, Response<CreateMySolutionResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(CreateMySolutionService.class);
	private static final String SERVICE_DESC = "发布我的方案";

	@Override
	public void execute(CreateMySolutionRequest request, Response<CreateMySolutionResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		response.getBody().setSolutionId("1");
	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
