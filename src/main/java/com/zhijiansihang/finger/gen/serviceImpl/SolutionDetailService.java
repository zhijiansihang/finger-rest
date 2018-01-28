package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.finger.app.dao.mysql.mapper.UserSolutionDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserSolutionDO;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.SolutionDetailRequest;
import com.zhijiansihang.finger.gen.entity.SolutionDetailResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 方案详情
 * 
 */
@Component("solutionDetailService")
public class SolutionDetailService implements MessageService<SolutionDetailRequest, Response<SolutionDetailResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(SolutionDetailService.class);
	private static final String SERVICE_DESC = "方案详情";

	@Autowired
	UserSolutionDAO userSolutionDAO;
	@Override
	public void execute(SolutionDetailRequest request, Response<SolutionDetailResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);
		String solutionId = request.getSolutionId();
		UserSolutionDO userSolutionDO = userSolutionDAO.selectByPrimaryKey(Long.parseLong(solutionId));
		response.getBody().setEarningType(userSolutionDO.getEarningType().toString());
		response.getBody().setExpectedDeadline(userSolutionDO.getExpectedDeadline().toString());
		response.getBody().setIsFinanceDeleted("0");
		response.getBody().setMoneySituation(userSolutionDO.getMoneySituation().toString());
		response.getBody().setRiskAssessmentLevel(userSolutionDO.getRiskAssessmentLevel().toString());
		response.getBody().setSolution(userSolutionDO.getSolution());
	}
}
