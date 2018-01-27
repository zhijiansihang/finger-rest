package com.zhijiansihang.finger.gen.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.zhijiansihang.finger.app.dao.mysql.mapper.UserSolutionDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDemandDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserSolutionDO;
import com.zhijiansihang.finger.app.tool.Page;
import com.zhijiansihang.finger.gen.tool.CheckTools;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.MySolutionRequest;
import com.zhijiansihang.finger.gen.entity.MySolutionResponse;
import com.zhijiansihang.finger.gen.entity.MySolutionResponse.SolutionListElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 我的方案
 * 
 */
@Component("mySolutionService")
public class MySolutionService implements MessageService<MySolutionRequest, Response<MySolutionResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(MySolutionService.class);
	private static final String SERVICE_DESC = "我的方案";

	@Autowired
	UserSolutionDAO userSolutionDAO;
	@Override
	public void execute(MySolutionRequest request, Response<MySolutionResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);
		Long userid = UserTools.getLoginUser().getId();
		Page<Long, UserDemandDO> page = Page.create();
		page.setCurrentPage(CheckTools.isInteger(request.getCurrentPage()) ? Integer.parseInt(request.getCurrentPage()) : 1);
		page.setCurrentPage(CheckTools.isInteger(request.getPageSize()) ? Integer.parseInt(request.getPageSize()) : 10);
		page.setSelect(userid);
		int count = userSolutionDAO.countByUserid(userid);
		page.setRecordCount(count);

		if (count > 0) {
			List<UserSolutionDO> cmsDOS = userSolutionDAO.selectByUseridPage(userid, page.getRowBounds());
			response.getBody().setSolutionList(getSolutionList(cmsDOS));
		}else {
			response.getBody().setSolutionList(new ArrayList<>());
		}
		response.getBody().setCurrentPage(page.getCurrentPage() + "");
		response.getBody().setPageCount(page.getPageCount() + "");
		response.getBody().setPageSize(page.getPageSize() + "");
		response.getBody().setRecordCount(page.getRecordCount() + "");
	}

	private List<SolutionListElement> getSolutionList(List<UserSolutionDO> cmsDOS) {
		List<SolutionListElement> elems = new ArrayList<SolutionListElement>();
		if (cmsDOS == null){
			return elems;
		}
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd");
		for (UserSolutionDO userSolutionDO :cmsDOS){
			SolutionListElement elem = new SolutionListElement();
			elems.add(elem);
			elem.setCreateTime(time.format(userSolutionDO.getCreateTime()));
			elem.setEarningType(userSolutionDO.getEarningType().toString());
			elem.setExpectedDeadline(userSolutionDO.getExpectedDeadline().toString());
			elem.setId(userSolutionDO.getId().toString());
			elem.setIsClosed(userSolutionDO.getIsClosed().toString());
			elem.setMatchDemandCount(userSolutionDO.getMatchDemandCount().toString());
			elem.setMoneySituation(userSolutionDO.getMoneySituation().toString());
			elem.setRiskAssessmentLevel(userSolutionDO.getRiskAssessmentLevel().toString());
			elem.setSerialNumber(userSolutionDO.getSerialNumber()+"");
			elem.setSolution("方案NO."+userSolutionDO.getSolution());
		}
		return elems;
	}
}
