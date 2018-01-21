package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.RegisterJgRequest;
import com.zhijiansihang.finger.gen.entity.RegisterJgResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 注册极光
 * 
 */
@Component("registerJgService")
public class RegisterJgService implements MessageService<RegisterJgRequest, Response<RegisterJgResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(RegisterJgService.class);
	private static final String SERVICE_DESC = "注册极光";

	@Override
	public void execute(RegisterJgRequest request, Response<RegisterJgResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
