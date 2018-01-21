package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.OperateMyDemandsolutionRequest;
import com.zhijiansihang.finger.gen.entity.OperateMyDemandsolutionResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 需求采纳已读方案
 * 
 */
@Component("operateMyDemandsolutionService")
public class OperateMyDemandsolutionService implements MessageService<OperateMyDemandsolutionRequest, Response<OperateMyDemandsolutionResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(OperateMyDemandsolutionService.class);
	private static final String SERVICE_DESC = "需求采纳已读方案";

	@Override
	public void execute(OperateMyDemandsolutionRequest request, Response<OperateMyDemandsolutionResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
