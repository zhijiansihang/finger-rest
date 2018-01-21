package com.zhijiansihang.finger.gen.service;

import java.util.ArrayList;
import java.util.List;

import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.ServicePersonRecordRequest;
import com.zhijiansihang.finger.gen.entity.ServicePersonRecordResponse;
import com.zhijiansihang.finger.gen.entity.ServicePersonRecordResponse.ServicePersonListElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 点咨询和预约客户
 * 
 */
@Component("genservicePersonRecordService")
public class ServicePersonRecordService implements MessageService<ServicePersonRecordRequest, Response<ServicePersonRecordResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(ServicePersonRecordService.class);
	private static final String SERVICE_DESC = "点咨询和预约客户";

	@Override
	public void execute(ServicePersonRecordRequest request, Response<ServicePersonRecordResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		response.getBody().setCurrentPage("1");
		response.getBody().setPageCount("1");
		response.getBody().setPageSize("10");
		response.getBody().setRecordCount("10");
		response.getBody().setServicePersonList(getServicePersonList());
	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}

	private List<ServicePersonListElement> getServicePersonList() {
		List<ServicePersonListElement> elems = new ArrayList<ServicePersonListElement>();
		ServicePersonListElement elem = new ServicePersonListElement();
		elems.add(elem);

		elem.setCreateTime("2017-12-12");
		elem.setLogo("1");
		elem.setRealName("1");
		elem.setType("1");

		return elems;
	}
}
