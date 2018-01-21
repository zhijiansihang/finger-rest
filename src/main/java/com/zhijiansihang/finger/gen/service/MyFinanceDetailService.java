package com.zhijiansihang.finger.gen.service;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.MyFinanceDetailRequest;
import com.zhijiansihang.finger.gen.entity.MyFinanceDetailResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 我的资料
 * 
 */
@Component("genmyFinanceDetailService")
public class MyFinanceDetailService implements MessageService<MyFinanceDetailRequest, Response<MyFinanceDetailResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(MyFinanceDetailService.class);
	private static final String SERVICE_DESC = "我的资料";

	@Override
	public void execute(MyFinanceDetailRequest request, Response<MyFinanceDetailResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		response.getBody().setEducationLevel("10");
		response.getBody().setIsAdd("10");
		response.getBody().setPersonalProfile("11");
		response.getBody().setPosition("10");
		response.getBody().setSchoolName("1");
		response.getBody().setServiceConcept("1");
		response.getBody().setServiceDirection("1");
		response.getBody().setWorkAge("1");
		response.getBody().setWorkingExperience("1");
	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
