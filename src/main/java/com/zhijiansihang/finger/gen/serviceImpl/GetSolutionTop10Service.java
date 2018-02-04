package com.zhijiansihang.finger.gen.serviceImpl;

import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDemandSolutionDAO;
import com.zhijiansihang.finger.app.sharing.SharingProperties;
import com.zhijiansihang.finger.app.sharing.SharingSpringConfig;
import com.zhijiansihang.finger.app.vo.DemandMatchSolutionResult;
import com.zhijiansihang.finger.gen.entity.GetMySolutionTop10Response;
import com.zhijiansihang.finger.gen.entity.GetSolutionTop10Request;
import com.zhijiansihang.finger.gen.entity.GetSolutionTop10Response;
import com.zhijiansihang.finger.gen.entity.GetSolutionTop10Response.SolutionListElement;
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
 * 取采纳次数最高的top10方案
 * 
 */
@Component("getSolutionTop10Service")
public class GetSolutionTop10Service implements MessageService<GetSolutionTop10Request, Response<GetSolutionTop10Response>> {

	private static final Logger LOG = LoggerFactory.getLogger(GetSolutionTop10Service.class);
	private static final String SERVICE_DESC = "取采纳次数最高的top10方案";

	@Autowired
	UserDemandSolutionDAO userDemandSolutionDAO;

	@Autowired
	SharingProperties sharingProperties;
	@Override
	public void execute(GetSolutionTop10Request request, Response<GetSolutionTop10Response> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		List<DemandMatchSolutionResult> cmsDOS = userDemandSolutionDAO.getAllMatchSolutionTop10();
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
			elem.setInstitutionName(CheckTools.nullToEmptyString(demandMatchSolutionResult.getInstitutionName()));
			if (demandMatchSolutionResult.getLogo() != null && demandMatchSolutionResult.getLogo().trim().length() > 0){
				elem.setLogo(sharingProperties.getStaticServerLink()+demandMatchSolutionResult.getLogo().trim());
			}else {
				elem.setLogo("");
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
