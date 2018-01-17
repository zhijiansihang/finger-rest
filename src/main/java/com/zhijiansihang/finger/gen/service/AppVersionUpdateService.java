package com.zhijiansihang.finger.gen.service;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.AppVersionUpdateRequest;
import com.zhijiansihang.finger.gen.entity.AppVersionUpdateResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 检查版本更新
 * 
 */
@Component("genappVersionUpdateService")
public class AppVersionUpdateService implements MessageService<AppVersionUpdateRequest, Response<AppVersionUpdateResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(AppVersionUpdateService.class);
	private static final String SERVICE_DESC = "检查版本更新";



	@Override
	public void execute(AppVersionUpdateRequest request, Response<AppVersionUpdateResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);
		
		response.getBody().setContent("");
		response.getBody().setFlag("");
		response.getBody().setTitle("");
		response.getBody().setUpdateTime("");
		response.getBody().setUrl("");
		response.getBody().setVersionName("");
	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
	  	response.getBody().setMode("test");
	}

}
