package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.ConstantInformationRequest;
import com.zhijiansihang.finger.gen.entity.ConstantInformationResponse;
import com.zhijiansihang.finger.mmc.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 常量信息
 * 
 */
@Component("constantInformationService")
public class ConstantInformationService implements MessageService<ConstantInformationRequest, Response<ConstantInformationResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(ConstantInformationService.class);
	private static final String SERVICE_DESC = "常量信息";

	@Override
	public void execute(ConstantInformationRequest request, Response<ConstantInformationResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		response.getBody().setMobile("15010228972");
		response.getBody().setFinanceServicesDirection("基金|证券|保险|信托|私募|其他");
	}
}
