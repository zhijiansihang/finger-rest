package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.SessionIdIsOkRequest;
import com.zhijiansihang.finger.gen.entity.SessionIdIsOkResponse;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * sessionId是否ok
 * 
 */
@Component("sessionIdIsOkService")
public class SessionIdIsOkService implements MessageService<SessionIdIsOkRequest, Response<SessionIdIsOkResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(SessionIdIsOkService.class);
	private static final String SERVICE_DESC = "sessionId是否ok";

	@Override
	public void execute(SessionIdIsOkRequest request, Response<SessionIdIsOkResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		try {
			Long userid = UserTools.getLoginUser().getId();
			if (userid!=null && userid.intValue() >=0){
				response.getBody().setStatus("1");
			}else {
				response.getBody().setStatus("0");
			}
		}catch (Exception e){
			response.getBody().setStatus("0");
		}



	}
}
