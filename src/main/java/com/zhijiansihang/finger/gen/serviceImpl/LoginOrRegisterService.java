package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.common.ResponseHeader;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import com.zhijiansihang.finger.app.service.UserDetailService;
import com.zhijiansihang.finger.app.sharing.message.VerificationCodeTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.LoginOrRegisterRequest;
import com.zhijiansihang.finger.gen.entity.LoginOrRegisterResponse;

import com.zhijiansihang.gateway.util.JwtTokenUtil;
import com.zhijiansihang.gateway.util.UserSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.zhijiansihang.common.RetCode.USERLOCKED;
import static com.zhijiansihang.common.RetCode.VALIDATEERROR;

/**
 * 注册或者登陆
 * 
 */
@Component("loginOrRegisterService")
public class LoginOrRegisterService implements MessageService<LoginOrRegisterRequest, Response<LoginOrRegisterResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(LoginOrRegisterService.class);
	private static final String SERVICE_DESC = "注册或者登陆";

	@Autowired
	UserDetailService userDetailService;
	@Autowired
	VerificationCodeTools verificationCodeTools;

	@Autowired
	JwtTokenUtil jwtTokenUtil;
	@Override
	public void execute(LoginOrRegisterRequest request, Response<LoginOrRegisterResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		String mobile = request.getMobile();
		String smsCode = request.getSmsCode();

		boolean check = verificationCodeTools.check(mobile, smsCode);
		if (!check){
			ResponseHeader responseHeader = new
					ResponseHeader();
			responseHeader.setCode(VALIDATEERROR.getCode());
			responseHeader.setMessage("短信验证码错误");
			response.setHeader(responseHeader);
			return;
		}

		UserDO userDO = userDetailService.getUserByMobile(mobile);
		if (userDO==null){
			//不存在就注册
			userDO = userDetailService.register(mobile);
		}
		Byte isFrozen = userDO.getIsFrozen();
		if (isFrozen.intValue() == 1){
			ResponseHeader responseHeader = new
					ResponseHeader();
			responseHeader.setCode(USERLOCKED.getCode());
			responseHeader.setMessage("用户被冻结");
			response.setHeader(responseHeader);
			return;
		}

		UserSession session =new UserSession();
		session.setMobile(userDO.getMobile());
		session.setId(userDO.getUserId());
		session.setDisabled(false);
		//TODO 角色
		session.setRoleNames(null);
		String generate = jwtTokenUtil.generate(session);
		response.getBody().setIdCard(userDO.getIdCard());
		response.getBody().setIsNameAuth(userDO.getIsNameAuth().toString());
		response.getBody().setIsRegisterJg(userDO.getIsRegisterJg().toString());
		response.getBody().setLogo(userDO.getLogo());
		response.getBody().setMobile(userDO.getMobile());
		response.getBody().setNickName(userDO.getNickName());
		response.getBody().setRealName(userDO.getRealName());
		response.getBody().setRiskAssessmentLevel(userDO.getRiskAssessmentLevel()==null ? "":userDO.getRiskAssessmentLevel().toString());
		response.getBody().setRoles(userDO.getRoles().toString());
		response.getBody().setSessionId(generate);
		response.getBody().setUserId(userDO.getUserId().toString());
	}
}
