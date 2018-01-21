package com.zhijiansihang.finger.gen.service;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.OperateMyDemandRequest;
import com.zhijiansihang.finger.gen.entity.OperateMyDemandResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 删除关闭我的需求
 * 
 */
@Component("genoperateMyDemandService")
public class OperateMyDemandService implements MessageService<OperateMyDemandRequest, Response<OperateMyDemandResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(OperateMyDemandService.class);
	private static final String SERVICE_DESC = "删除关闭我的需求";

	@Override
	public void execute(OperateMyDemandRequest request, Response<OperateMyDemandResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
