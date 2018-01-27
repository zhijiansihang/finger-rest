package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.finger.app.dao.mysql.mapper.UserServiceRecordDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserServiceRecordDO;
import com.zhijiansihang.finger.gen.tool.CheckTools;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.ConsultingRecordRequest;
import com.zhijiansihang.finger.gen.entity.ConsultingRecordResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 点咨询记录
 * 
 */
@Component("consultingRecordService")
public class ConsultingRecordService implements MessageService<ConsultingRecordRequest, Response<ConsultingRecordResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(ConsultingRecordService.class);
	private static final String SERVICE_DESC = "点咨询记录";
@Autowired
	UserServiceRecordDAO userServiceRecordDAO;
	@Override
	public void execute(ConsultingRecordRequest request, Response<ConsultingRecordResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);
		Long userId = UserTools.getLoginUser().getId();
		String consultingUserid = request.getConsultingUserid();
		if (!CheckTools.isInteger(consultingUserid)){
			LOG.error(SERVICE_DESC+":传入的consultingUserid格式不正确");
			return;
		}
		UserServiceRecordDO userServiceRecordDO = new UserServiceRecordDO();
		userServiceRecordDO.setServiceType((byte)1);
		userServiceRecordDO.setCreateTime(new Date());
		userServiceRecordDO.setPersonUserId(userId);
		userServiceRecordDO.setUserId(Long.parseLong(consultingUserid));
		//1咨询2预约
		userServiceRecordDAO.insert(userServiceRecordDO);
	}
}
