package com.zhijiansihang.finger.gen.service;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.IsCollectedRequest;
import com.zhijiansihang.finger.gen.entity.IsCollectedResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 是否收藏
 * 
 */
@Component("genisCollectedService")
public class IsCollectedService implements MessageService<IsCollectedRequest, Response<IsCollectedResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(IsCollectedService.class);
	private static final String SERVICE_DESC = "是否收藏";

	@Override
	public void execute(IsCollectedRequest request, Response<IsCollectedResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		response.getBody().setStatus("1");
	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
