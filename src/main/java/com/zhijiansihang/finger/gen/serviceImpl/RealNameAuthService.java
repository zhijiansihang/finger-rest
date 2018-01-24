package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.common.Response;
import com.zhijiansihang.common.ResponseHeader;
import com.zhijiansihang.common.ResponseHeaderBuilder;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import com.zhijiansihang.finger.app.manager.RealNameAuthManager;
import com.zhijiansihang.finger.app.sharing.lock.redis.RedisLock;
import com.zhijiansihang.finger.gen.entity.RealNameAuthRequest;
import com.zhijiansihang.finger.gen.entity.RealNameAuthResponse;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.gateway.security.core.JwtUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;

import static com.zhijiansihang.common.RetCode.INTERNALEXCEP;

/**
 * 实名认证
 * 
 */
@Component("realNameAuthService")
public class RealNameAuthService implements MessageService<RealNameAuthRequest, Response<RealNameAuthResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(RealNameAuthService.class);
	private static final String SERVICE_DESC = "实名认证";

	@Autowired
	UserDAO userDAO;

	@Autowired
	RealNameAuthManager realNameAuthManager;
	@Autowired
	RedisLock redisLock;
	@Override
	public void execute(RealNameAuthRequest request, Response<RealNameAuthResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		JwtUserDetails principal = UserTools.getLoginUser();

		String realName = request.getRealName();
		String idCard = request.getIdCard();
		if (!StringUtils.hasLength(realName)){
			ResponseHeader responseHeader = ResponseHeaderBuilder.buildValidateError("姓名不能为空");
			response.setHeader(responseHeader);
			return;
		}
		if (!StringUtils.hasLength(idCard)){
			ResponseHeader responseHeader = ResponseHeaderBuilder.buildValidateError("身份证不能为空");
			response.setHeader(responseHeader);
			return;
		}
		String redisKey = this.getClass().getName() + "_" + principal.getId().toString();
		boolean tryLock = redisLock.tryLock(redisKey);
		if (tryLock){
			try {

				int count = userDAO.existIdCardAndRealName(realName,idCard);
				if (count>0){
					ResponseHeader responseHeader = ResponseHeaderBuilder.buildValidateError("该身份证和姓名已存在");
					response.setHeader(responseHeader);
					return;
				}
				boolean real =false;

				try {
					real = realNameAuthManager.isReal(realName, idCard);
				} catch (Exception e) {
					e.printStackTrace();
					ResponseHeader responseHeader = ResponseHeaderBuilder.build(INTERNALEXCEP,"请稍后重试");
					response.setHeader(responseHeader);
					return;
				}
				if (!real){
					ResponseHeader responseHeader = ResponseHeaderBuilder.buildValidateError("实名认证失败");
					response.setHeader(responseHeader);
					return;
				}
				UserDO userDO = new UserDO();
				userDO.setUserId(principal.getId());
				userDO.setRealName(realName);
				userDO.setIdCard(idCard);
				userDO.setIsNameAuth((byte) 1);
				userDAO.updateByPrimaryKeySelective(userDO);
			}finally {
				redisLock.unLock(redisKey);
			}
		}else {
			response.setHeader(ResponseHeaderBuilder.buildTimeout());
		}
	}
}
