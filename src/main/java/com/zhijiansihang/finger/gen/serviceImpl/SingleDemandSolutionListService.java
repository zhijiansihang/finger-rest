package com.zhijiansihang.finger.gen.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDemandSolutionDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDemandSolutionDO;
import com.zhijiansihang.finger.app.sharing.SharingProperties;
import com.zhijiansihang.finger.app.tool.Page;
import com.zhijiansihang.finger.app.vo.DemandMatchSolutionResult;
import com.zhijiansihang.finger.gen.tool.CheckTools;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.SingleDemandSolutionListRequest;
import com.zhijiansihang.finger.gen.entity.SingleDemandSolutionListResponse;
import com.zhijiansihang.finger.gen.entity.SingleDemandSolutionListResponse.SolutionListElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 需求所匹配的方案列表
 * 
 */
@Component("singleDemandSolutionListService")
public class SingleDemandSolutionListService implements MessageService<SingleDemandSolutionListRequest, Response<SingleDemandSolutionListResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(SingleDemandSolutionListService.class);
	private static final String SERVICE_DESC = "需求所匹配的方案列表";

	@Autowired
	UserDemandSolutionDAO userDemandSolutionDAO;
	@Autowired
	SharingProperties sharingProperties;
	@Override
	public void execute(SingleDemandSolutionListRequest request, Response<SingleDemandSolutionListResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		//需求id
		String demandId = request.getDemandId();
		//0:未读，1已读，2已采纳
		String type = request.getType();
		Long userId = UserTools.getLoginUser().getId();

		UserDemandSolutionDO userDemandSolutionDO = new UserDemandSolutionDO();
		userDemandSolutionDO.setDemandId(Long.parseLong(demandId));
		userDemandSolutionDO.setDemandUserId(userId);
		userDemandSolutionDO.setIsOperateSolution(Byte.parseByte(type));

		Long id = UserTools.getLoginUser().getId();
		Page<UserDemandSolutionDO, UserDO> page = Page.create();
		page.setCurrentPage(CheckTools.isInteger(request.getCurrentPage()) ? Integer.parseInt(request.getCurrentPage()) : 1);
		page.setPageSize(10);
		page.setSelect(userDemandSolutionDO);
		int count = userDemandSolutionDAO.countByDemandUserIdAndUserid(userDemandSolutionDO);
		page.setRecordCount(count);

		if (count > 0) {
			List<DemandMatchSolutionResult> cmsDOS = userDemandSolutionDAO.selectByDemandUserIdAndUseridPage(userDemandSolutionDO, page.getRowBounds());
			response.getBody().setSolutionList(getSolutionList(cmsDOS));
		}else {
			response.getBody().setSolutionList(new ArrayList<>());
		}
		response.getBody().setCurrentPage(page.getCurrentPage() + "");
		response.getBody().setPageCount(page.getPageCount() + "");
		response.getBody().setPageSize(page.getPageSize() + "");
		response.getBody().setRecordCount(page.getRecordCount() + "");
	}

	private List<SolutionListElement> getSolutionList(List<DemandMatchSolutionResult> cmsDOS) {
		List<SolutionListElement> elems = new ArrayList<SolutionListElement>();
		if (cmsDOS == null){
			return elems;
		}
		for (DemandMatchSolutionResult demandMatchSolutionResult : cmsDOS){
			SolutionListElement elem = new SolutionListElement();
			elems.add(elem);
			elem.setAdoptCount(demandMatchSolutionResult.getAdoptCount().toString());
			elem.setFriendCount(demandMatchSolutionResult.getFriendCounts().toString());
			elem.setId(demandMatchSolutionResult.getId().toString());
			elem.setInstitutionName(CheckTools.nullToEmptyString(demandMatchSolutionResult.getInstitutionName()));
			elem.setIsOperateSolution(demandMatchSolutionResult.getIsOperateSolution().toString());
			if (demandMatchSolutionResult.getLogo() == null || demandMatchSolutionResult.getLogo().trim().length() ==0){
				elem.setLogo("");
			}else {
				elem.setLogo(sharingProperties.getStaticServerLink()+demandMatchSolutionResult.getLogo().trim());
			}
			elem.setRealName(CheckTools.nullToEmptyString(demandMatchSolutionResult.getRealName()));
			elem.setSerialNumber(demandMatchSolutionResult.getSerialNumber().toString());
			elem.setServiceDirection(CheckTools.nullToEmptyString(demandMatchSolutionResult.getServiceDirection()));
			elem.setSolutionId(demandMatchSolutionResult.getSolutionId().toString());
			elem.setSolutionUserId(demandMatchSolutionResult.getSolutionUserId().toString());
		}


		return elems;
	}
}
