package com.zhijiansihang.finger.gen.service;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.GetNameAuthAndRiskResultRequest;
import com.zhijiansihang.finger.gen.entity.GetNameAuthAndRiskResultResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 是否实名认证和评测
 * 
 */
@Component("gengetNameAuthAndRiskResultService")
public class GetNameAuthAndRiskResultService implements MessageService<GetNameAuthAndRiskResultRequest, Response<GetNameAuthAndRiskResultResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(GetNameAuthAndRiskResultService.class);
	private static final String SERVICE_DESC = "是否实名认证和评测";

	@Override
	public void execute(GetNameAuthAndRiskResultRequest request, Response<GetNameAuthAndRiskResultResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		response.getBody().setIsNameAuth("10");
		response.getBody().setRiskAssessmentLevel("10");
	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
