package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.common.Response;
import com.zhijiansihang.common.ResponseHeader;
import com.zhijiansihang.common.ResponseHeaderBuilder;
import com.zhijiansihang.finger.app.constant.CmsConsts;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDAO;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserSurverDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserSurverDO;
import com.zhijiansihang.finger.app.event.demo.RiskAssessmentModifyEvent;
import com.zhijiansihang.finger.app.sharing.spring.ApplicationContextHelper;
import com.zhijiansihang.finger.gen.entity.RiskAssessmentResultPostRequest;
import com.zhijiansihang.finger.gen.entity.RiskAssessmentResultPostResponse;
import com.zhijiansihang.finger.gen.tool.CheckTools;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

import static com.zhijiansihang.finger.app.constant.CmsConsts.getRiskAssessment;

/**
 * 分险评测结果
 * 
 */
@Component("riskAssessmentResultPostService")
public class RiskAssessmentResultPostService implements MessageService<RiskAssessmentResultPostRequest, Response<RiskAssessmentResultPostResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(RiskAssessmentResultPostService.class);
	private static final String SERVICE_DESC = "分险评测结果";


	@Autowired
	UserSurverDAO userSurverDAO;

	@Autowired
	UserDAO userDAO;
	@Override
	public void execute(RiskAssessmentResultPostRequest request, Response<RiskAssessmentResultPostResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		Long userid = UserTools.getLoginUser().getId();

		String answers = request.getAnswers();
		String result = request.getResult();
		if (answers==null || !CheckTools.isInteger(result)){
			ResponseHeader responseHeader = ResponseHeaderBuilder.buildValidateError("参数不能为空");
			response.setHeader(responseHeader);
			return;
		}

		String riskAssessment = getRiskAssessment(Integer.parseInt(result));
		if (riskAssessment == null || riskAssessment.length() == 0){
			ResponseHeader responseHeader = ResponseHeaderBuilder.buildValidateError("riskAssessment参数有误");
			response.setHeader(responseHeader);
			return;
		}

		UserSurverDO userSurverDO = new UserSurverDO();
		userSurverDO.setAnswers(answers);
		userSurverDO.setCreateTime(new Date());
		userSurverDO.setRiskAssessmentLevel(Short.parseShort(result));
		userSurverDO.setUserId(userid);
		userSurverDAO.insert(userSurverDO);

		UserDO userDO1 = userDAO.selectByPrimaryKey(userid);
		if (userDO1.getRiskAssessmentLevel() != null &&Short.parseShort(result) == userDO1.getRiskAssessmentLevel().shortValue())
		{
			LOG.info("用户{}分险测评和上一次结果[{}]相同,不触发跑批",userid,userDO1.getRiskAssessmentLevel());
			return;
		}

		UserDO userDO = new UserDO();
		userDO.setUserId(userid);
		userDO.setRiskAssessmentLevel(Short.parseShort(result));
		userDAO.updateByPrimaryKeySelective(userDO);

		RiskAssessmentModifyEvent riskAssessmentModifyEvent = new RiskAssessmentModifyEvent(this);
		riskAssessmentModifyEvent.setUserId(userid);

		ApplicationContextHelper.applicationContext.publishEvent(riskAssessmentModifyEvent);

	}
}
