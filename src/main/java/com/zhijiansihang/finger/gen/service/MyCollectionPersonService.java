package com.zhijiansihang.finger.gen.service;

import java.util.ArrayList;
import java.util.List;

import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.MyCollectionPersonRequest;
import com.zhijiansihang.finger.gen.entity.MyCollectionPersonResponse;
import com.zhijiansihang.finger.gen.entity.MyCollectionPersonResponse.FinanceListElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Y我的收藏-店铺
 * 
 */
@Component("genmyCollectionPersonService")
public class MyCollectionPersonService implements MessageService<MyCollectionPersonRequest, Response<MyCollectionPersonResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(MyCollectionPersonService.class);
	private static final String SERVICE_DESC = "Y我的收藏-店铺";

	@Override
	public void execute(MyCollectionPersonRequest request, Response<MyCollectionPersonResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		response.getBody().setCurrentPage("1");
		response.getBody().setPageCount("1");
		response.getBody().setPageSize("10");
		response.getBody().setRecordCount("10");
		response.getBody().setFinanceList(getFinanceList());
	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}

	private List<FinanceListElement> getFinanceList() {
		List<FinanceListElement> elems = new ArrayList<FinanceListElement>();
		FinanceListElement elem = new FinanceListElement();
		elems.add(elem);

		elem.setAdoptCount("45");
		elem.setFinanceUserId("10000");
		elem.setId("1");
		elem.setInstitutionName("1");
		elem.setIsNameAuth("1");
		elem.setLoanCount("2");
		elem.setLogo("http://www.baidu.com/10000.png");
		elem.setPosition("经理");
		elem.setRealName("张经理");
		elem.setServiceDirection("信托基金私募");
		elem.setUserOrderCount("10");

		return elems;
	}
}
