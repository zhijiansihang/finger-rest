package com.zhijiansihang.finger.gen.service;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.UpdateMyDemandRequest;
import com.zhijiansihang.finger.gen.entity.UpdateMyDemandResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Y更新我的需求
 * 
 */
@Component("genupdateMyDemandService")
public class UpdateMyDemandService implements MessageService<UpdateMyDemandRequest, Response<UpdateMyDemandResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(UpdateMyDemandService.class);
	private static final String SERVICE_DESC = "Y更新我的需求";

	@Override
	public void execute(UpdateMyDemandRequest request, Response<UpdateMyDemandResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
