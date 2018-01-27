package com.zhijiansihang.finger.gen.service;

import java.util.ArrayList;
import java.util.List;

import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.GetCmsRequest;
import com.zhijiansihang.finger.gen.entity.GetCmsResponse;
import com.zhijiansihang.finger.gen.entity.GetCmsResponse.CmsListElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Y获取banner咨询公告
 * 
 */
@Component("gengetCmsService")
public class GetCmsService implements MessageService<GetCmsRequest, Response<GetCmsResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(GetCmsService.class);
	private static final String SERVICE_DESC = "Y获取banner咨询公告";

	@Override
	public void execute(GetCmsRequest request, Response<GetCmsResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		response.getBody().setCurrentPage("1");
		response.getBody().setPageCount("1");
		response.getBody().setPageSize("10");
		response.getBody().setRecordCount("10");
		response.getBody().setTypeCode("1000");
		response.getBody().setCmsList(getCmsList());
	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}

	private List<CmsListElement> getCmsList() {
		List<CmsListElement> elems = new ArrayList<CmsListElement>();
		CmsListElement elem = new CmsListElement();
		elems.add(elem);

		elem.setContent("10");
		elem.setHrefLink("10");
		elem.setId("1");
		elem.setImageAccessPath("1");
		elem.setSubTitle("1");
		elem.setTitle("1");

		return elems;
	}
}
