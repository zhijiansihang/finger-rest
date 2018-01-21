package com.zhijiansihang.finger.gen.service;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.DemandDetailRequest;
import com.zhijiansihang.finger.gen.entity.DemandDetailResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 需求详情
 * 
 */
@Component("gendemandDetailService")
public class DemandDetailService implements MessageService<DemandDetailRequest, Response<DemandDetailResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(DemandDetailService.class);
	private static final String SERVICE_DESC = "需求详情";

	@Override
	public void execute(DemandDetailRequest request, Response<DemandDetailResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		response.getBody().setAdditionalRemarks("10");
		response.getBody().setDemandUserid("2017-12-12");
		response.getBody().setEarningType("1");
		response.getBody().setExpectedDeadline("1");
		response.getBody().setMoneySituation("1");
		response.getBody().setSerialNumber("1");
	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
