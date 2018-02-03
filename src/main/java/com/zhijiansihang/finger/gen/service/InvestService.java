package com.zhijiansihang.finger.gen.service;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.InvestRequest;
import com.zhijiansihang.finger.gen.entity.InvestResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 预约
 * 
 */
@Component("geninvestService")
public class InvestService implements MessageService<InvestRequest, Response<InvestResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(InvestService.class);
	private static final String SERVICE_DESC = "预约";

	@Override
	public void execute(InvestRequest request, Response<InvestResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
