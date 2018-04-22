package com.zhijiansihang.finger.gen.service;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.IsRegisterJgRequest;
import com.zhijiansihang.finger.gen.entity.IsRegisterJgResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 是否注册极光
 * 
 */
@Component("genisRegisterJgService")
public class IsRegisterJgService implements MessageService<IsRegisterJgRequest, Response<IsRegisterJgResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(IsRegisterJgService.class);
	private static final String SERVICE_DESC = "是否注册极光";

	@Override
	public void execute(IsRegisterJgRequest request, Response<IsRegisterJgResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		response.getBody().setResult("1");
	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
