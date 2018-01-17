package com.zhijiansihang.finger.gen.controller;

import com.zhijiansihang.common.*;
import com.zhijiansihang.finger.gen.entity.AppVersionUpdateRequest;
import com.zhijiansihang.finger.gen.entity.AppVersionUpdateResponse;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.finger.mmc.MobileMessage;
import com.zhijiansihang.finger.mmc.MobileService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.databind.ObjectMapper;

@RequestMapping("/app")
@Controller
public class MobileController {

	private static final Logger LOG = LoggerFactory.getLogger(MobileController.class);
	
	private SimpleDateFormat timestampSDF = new SimpleDateFormat("yyyyMMddHHmmssSSS");

	@Autowired
	private MobileService mobileService;

	private ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private RedisTemplate redisTemplate;

	@Value("${redis.expire.timestamp.nonce:3}")
	public String redisExpireTimestampNonce;

	@Qualifier("appVersionUpdateService")
	@Autowired(required = false)
	MessageService<AppVersionUpdateRequest, Response<AppVersionUpdateResponse>> appVersionUpdateService;
	@Qualifier("genappVersionUpdateService")
	@Autowired(required = false)
	MessageService<AppVersionUpdateRequest, Response<AppVersionUpdateResponse>> genAppVersionUpdateService;


	@RequestMapping(value = "/appVersionUpdate", method = RequestMethod.POST)
	@ResponseBody
	public Response<AppVersionUpdateResponse> appVersionUpdate(@RequestBody AppVersionUpdateRequest request) {

		logRequest("appVersionUpdate", request);

		Response<AppVersionUpdateResponse> response = new Response<>();

		request = (AppVersionUpdateRequest) this.validate(request, response);
		if(null == request){
			return response;
		}
		response = getAppVersionUpdateResponse(request);
		
		logResponse("appVersionUpdate", response);

		return response;
	}


	private Response<AppVersionUpdateResponse> getAppVersionUpdateResponse(AppVersionUpdateRequest request) {

		MessageService<AppVersionUpdateRequest, Response<AppVersionUpdateResponse>> service = appVersionUpdateService;
		if (service == null) {
			service = genAppVersionUpdateService;
		}

		return mobileService.service(request, service, AppVersionUpdateRequest.class, AppVersionUpdateResponse.class);
	}

	/**
	 * 请求数据校验
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	private MobileMessage validate(MobileMessage request, Response response) {
		
		//版本校验
		if(StringUtils.isEmpty(request.getVersionCode())
				|| StringUtils.isEmpty(request.getMsgtimestamp()) 
				|| StringUtils.isEmpty(request.getPlatformType())
				|| StringUtils.isEmpty(request.getDeviceId())){
			response.getHeader().setCode(RetCode.VALIDATEERROR.getCode());
			response.getHeader().setMessage("参数错误，请更新客户端！");
			return null;
		}

		try {
			Integer.parseInt(request.getVersionCode()); // 版本号格式异常
		} catch (Exception e){
			response.getHeader().setCode(RetCode.VALIDATEERROR.getMessage());
			response.getHeader().setMessage("参数错误，请更新客户端！");
			return null;
		}
		
		//验重
		String rediskey = request.getDeviceId() + request.getMsgtimestamp() + request.getMsgnonce();

		if(redisTemplate.opsForValue().increment(rediskey, 1) > 1){
			response.getHeader().setCode(RetCode.VALIDATEERROR.getCode());
			response.getHeader().setCode("无效请求");
			return null;
		}
		redisTemplate.expire(rediskey,Long.parseLong(redisExpireTimestampNonce),TimeUnit.MINUTES);
		return request;
	}

	/**
	 * 请求日志
	 *
	 * @param service
	 * @param request
	 */
	private void logRequest(String service, MobileMessage request) {
		try {
			StringBuffer sb = new StringBuffer();
			sb.append(System.lineSeparator());
			sb.append("Request[").append(service).append("] begin").append(System.lineSeparator());
			sb.append(objectMapper.writeValueAsString(request)).append(System.lineSeparator());
			sb.append("Request[").append(service).append("] end");
			LOG.info(sb.toString());
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}
	
	/**
	 * 响应日志
	 * 
	 * @param service
	 * @param response
	 */
	private void logResponse(String service, Response response) {
		try {

			String responseJson = objectMapper.writeValueAsString(response);
			if(responseJson.length() > 1000){
				responseJson = responseJson.substring(0, 1000);
				responseJson += "......";
			}

			StringBuffer sb = new StringBuffer();
			sb.append(System.lineSeparator());
			sb.append("Response[").append(service).append("] begin").append(System.lineSeparator());
			sb.append(responseJson).append(System.lineSeparator());
			sb.append("Response[").append(service).append("] end");

			LOG.info(sb.toString());
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}

}
