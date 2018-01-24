package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.common.ResponseHeader;
import com.zhijiansihang.common.ResponseHeaderBuilder;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDemandDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDemandDO;
import com.zhijiansihang.finger.gen.tool.CheckTools;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.UpdateMyDemandRequest;
import com.zhijiansihang.finger.gen.entity.UpdateMyDemandResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 更新我的需求
 * 
 */
@Component("updateMyDemandService")
public class UpdateMyDemandService implements MessageService<UpdateMyDemandRequest, Response<UpdateMyDemandResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(UpdateMyDemandService.class);
	private static final String SERVICE_DESC = "更新我的需求";

	@Autowired
	UserDemandDAO userDemandDAO;
	@Override
	public void execute(UpdateMyDemandRequest request, Response<UpdateMyDemandResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		Long userId = UserTools.getLoginUser().getId();
		String id = request.getId();
		String solution = request.getAdditionalRemarks();
		if (!CheckTools.isInteger(id) || CheckTools.stringEmptyString(solution)){
			ResponseHeader responseHeader = ResponseHeaderBuilder.buildValidateError("身份证不能为空");
			response.setHeader(responseHeader);
			return;
		}
		UserDemandDO userDemandDO = new UserDemandDO();
		userDemandDO.setId(Long.parseLong(id));
		userDemandDO.setUserId(userId);
		userDemandDO.setAdditionalRemarks(solution);
		userDemandDAO.updateByPrimaryKeySelective(userDemandDO);
	}
}
