package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDemandDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDemandDO;
import com.zhijiansihang.finger.gen.tool.CheckTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.DemandDetailRequest;
import com.zhijiansihang.finger.gen.entity.DemandDetailResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 需求详情
 * 
 */
@Component("demandDetailService")
public class DemandDetailService implements MessageService<DemandDetailRequest, Response<DemandDetailResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(DemandDetailService.class);
	private static final String SERVICE_DESC = "需求详情";

	@Autowired
	UserDemandDAO userDemandDAO;
	@Override
	public void execute(DemandDetailRequest request, Response<DemandDetailResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);
		String demandId = request.getDemandId();
		UserDemandDO userDemandDO = userDemandDAO.selectByPrimaryKey(Long.parseLong(demandId));
		response.getBody().setAdditionalRemarks(CheckTools.nullToEmptyString(userDemandDO.getAdditionalRemarks()));
		response.getBody().setDemandUserid(userDemandDO.getUserId().toString());
		response.getBody().setEarningType(userDemandDO.getEarningType().toString());
		response.getBody().setExpectedDeadline(userDemandDO.getExpectedDeadline().toString());
		response.getBody().setMoneySituation(userDemandDO.getMoneySituation().toString());
		response.getBody().setSerialNumber(userDemandDO.getSerialNumber().toString());
	}
}
