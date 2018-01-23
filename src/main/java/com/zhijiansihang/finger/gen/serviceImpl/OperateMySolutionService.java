package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.common.ResponseHeader;
import com.zhijiansihang.common.ResponseHeaderBuilder;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserSolutionDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDemandDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserSolutionDO;
import com.zhijiansihang.finger.gen.tool.CheckTools;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.OperateMySolutionRequest;
import com.zhijiansihang.finger.gen.entity.OperateMySolutionResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.zhijiansihang.common.RetCode.NOTSUPPORT;

/**
 * 删除关闭我的方案
 * 
 */
@Component("operateMySolutionService")
public class OperateMySolutionService implements MessageService<OperateMySolutionRequest, Response<OperateMySolutionResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(OperateMySolutionService.class);
	private static final String SERVICE_DESC = "删除关闭我的方案";

	@Autowired
	UserSolutionDAO userSolutionDAO;
	@Override
	public void execute(OperateMySolutionRequest request, Response<OperateMySolutionResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		Long userid = UserTools.getLoginUser().getId();
		String id = request.getId();
		String type = request.getType();
		if (!CheckTools.isInteger(id) || !CheckTools.isInteger(type)){
			ResponseHeader responseHeader = ResponseHeaderBuilder.buildValidateError("参数不能为空");
			response.setHeader(responseHeader);
			return;
		}
		UserSolutionDO userSolutionDO = new UserSolutionDO();
		userSolutionDO.setUserId(userid);
		userSolutionDO.setId(Long.parseLong(id));
		//操作类型:1:关闭2:删除
		if (Integer.parseInt(type) == 1){
			userSolutionDO.setIsClosed((byte) 1);
			userSolutionDAO.updateByPrimaryKeySelective(userSolutionDO);
		}else if(Integer.parseInt(type) == 2){
			userSolutionDO.setIsDeleted((byte)1);
			userSolutionDAO.updateByPrimaryKeySelective(userSolutionDO);
		}else {
			ResponseHeader responseHeader = ResponseHeaderBuilder.build(NOTSUPPORT,NOTSUPPORT.getMessage());
			response.setHeader(responseHeader);
			return;
		}
	}
}
