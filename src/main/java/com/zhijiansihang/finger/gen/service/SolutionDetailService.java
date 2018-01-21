package com.zhijiansihang.finger.gen.service;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.SolutionDetailRequest;
import com.zhijiansihang.finger.gen.entity.SolutionDetailResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 方案详情
 * 
 */
@Component("gensolutionDetailService")
public class SolutionDetailService implements MessageService<SolutionDetailRequest, Response<SolutionDetailResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(SolutionDetailService.class);
	private static final String SERVICE_DESC = "方案详情";

	@Override
	public void execute(SolutionDetailRequest request, Response<SolutionDetailResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		response.getBody().setEarningType("1");
		response.getBody().setExpectedDeadline("1");
		response.getBody().setIsFinanceDeleted("0");
		response.getBody().setMoneySituation("1");
		response.getBody().setRiskAssessmentLevel("10");
		response.getBody().setSolution("10");
	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
