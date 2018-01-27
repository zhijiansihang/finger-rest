package com.zhijiansihang.finger.gen.service;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.OperateMySolutiondemandRequest;
import com.zhijiansihang.finger.gen.entity.OperateMySolutiondemandResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 方案已读需求
 * 
 */
@Component("genoperateMySolutiondemandService")
public class OperateMySolutiondemandService implements MessageService<OperateMySolutiondemandRequest, Response<OperateMySolutiondemandResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(OperateMySolutiondemandService.class);
	private static final String SERVICE_DESC = "方案已读需求";

	@Override
	public void execute(OperateMySolutiondemandRequest request, Response<OperateMySolutiondemandResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
