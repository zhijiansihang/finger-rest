package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.RiskAssessmentResultGetRequest;
import com.zhijiansihang.finger.gen.entity.RiskAssessmentResultGetResponse;
import com.zhijiansihang.finger.mmc.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 获取分险评测结果和答案
 * 
 */
@Component("riskAssessmentResultGetService")
public class RiskAssessmentResultGetService implements MessageService<RiskAssessmentResultGetRequest, Response<RiskAssessmentResultGetResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(RiskAssessmentResultGetService.class);
	private static final String SERVICE_DESC = "获取分险评测结果和答案";

	@Override
	public void execute(RiskAssessmentResultGetRequest request, Response<RiskAssessmentResultGetResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		response.getBody().setAnswers("{}");
		response.getBody().setResult("1");
	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
