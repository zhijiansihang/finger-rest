package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.LogoutRequest;
import com.zhijiansihang.finger.gen.entity.LogoutResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 退出
 * 
 */
@Component("logoutService")
public class LogoutService implements MessageService<LogoutRequest, Response<LogoutResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(LogoutService.class);
	private static final String SERVICE_DESC = "退出";

	@Override
	public void execute(LogoutRequest request, Response<LogoutResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
