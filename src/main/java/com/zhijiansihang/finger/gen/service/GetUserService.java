package com.zhijiansihang.finger.gen.service;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.GetUserRequest;
import com.zhijiansihang.finger.gen.entity.GetUserResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Y获取用户
 * 
 */
@Component("gengetUserService")
public class GetUserService implements MessageService<GetUserRequest, Response<GetUserResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(GetUserService.class);
	private static final String SERVICE_DESC = "Y获取用户";

	@Override
	public void execute(GetUserRequest request, Response<GetUserResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		response.getBody().setIdCard("110");
		response.getBody().setIsNameAuth("110");
		response.getBody().setIsRegisterJg("110");
		response.getBody().setLogo("110");
		response.getBody().setMobile("110");
		response.getBody().setNickName("110");
		response.getBody().setRealName("110");
		response.getBody().setRiskAssessmentLevel("110");
		response.getBody().setRoles("1");
		response.getBody().setUserId("110");
	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
