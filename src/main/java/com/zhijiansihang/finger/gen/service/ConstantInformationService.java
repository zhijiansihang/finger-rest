package com.zhijiansihang.finger.gen.service;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.ConstantInformationRequest;
import com.zhijiansihang.finger.gen.entity.ConstantInformationResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 常量信息
 * 
 */
@Component("genconstantInformationService")
public class ConstantInformationService implements MessageService<ConstantInformationRequest, Response<ConstantInformationResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(ConstantInformationService.class);
	private static final String SERVICE_DESC = "常量信息";

	@Override
	public void execute(ConstantInformationRequest request, Response<ConstantInformationResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		response.getBody().setFinanceServicesDirection("基金|证券|保险|信托|私募|其他");
		response.getBody().setMobile("");
	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
