package com.zhijiansihang.finger.gen.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDemandSolutionDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDemandSolutionDO;
import com.zhijiansihang.finger.app.sharing.SharingProperties;
import com.zhijiansihang.finger.app.tool.Page;
import com.zhijiansihang.finger.app.vo.DemandMatchSolutionResult;
import com.zhijiansihang.finger.app.vo.SolutionMatchDemandResult;
import com.zhijiansihang.finger.gen.tool.CheckTools;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.SingleSolutionDemandListRequest;
import com.zhijiansihang.finger.gen.entity.SingleSolutionDemandListResponse;
import com.zhijiansihang.finger.gen.entity.SingleSolutionDemandListResponse.DemandListElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 方案所匹配的需求列表
 * 
 */
@Component("singleSolutionDemandListService")
public class SingleSolutionDemandListService implements MessageService<SingleSolutionDemandListRequest, Response<SingleSolutionDemandListResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(SingleSolutionDemandListService.class);
	private static final String SERVICE_DESC = "方案所匹配的需求列表";

	@Autowired
	UserDemandSolutionDAO userDemandSolutionDAO;
	@Autowired
	SharingProperties sharingProperties;
	@Override
	public void execute(SingleSolutionDemandListRequest request, Response<SingleSolutionDemandListResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		//需求id
		String solutionId = request.getSolutionId();
		//0:未读，1已读
		String type = request.getType();
		Long userId = UserTools.getLoginUser().getId();

		UserDemandSolutionDO userDemandSolutionDO = new UserDemandSolutionDO();
		userDemandSolutionDO.setSolutionId(Long.parseLong(solutionId));
		userDemandSolutionDO.setSolutionUserId(userId);
		userDemandSolutionDO.setIsReadDemand(Byte.parseByte(type));

		Page<UserDemandSolutionDO, SolutionMatchDemandResult> page = Page.create();
		page.setCurrentPage(CheckTools.isInteger(request.getCurrentPage()) ? Integer.parseInt(request.getCurrentPage()) : 1);
		page.setPageSize(10);
		page.setSelect(userDemandSolutionDO);
		int count = userDemandSolutionDAO.countBySolutionUserIdAndUserid(userDemandSolutionDO);
		page.setRecordCount(count);

		if (count > 0) {
			List<SolutionMatchDemandResult> cmsDOS = userDemandSolutionDAO.selectBySolutionUserIdAndUseridPage(userDemandSolutionDO, page.getRowBounds());
			response.getBody().setDemandList(getDemandList(cmsDOS));
		}else {
			response.getBody().setDemandList(new ArrayList<>());
		}
		response.getBody().setCurrentPage(page.getCurrentPage() + "");
		response.getBody().setPageCount(page.getPageCount() + "");
		response.getBody().setPageSize(page.getPageSize() + "");
		response.getBody().setRecordCount(page.getRecordCount() + "");
	}

	private List<DemandListElement> getDemandList(List<SolutionMatchDemandResult> cmsDOS) {
		List<DemandListElement> elems = new ArrayList<DemandListElement>();
		if (cmsDOS == null){
			return elems;
		}
		for (SolutionMatchDemandResult solutionMatchDemandResult : cmsDOS){
			DemandListElement elem = new DemandListElement();
			elems.add(elem);
			elem.setDemandId(solutionMatchDemandResult.getDemandId().toString());
			elem.setDemandUserId(solutionMatchDemandResult.getDemandUserId().toString());
			elem.setId(solutionMatchDemandResult.getId().toString());
			elem.setIsRead(solutionMatchDemandResult.getIsReadDemand().toString());
			if (solutionMatchDemandResult.getLogo() == null || solutionMatchDemandResult.getLogo().trim().length() ==0){
				elem.setLogo("");
			}else {
				elem.setLogo(sharingProperties.getStaticServerLink()+solutionMatchDemandResult.getLogo().trim());
			}
			elem.setRealName(CheckTools.nullToEmptyString(solutionMatchDemandResult.getNickName()));
			elem.setSerialNumber(solutionMatchDemandResult.getSerialNumber().toString());
		}
		return elems;
	}
}
