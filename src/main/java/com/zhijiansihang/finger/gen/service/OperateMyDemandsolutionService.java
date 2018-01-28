package com.zhijiansihang.finger.gen.service;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.OperateMyDemandsolutionRequest;
import com.zhijiansihang.finger.gen.entity.OperateMyDemandsolutionResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Y需求采纳已读方案
 * 
 */
@Component("genoperateMyDemandsolutionService")
public class OperateMyDemandsolutionService implements MessageService<OperateMyDemandsolutionRequest, Response<OperateMyDemandsolutionResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(OperateMyDemandsolutionService.class);
	private static final String SERVICE_DESC = "Y需求采纳已读方案";

	@Override
	public void execute(OperateMyDemandsolutionRequest request, Response<OperateMyDemandsolutionResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
