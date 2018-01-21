package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.OperateMyColutionSemandRequest;
import com.zhijiansihang.finger.gen.entity.OperateMyColutionSemandResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 方案已读需求
 * 
 */
@Component("operateMyColutionSemandService")
public class OperateMyColutionSemandService implements MessageService<OperateMyColutionSemandRequest, Response<OperateMyColutionSemandResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(OperateMyColutionSemandService.class);
	private static final String SERVICE_DESC = "方案已读需求";

	@Override
	public void execute(OperateMyColutionSemandRequest request, Response<OperateMyColutionSemandResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
