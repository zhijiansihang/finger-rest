package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.common.ResponseHeader;
import com.zhijiansihang.common.ResponseHeaderBuilder;
import com.zhijiansihang.finger.app.constant.UserConsts;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDAO;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserFinanceDetailDAO;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserFriendDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserFinanceDetailDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserFriendDO;
import com.zhijiansihang.finger.gen.tool.CheckTools;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.UpdateFinanceDetailRequest;
import com.zhijiansihang.finger.gen.entity.UpdateFinanceDetailResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.zhijiansihang.common.RetCode.NOPERMISSION;

/**
 * 更新我的资料
 * 
 */
@Component("updateFinanceDetailService")
public class UpdateFinanceDetailService implements MessageService<UpdateFinanceDetailRequest, Response<UpdateFinanceDetailResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(UpdateFinanceDetailService.class);
	private static final String SERVICE_DESC = "更新我的资料";

	@Autowired
	UserDAO userDAO;
	@Autowired
	UserFinanceDetailDAO userFinanceDetailDAO;
	@Override
	public void execute(UpdateFinanceDetailRequest request, Response<UpdateFinanceDetailResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		Long userId = UserTools.getLoginUser().getId();
		UserDO userDO = userDAO.selectByPrimaryKey(userId);
		Short roles = userDO.getRoles();
		if (!UserConsts.UserRolesEnum.FINANCE.name().equals(UserConsts.getUserRoles(roles.intValue()))){
			ResponseHeader responseHeader = ResponseHeaderBuilder.build(NOPERMISSION,"只允许理财师可以操作");
			response.setHeader(responseHeader);
			return;
		}
		UserFinanceDetailDO userFinanceDetailDO = new UserFinanceDetailDO();
		userFinanceDetailDO.setUserId(userId);
		userFinanceDetailDO.setEducationLevel(CheckTools.nullToNullString(request.getEducationLevel()));
		if (request.getWorkAge() != null || CheckTools.isInteger(request.getWorkAge().toString()) ){
			userFinanceDetailDO.setWorkAge(Short.parseShort(request.getWorkAge().toString()));
		}else {
			userFinanceDetailDO.setWorkAge(Short.parseShort("1"));
		}
		userFinanceDetailDO.setSchoolName(CheckTools.nullToNullString(request.getSchoolName()));
		userFinanceDetailDO.setPosition(CheckTools.nullToNullString(request.getPosition()));
		userFinanceDetailDO.setServiceDirection(CheckTools.nullToNullString(request.getServiceDirection()));
		userFinanceDetailDO.setServiceConcept(CheckTools.nullToNullString(request.getServiceConcept()));
		userFinanceDetailDO.setWorkingExperience(CheckTools.nullToNullString(request.getWorkingExperience()));
		userFinanceDetailDO.setPersonalProfile(CheckTools.nullToNullString(request.getPersonalProfile()));
		userFinanceDetailDO.setIsAdd((byte)1);

		userFinanceDetailDAO.updateByPrimaryKeySelective(userFinanceDetailDO);
	}
}
