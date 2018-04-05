package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserCollectionDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserCollectionDO;
import com.zhijiansihang.finger.gen.entity.IsCollectedRequest;
import com.zhijiansihang.finger.gen.entity.IsCollectedResponse;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 是否收藏
 * 
 */
@Component("isCollectedService")
public class IsCollectedService implements MessageService<IsCollectedRequest, Response<IsCollectedResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(IsCollectedService.class);
	private static final String SERVICE_DESC = "是否收藏";

	@Autowired
	UserCollectionDAO userCollectionDAO;
	@Override
	public void execute(IsCollectedRequest request, Response<IsCollectedResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);
		Long userid = UserTools.getLoginUser().getId();
		String id = request.getId();
		String type = request.getType();


		UserCollectionDO userCollectionDO = new UserCollectionDO();
		userCollectionDO.setUserId(userid);
		userCollectionDO.setContentId(Long.parseLong(id));
		userCollectionDO.setContentType(Byte.valueOf(type));
		int i = userCollectionDAO.existContentidtypeAndUserid(userCollectionDO);
		if (i>0){
			response.getBody().setStatus("1");
		}else{
			response.getBody().setStatus("0");
		}


	}
}
