package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.common.ResponseHeader;
import com.zhijiansihang.common.ResponseHeaderBuilder;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDemandSolutionDAO;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserFinanceDetailDAO;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserSolutionDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDemandSolutionDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserSolutionDO;
import com.zhijiansihang.finger.gen.tool.CheckTools;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.OperateMyDemandsolutionRequest;
import com.zhijiansihang.finger.gen.entity.OperateMyDemandsolutionResponse;

import com.zhijiansihang.sys.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.zhijiansihang.common.RetCode.NOTSUPPORT;

/**
 * 需求采纳已读方案
 * 
 */
@Component("operateMyDemandsolutionService")
public class OperateMyDemandsolutionService implements MessageService<OperateMyDemandsolutionRequest, Response<OperateMyDemandsolutionResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(OperateMyDemandsolutionService.class);
	private static final String SERVICE_DESC = "需求采纳已读方案";

	@Autowired
	UserDemandSolutionDAO userDemandSolutionDAO;
	@Autowired
	UserSolutionDAO userSolutionDAO;
	@Autowired
	UserFinanceDetailDAO userFinanceDetailDAO;
	@Override
	public void execute(OperateMyDemandsolutionRequest request, Response<OperateMyDemandsolutionResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		Long userid = UserTools.getLoginUser().getId();
		int id = Integer.parseInt(request.getId());
		int type = Integer.parseInt(request.getType());
		UserDemandSolutionDO userDemandSolutionDO = userDemandSolutionDAO.selectByPrimaryKey((long) id);
		;
		UserSolutionDO userSolutionDO = userSolutionDAO.selectByPrimaryKey(userDemandSolutionDO.getSolutionId());
		if (type == 1){
			//已读
			int readMyDemandsolution = userDemandSolutionDAO.readMyDemandsolution(userid, id);
			if (readMyDemandsolution > 0){
				userSolutionDAO.readCountAdd(userDemandSolutionDO.getSolutionId());
			}
		}else if (type == 2){
			//采纳
			int i = userDemandSolutionDAO.adoptMyDemandsolution(userid, id);
			if (i>0){
				userSolutionDAO.adoptCountAdd(userDemandSolutionDO.getSolutionId());
				userFinanceDetailDAO.adoptCountAdd(userSolutionDO.getUserId());
			}
		}else {
			ResponseHeader responseHeader = ResponseHeaderBuilder.build(NOTSUPPORT,NOTSUPPORT.getMessage());
			response.setHeader(responseHeader);
			return;
		}
	}
}
