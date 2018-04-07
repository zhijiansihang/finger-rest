package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.finger.app.constant.UserConsts;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import com.zhijiansihang.finger.app.sharing.SharingProperties;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.GetUserRequest;
import com.zhijiansihang.finger.gen.entity.GetUserResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import static com.zhijiansihang.finger.app.constant.CmsConsts.getRiskAssessment;

/**
 * 获取用户
 * 
 */
@Component("getUserService")
public class GetUserService implements MessageService<GetUserRequest, Response<GetUserResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(GetUserService.class);
	private static final String SERVICE_DESC = "获取用户";

	@Autowired
	UserDAO userDAO;
	@Autowired
	SharingProperties sharingProperties;

	@Override
	public void execute(GetUserRequest request, Response<GetUserResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		Long id = UserTools.getLoginUser().getId();
		UserDO userDO = userDAO.selectByPrimaryKey(id);

		response.getBody().setIdCard(userDO.getIdCard());
		response.getBody().setIsNameAuth(userDO.getIsNameAuth()==null?"0":userDO.getIsNameAuth().toString());
		response.getBody().setIsRegisterJg(userDO.getIsRegisterJg()==null?"0":userDO.getIsRegisterJg().toString());
		response.getBody().setLogo(StringUtils.hasText(userDO.getLogo())?sharingProperties.getStaticServerLink()+userDO.getLogo():"");
		response.getBody().setMobile(userDO.getMobile());
		response.getBody().setNickName(userDO.getNickName()==null?"":userDO.getNickName());
		response.getBody().setRealName(userDO.getRealName()==null?"":userDO.getRealName());
		if (userDO.getRiskAssessmentLevel()==null){
			response.getBody().setRiskAssessmentLevel("");
		}	else {
			response.getBody().setRiskAssessmentLevel(getRiskAssessment(userDO.getRiskAssessmentLevel().intValue()));
		}
		response.getBody().setRoles(userDO.getRoles() == null ? "":userDO.getRoles().toString());
		response.getBody().setUserId(id.toString());
	}
}
