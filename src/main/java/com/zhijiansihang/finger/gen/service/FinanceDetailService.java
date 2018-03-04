package com.zhijiansihang.finger.gen.service;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.FinanceDetailRequest;
import com.zhijiansihang.finger.gen.entity.FinanceDetailResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Y理财师详情
 * 
 */
@Component("genfinanceDetailService")
public class FinanceDetailService implements MessageService<FinanceDetailRequest, Response<FinanceDetailResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(FinanceDetailService.class);
	private static final String SERVICE_DESC = "Y理财师详情";

	@Override
	public void execute(FinanceDetailRequest request, Response<FinanceDetailResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		response.getBody().setAdoptCount("10");
		response.getBody().setEducationLevel("10");
		response.getBody().setFriendCount("10");
		response.getBody().setInstitutionName("1");
		response.getBody().setIsCollection("10");
		response.getBody().setIsFriend("10");
		response.getBody().setIsPerson("1");
		response.getBody().setLoanCount("1");
		response.getBody().setLogo("1");
		response.getBody().setPersonalProfile("10");
		response.getBody().setPosition("10");
		response.getBody().setRealName("paul");
		response.getBody().setSchoolName("10");
		response.getBody().setSellingloanCount("1");
		response.getBody().setServiceConcept("10");
		response.getBody().setServiceDirection("0");
		response.getBody().setServicePersonCount("10");
		response.getBody().setUserId("1");
		response.getBody().setUserOrderCount("1");
		response.getBody().setWorkAge("10");
		response.getBody().setWorkingExperience("10");
	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
