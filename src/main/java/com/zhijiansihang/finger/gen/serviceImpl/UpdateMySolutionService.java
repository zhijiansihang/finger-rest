package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.common.ResponseHeader;
import com.zhijiansihang.common.ResponseHeaderBuilder;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserSolutionDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserSolutionDO;
import com.zhijiansihang.finger.gen.tool.CheckTools;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.UpdateMySolutionRequest;
import com.zhijiansihang.finger.gen.entity.UpdateMySolutionResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 更新我的方案
 * 
 */
@Component("updateMySolutionService")
public class UpdateMySolutionService implements MessageService<UpdateMySolutionRequest, Response<UpdateMySolutionResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(UpdateMySolutionService.class);
	private static final String SERVICE_DESC = "更新我的方案";

	@Autowired
	UserSolutionDAO userSolutionDAO;
	@Override
	public void execute(UpdateMySolutionRequest request, Response<UpdateMySolutionResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		Long userId = UserTools.getLoginUser().getId();
		String id = request.getId();
		String solution = request.getSolution();
		if (!CheckTools.isInteger(id) || CheckTools.stringEmptyString(solution)){
			ResponseHeader responseHeader = ResponseHeaderBuilder.buildValidateError("身份证不能为空");
			response.setHeader(responseHeader);
			return;
		}
		UserSolutionDO userSolutionDO = new UserSolutionDO();
		userSolutionDO.setId(Long.parseLong(id));
		userSolutionDO.setSolution(solution);
		userSolutionDO.setUserId(userId);
		userSolutionDAO.updateByPrimaryKeySelective(userSolutionDO);

	}
}
