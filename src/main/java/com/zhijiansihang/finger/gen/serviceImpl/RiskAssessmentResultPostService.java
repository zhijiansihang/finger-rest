package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.RiskAssessmentResultPostRequest;
import com.zhijiansihang.finger.gen.entity.RiskAssessmentResultPostResponse;
import com.zhijiansihang.finger.mmc.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 分险评测结果
 * 
 */
@Component("riskAssessmentResultPostService")
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
