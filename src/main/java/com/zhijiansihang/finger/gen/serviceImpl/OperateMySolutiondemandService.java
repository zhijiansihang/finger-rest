package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDemandSolutionDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDemandSolutionDO;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.OperateMyColutionSemandRequest;
import com.zhijiansihang.finger.gen.entity.OperateMyColutionSemandResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 方案已读需求
 * 
 */
@Component("operateMySolutiondemandService")
public class OperateMySolutiondemandService implements MessageService<OperateMyColutionSemandRequest, Response<OperateMyColutionSemandResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(OperateMySolutiondemandService.class);
	private static final String SERVICE_DESC = "方案已读需求";

	@Autowired
	UserDemandSolutionDAO userDemandSolutionDAO;
	@Override
	public void execute(OperateMyColutionSemandRequest request, Response<OperateMyColutionSemandResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);
		Long userid = UserTools.getLoginUser().getId();
		long id = Long.parseLong(request.getId().trim());
		UserDemandSolutionDO userDemandSolutionDO = new UserDemandSolutionDO();
		userDemandSolutionDO.setId(id);
		userDemandSolutionDO.setSolutionUserId(userid);
		userDemandSolutionDO.setIsReadDemand((byte)1);
		userDemandSolutionDO.setUpdateTime(new Date());
		userDemandSolutionDAO.updateByPrimaryKeySelective(userDemandSolutionDO);
	}
}
