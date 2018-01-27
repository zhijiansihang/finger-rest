package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserFriendDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserFriendDO;
import com.zhijiansihang.finger.gen.entity.IsFriendRequest;
import com.zhijiansihang.finger.gen.entity.IsFriendResponse;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 是否是好友关系
 * 
 */
@Component("isFriendService")
public class IsFriendService implements MessageService<IsFriendRequest, Response<IsFriendResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(IsFriendService.class);
	private static final String SERVICE_DESC = "是否是好友关系";
	@Autowired
	UserFriendDAO userFriendDAO;
	@Override
	public void execute(IsFriendRequest request, Response<IsFriendResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		Long userid = UserTools.getLoginUser().getId();
		UserFriendDO userFriendDO = new UserFriendDO();
		userFriendDO.setMyUserId(userid);
		userFriendDO.setFriendUserId(Long.parseLong(request.getFriendUserid()));
		int i = userFriendDAO.existFriendUserid(userFriendDO);
		if (i>0){
			response.getBody().setResult("1");
		}else {
			response.getBody().setResult("0");
		}
	}
}
