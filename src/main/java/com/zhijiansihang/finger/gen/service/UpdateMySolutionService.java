package com.zhijiansihang.finger.gen.service;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.UpdateMySolutionRequest;
import com.zhijiansihang.finger.gen.entity.UpdateMySolutionResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Y更新我的方案
 * 
 */
@Component("genupdateMySolutionService")
public class UpdateMySolutionService implements MessageService<UpdateMySolutionRequest, Response<UpdateMySolutionResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(UpdateMySolutionService.class);
	private static final String SERVICE_DESC = "Y更新我的方案";

	@Override
	public void execute(UpdateMySolutionRequest request, Response<UpdateMySolutionResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
