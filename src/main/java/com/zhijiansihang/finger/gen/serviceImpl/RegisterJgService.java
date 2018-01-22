package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.RegisterJgRequest;
import com.zhijiansihang.finger.gen.entity.RegisterJgResponse;

import com.zhijiansihang.gateway.security.core.JwtUserDetails;
import com.zhijiansihang.sys.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 注册极光
 * 
 */
@Component("registerJgService")
public class RegisterJgService implements MessageService<RegisterJgRequest, Response<RegisterJgResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(RegisterJgService.class);
	private static final String SERVICE_DESC = "注册极光";
	@Autowired
	UserDAO userDAO;
	@Override
	public void execute(RegisterJgRequest request, Response<RegisterJgResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);
		JwtUserDetails loginUser = UserTools.getLoginUser();
		Long loginUserId = loginUser.getId();
		UserDO userDO = new UserDO();
		userDO.setUserId(loginUserId);
		userDO.setIsRegisterJg((byte)1);
		userDAO.updateByPrimaryKeySelective(userDO);
	}
}
