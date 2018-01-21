package com.zhijiansihang.finger.gen.service;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.OperateMySolutionRequest;
import com.zhijiansihang.finger.gen.entity.OperateMySolutionResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 删除关闭我的方案
 * 
 */
@Component("genoperateMySolutionService")
public class OperateMySolutionService implements MessageService<OperateMySolutionRequest, Response<OperateMySolutionResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(OperateMySolutionService.class);
	private static final String SERVICE_DESC = "删除关闭我的方案";

	@Override
	public void execute(OperateMySolutionRequest request, Response<OperateMySolutionResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
