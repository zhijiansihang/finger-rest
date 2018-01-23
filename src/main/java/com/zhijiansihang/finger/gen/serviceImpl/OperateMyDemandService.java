package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.common.ResponseHeader;
import com.zhijiansihang.common.ResponseHeaderBuilder;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDemandDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDemandDO;
import com.zhijiansihang.finger.gen.tool.CheckTools;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.OperateMyDemandRequest;
import com.zhijiansihang.finger.gen.entity.OperateMyDemandResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.zhijiansihang.common.RetCode.NOTSUPPORT;

/**
 * 删除关闭我的需求
 * 
 */
@Component("operateMyDemandService")
public class OperateMyDemandService implements MessageService<OperateMyDemandRequest, Response<OperateMyDemandResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(OperateMyDemandService.class);
	private static final String SERVICE_DESC = "删除关闭我的需求";

	@Autowired
	UserDemandDAO userDemandDAO;
	@Override
	public void execute(OperateMyDemandRequest request, Response<OperateMyDemandResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		Long userid = UserTools.getLoginUser().getId();
		String id = request.getId();
		String type = request.getType();
		if (!CheckTools.isInteger(id) || !CheckTools.isInteger(type)){
			ResponseHeader responseHeader = ResponseHeaderBuilder.buildValidateError("参数不能为空");
			response.setHeader(responseHeader);
			return;
		}
		UserDemandDO userDemandDO = new UserDemandDO();
		userDemandDO.setUserId(userid);
		userDemandDO.setId(Long.parseLong(id));
		//操作类型:1:关闭2:删除
		if (Integer.parseInt(type) == 1){
			userDemandDO.setIsClosed((byte) 1);
			userDemandDAO.updateByPrimaryKeySelective(userDemandDO);
		}else if(Integer.parseInt(type) == 2){
			userDemandDO.setIsDeleted((byte)1);
			userDemandDAO.updateByPrimaryKeySelective(userDemandDO);
		}else {
			ResponseHeader responseHeader = ResponseHeaderBuilder.build(NOTSUPPORT,NOTSUPPORT.getMessage());
			response.setHeader(responseHeader);
			return;
		}
	}
}
