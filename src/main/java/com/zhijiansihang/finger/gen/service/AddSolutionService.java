package com.zhijiansihang.finger.gen.service;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.AddSolutionRequest;
import com.zhijiansihang.finger.gen.entity.AddSolutionResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Y增加收藏
 * 
 */
@Component("genaddSolutionService")
public class AddSolutionService implements MessageService<AddSolutionRequest, Response<AddSolutionResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(AddSolutionService.class);
	private static final String SERVICE_DESC = "Y增加收藏";

	@Override
	public void execute(AddSolutionRequest request, Response<AddSolutionResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
