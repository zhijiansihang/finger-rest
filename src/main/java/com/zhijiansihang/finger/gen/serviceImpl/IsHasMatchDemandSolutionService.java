package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDemandSolutionDAO;
import com.zhijiansihang.finger.gen.entity.IsHasMatchDemandSolutionRequest;
import com.zhijiansihang.finger.gen.entity.IsHasMatchDemandSolutionResponse;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 是否有匹配需求的方案
 * 
 */
@Component("isHasMatchDemandSolutionService")
public class IsHasMatchDemandSolutionService implements MessageService<IsHasMatchDemandSolutionRequest, Response<IsHasMatchDemandSolutionResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(IsHasMatchDemandSolutionService.class);
	private static final String SERVICE_DESC = "是否有匹配需求的方案";


	@Autowired
	UserDemandSolutionDAO userDemandSolutionDAO;
	@Override
	public void execute(IsHasMatchDemandSolutionRequest request, Response<IsHasMatchDemandSolutionResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		Long id = UserTools.getLoginUser().getId();

		int i = userDemandSolutionDAO.countByDemandUserId(id);
		if (i>0){
			response.getBody().setIsHas("1");
		}else {
			response.getBody().setIsHas("0");
		}

	}
}
