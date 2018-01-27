package com.zhijiansihang.finger.gen.service;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.CreateMyDemandRequest;
import com.zhijiansihang.finger.gen.entity.CreateMyDemandResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Y发布我的需求
 * 
 */
@Component("gencreateMyDemandService")
public class CreateMyDemandService implements MessageService<CreateMyDemandRequest, Response<CreateMyDemandResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(CreateMyDemandService.class);
	private static final String SERVICE_DESC = "Y发布我的需求";

	@Override
	public void execute(CreateMyDemandRequest request, Response<CreateMyDemandResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		response.getBody().setDemandId("1");
	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
