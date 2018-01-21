package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.ConsultingRecordRequest;
import com.zhijiansihang.finger.gen.entity.ConsultingRecordResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 点咨询记录
 * 
 */
@Component("consultingRecordService")
public class ConsultingRecordService implements MessageService<ConsultingRecordRequest, Response<ConsultingRecordResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(ConsultingRecordService.class);
	private static final String SERVICE_DESC = "点咨询记录";

	@Override
	public void execute(ConsultingRecordRequest request, Response<ConsultingRecordResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}
}
