package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.RealNameAuthRequest;
import com.zhijiansihang.finger.gen.entity.RealNameAuthResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 实名认证
 * 
 */
@Component("realNameAuthService")
public class RealNameAuthService implements MessageService<RealNameAuthRequest, Response<RealNameAuthResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(RealNameAuthService.class);
	private static final String SERVICE_DESC = "实名认证";

	@Override
	public void execute(RealNameAuthRequest request, Response<RealNameAuthResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
