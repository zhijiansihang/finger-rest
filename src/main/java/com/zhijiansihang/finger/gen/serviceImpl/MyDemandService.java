package com.zhijiansihang.finger.gen.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDemandDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDemandDO;
import com.zhijiansihang.finger.app.tool.Page;
import com.zhijiansihang.finger.gen.tool.CheckTools;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.MyDemandRequest;
import com.zhijiansihang.finger.gen.entity.MyDemandResponse;
import com.zhijiansihang.finger.gen.entity.MyDemandResponse.DemandListElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 我的需求
 * 
 */
@Component("myDemandService")
public class MyDemandService implements MessageService<MyDemandRequest, Response<MyDemandResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(MyDemandService.class);
	private static final String SERVICE_DESC = "我的需求";

	@Autowired
	UserDemandDAO userDemandDAO;
	@Override
	public void execute(MyDemandRequest request, Response<MyDemandResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		Long userid = UserTools.getLoginUser().getId();
		Page<Long, UserDemandDO> page = Page.create();
		page.setCurrentPage(CheckTools.isInteger(request.getCurrentPage()) ? Integer.parseInt(request.getCurrentPage()) : 1);
		page.setPageSize(CheckTools.isInteger(request.getPageSize()) ? Integer.parseInt(request.getPageSize()) : 10);
		page.setSelect(userid);
		int count = userDemandDAO.countByUserid(userid);
		page.setRecordCount(count);

		if (count > 0) {
			List<UserDemandDO> cmsDOS = userDemandDAO.selectByUseridPage(userid, page.getRowBounds());
			response.getBody().setDemandList(getDemandList(cmsDOS));
		}else {
			response.getBody().setDemandList(new ArrayList<>());
		}
		response.getBody().setCurrentPage(page.getCurrentPage() + "");
		response.getBody().setPageCount(page.getPageCount() + "");
		response.getBody().setPageSize(page.getPageSize() + "");
		response.getBody().setRecordCount(page.getRecordCount() + "");
	}

	private List<DemandListElement> getDemandList(List<UserDemandDO> cmsDOS ) {
		List<DemandListElement> elems = new ArrayList<DemandListElement>();
		if (cmsDOS==null){
			return elems;
		}
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd");
		for (UserDemandDO userDemandDO:cmsDOS) {
			DemandListElement elem = new DemandListElement();
			elems.add(elem);

			elem.setAdditionalRemarks(CheckTools.nullToEmptyString(userDemandDO.getAdditionalRemarks()));
			elem.setCreateTime(time.format(userDemandDO.getCreateTime()));
			elem.setEarningType(userDemandDO.getEarningType().toString());
			elem.setExpectedDeadline(userDemandDO.getExpectedDeadline().toString());
			elem.setId(userDemandDO.getId().toString());
			elem.setIsClosed(userDemandDO.getIsClosed().toString());
			elem.setMatchSolutionCount(userDemandDO.getMatchSolutionCount().toString());
			elem.setMoneySituation(userDemandDO.getMoneySituation().toString());
			elem.setSerialNumber(userDemandDO.getSerialNumber().toString());
		}
		return elems;
	}
}
