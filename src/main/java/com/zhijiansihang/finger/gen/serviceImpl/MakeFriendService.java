package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.common.ResponseHeaderBuilder;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserFriendCountDAO;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserFriendDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserFriendCountDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserFriendDO;
import com.zhijiansihang.finger.app.sharing.lock.redis.RedisLock;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.MakeFriendRequest;
import com.zhijiansihang.finger.gen.entity.MakeFriendResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 交朋友
 * 
 */
@Component("makeFriendService")
public class MakeFriendService implements MessageService<MakeFriendRequest, Response<MakeFriendResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(MakeFriendService.class);
	private static final String SERVICE_DESC = "交朋友";
	@Autowired
	UserFriendCountDAO userFriendCountDAO;
	@Autowired
	UserFriendDAO userFriendDAO;
	@Autowired
	RedisLock redisLock;
	@Override
	public void execute(MakeFriendRequest request, Response<MakeFriendResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);
		Long userid = UserTools.getLoginUser().getId();
		long friendUserid = Integer.parseInt(request.getFriendUserid());

		UserFriendDO userFriendDO = new UserFriendDO();
		userFriendDO.setCreateTime(new Date());
		userFriendDO.setFriendUserId(friendUserid);
		userFriendDO.setMyUserId(userid);
		String redisKey = this.getClass().getName() + "_" + userid.toString();
		boolean tryLock = redisLock.tryLock(redisKey);
		if (tryLock){
			try {
				int count = userFriendDAO.existFriendUserid(userFriendDO);
				if (count>0){
					return;
				}
				userFriendDAO.insert(userFriendDO);
				userFriendCountDAO.addFriendCounts(userid);
			}finally {
				redisLock.unLock(redisKey);
			}
		}else {
			response.setHeader(ResponseHeaderBuilder.buildTimeout());
		}


	}
}
