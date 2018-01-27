package com.zhijiansihang.finger.gen.service;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.IsFriendRequest;
import com.zhijiansihang.finger.gen.entity.IsFriendResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Y是否是好友关系
 * 
 */
@Component("genisFriendService")
public class IsFriendService implements MessageService<IsFriendRequest, Response<IsFriendResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(IsFriendService.class);
	private static final String SERVICE_DESC = "Y是否是好友关系";

	@Override
	public void execute(IsFriendRequest request, Response<IsFriendResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		response.getBody().setResult("1");
	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
