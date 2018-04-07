package com.zhijiansihang.finger.gen.service;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.SessionIdIsOkRequest;
import com.zhijiansihang.finger.gen.entity.SessionIdIsOkResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * sessionId是否ok
 * 
 */
@Component("gensessionIdIsOkService")
public class SessionIdIsOkService implements MessageService<SessionIdIsOkRequest, Response<SessionIdIsOkResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(SessionIdIsOkService.class);
	private static final String SERVICE_DESC = "sessionId是否ok";

	@Override
	public void execute(SessionIdIsOkRequest request, Response<SessionIdIsOkResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		response.getBody().setStatus("1");
	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
