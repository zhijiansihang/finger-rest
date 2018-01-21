package com.zhijiansihang.finger.gen.service;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.MakeFriendRequest;
import com.zhijiansihang.finger.gen.entity.MakeFriendResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 交朋友
 * 
 */
@Component("genmakeFriendService")
public class MakeFriendService implements MessageService<MakeFriendRequest, Response<MakeFriendResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(MakeFriendService.class);
	private static final String SERVICE_DESC = "交朋友";

	@Override
	public void execute(MakeFriendRequest request, Response<MakeFriendResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
