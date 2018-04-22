package com.zhijiansihang.finger.gen.serviceImpl;

import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDemandSolutionDAO;
import com.zhijiansihang.finger.app.sharing.SharingProperties;
import com.zhijiansihang.finger.app.vo.DemandMatchSolutionResult;
import com.zhijiansihang.finger.gen.entity.GetMySolutionTop10Request;
import com.zhijiansihang.finger.gen.entity.GetMySolutionTop10Response;
import com.zhijiansihang.finger.gen.entity.GetMySolutionTop10Response.SolutionListElement;
import com.zhijiansihang.finger.gen.entity.SingleDemandSolutionListResponse;
import com.zhijiansihang.finger.gen.tool.CheckTools;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取用户匹配方案
 * 
 */
@Component("getMySolutionTop10Service")
public class GetMySolutionTop10Service implements MessageService<GetMySolutionTop10Request, Response<GetMySolutionTop10Response>> {

	private static final Logger LOG = LoggerFactory.getLogger(GetMySolutionTop10Service.class);
	private static final String SERVICE_DESC = "获取用户匹配方案";

	@Autowired
	UserDemandSolutionDAO userDemandSolutionDAO;

	@Autowired
	SharingProperties sharingProperties;
	@Override
	public void execute(GetMySolutionTop10Request request, Response<GetMySolutionTop10Response> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		Long loginuserid = UserTools.getLoginUser().getId();
		List<DemandMatchSolutionResult> cmsDOS = userDemandSolutionDAO.getUserMatchSolutionTop10(loginuserid);
		response.getBody().setSolutionList(getSolutionList(cmsDOS));
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
			if (demandMatchSolutionResult.getLogo() != null && demandMatchSolutionResult.getLogo().trim().length() > 0){
				elem.setLogo(sharingProperties.getStaticServerLink()+demandMatchSolutionResult.getLogo().trim());
			}else {
				elem.setLogo("");
			}

			elem.setRealName(CheckTools.nullToEmptyString(demandMatchSolutionResult.getNickName()));
			elem.setSerialNumber(demandMatchSolutionResult.getSerialNumber().toString());
			elem.setServiceDirection(CheckTools.nullToEmptyString(demandMatchSolutionResult.getServiceDirection()));
			elem.setSolutionId(demandMatchSolutionResult.getSolutionId().toString());
			elem.setSolutionUserId(demandMatchSolutionResult.getSolutionUserId().toString());
		}

		return elems;
	}
}
