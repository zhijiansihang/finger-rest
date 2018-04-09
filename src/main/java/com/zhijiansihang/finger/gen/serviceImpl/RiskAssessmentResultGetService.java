package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.app.constant.CmsConsts;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserSurverDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserSurverDO;
import com.zhijiansihang.finger.gen.entity.RiskAssessmentResultGetRequest;
import com.zhijiansihang.finger.gen.entity.RiskAssessmentResultGetResponse;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 获取分险评测结果和答案
 * 
 */
@Component("riskAssessmentResultGetService")
public class RiskAssessmentResultGetService implements MessageService<RiskAssessmentResultGetRequest, Response<RiskAssessmentResultGetResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(RiskAssessmentResultGetService.class);
	private static final String SERVICE_DESC = "获取分险评测结果和答案";


	@Autowired
	UserSurverDAO userSurverDAO;
	@Override
	public void execute(RiskAssessmentResultGetRequest request, Response<RiskAssessmentResultGetResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		UserSurverDO userSurverDO = userSurverDAO.selectByPrimaryKey(UserTools.getLoginUser().getId());
		if (userSurverDO !=null){
			response.getBody().setAnswers(userSurverDO.getAnswers());
			String riskAssessment = CmsConsts.getRiskAssessment(userSurverDO.getRiskAssessmentLevel().intValue());
			response.getBody().setResult(riskAssessment);
		}
	}
}
