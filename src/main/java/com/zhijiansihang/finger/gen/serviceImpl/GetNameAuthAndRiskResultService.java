package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.GetNameAuthAndRiskResultRequest;
import com.zhijiansihang.finger.gen.entity.GetNameAuthAndRiskResultResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.zhijiansihang.finger.app.constant.CmsConsts.getRiskAssessment;

/**
 * 是否实名认证和评测
 * 
 */
@Component("getNameAuthAndRiskResultService")
public class GetNameAuthAndRiskResultService implements MessageService<GetNameAuthAndRiskResultRequest, Response<GetNameAuthAndRiskResultResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(GetNameAuthAndRiskResultService.class);
	private static final String SERVICE_DESC = "是否实名认证和评测";
	@Autowired
	UserDAO userDAO;
	@Override
	public void execute(GetNameAuthAndRiskResultRequest request, Response<GetNameAuthAndRiskResultResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);
		Long id = UserTools.getLoginUser().getId();
		UserDO userDO = userDAO.selectByPrimaryKey(id);
		if (userDO.getRiskAssessmentLevel()==null){
			response.getBody().setRiskAssessmentLevel("");
		}	else {
			response.getBody().setRiskAssessmentLevel(getRiskAssessment(userDO.getRiskAssessmentLevel().intValue()));
		}
		response.getBody().setIsNameAuth(userDO.getIsNameAuth()==null?"0":userDO.getIsNameAuth().toString());
	}
}
