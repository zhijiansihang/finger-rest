package com.zhijiansihang.finger.gen.service;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.DeleteSolutionRequest;
import com.zhijiansihang.finger.gen.entity.DeleteSolutionResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 删除收藏
 * 
 */
@Component("gendeleteSolutionService")
public class DeleteSolutionService implements MessageService<DeleteSolutionRequest, Response<DeleteSolutionResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(DeleteSolutionService.class);
	private static final String SERVICE_DESC = "删除收藏";

	@Override
	public void execute(DeleteSolutionRequest request, Response<DeleteSolutionResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
