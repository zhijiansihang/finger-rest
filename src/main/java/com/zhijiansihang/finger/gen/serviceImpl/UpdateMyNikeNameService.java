package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.common.Response;
import com.zhijiansihang.common.ResponseHeader;
import com.zhijiansihang.common.ResponseHeaderBuilder;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import com.zhijiansihang.finger.gen.entity.UpdateMyNikeNameRequest;
import com.zhijiansihang.finger.gen.entity.UpdateMyNikeNameResponse;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.gateway.security.core.JwtUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 更新我的昵称
 * 
 */
@Component("updateMyNikeNameService")
public class UpdateMyNikeNameService implements MessageService<UpdateMyNikeNameRequest, Response<UpdateMyNikeNameResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(UpdateMyNikeNameService.class);
	private static final String SERVICE_DESC = "更新我的昵称";

	@Autowired
	UserDAO userDAO;
	@Override
	public void execute(UpdateMyNikeNameRequest request, Response<UpdateMyNikeNameResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);
		JwtUserDetails principal = UserTools.getLoginUser();
		String nikeName = request.getNikeName();
		Long userid = principal.getId();
		if (!StringUtils.hasLength(nikeName)){
			ResponseHeader responseHeader = ResponseHeaderBuilder.buildValidateError("短信验证码错误");
			response.setHeader(responseHeader);
			return;
		}
		UserDO userDO = new UserDO();
		userDO.setUserId(userid);
		userDO.setNickName(nikeName);
		userDAO.updateByPrimaryKeySelective(userDO);
	}
}
