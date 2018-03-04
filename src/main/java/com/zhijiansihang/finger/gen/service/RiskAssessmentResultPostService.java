package com.zhijiansihang.finger.gen.service;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.RiskAssessmentResultPostRequest;
import com.zhijiansihang.finger.gen.entity.RiskAssessmentResultPostResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 分险评测结果
 * 
 */
@Component("genriskAssessmentResultPostService")
public class RiskAssessmentResultPostService implements MessageService<RiskAssessmentResultPostRequest, Response<RiskAssessmentResultPostResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(RiskAssessmentResultPostService.class);
	private static final String SERVICE_DESC = "分险评测结果";

	@Override
	public void execute(RiskAssessmentResultPostRequest request, Response<RiskAssessmentResultPostResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
