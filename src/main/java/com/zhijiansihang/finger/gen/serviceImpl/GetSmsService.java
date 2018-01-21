package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.GetSmsRequest;
import com.zhijiansihang.finger.gen.entity.GetSmsResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 获取短信验证码
 * 
 */
@Component("getSmsService")
public class GetSmsService implements MessageService<GetSmsRequest, Response<GetSmsResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(GetSmsService.class);
	private static final String SERVICE_DESC = "获取短信验证码";

	@Override
	public void execute(GetSmsRequest request, Response<GetSmsResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
