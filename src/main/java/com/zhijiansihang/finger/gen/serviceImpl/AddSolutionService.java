package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.common.ResponseHeaderBuilder;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserCollectionDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserCollectionDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserCollectionDOExample;
import com.zhijiansihang.finger.app.sharing.lock.redis.RedisLock;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.AddSolutionRequest;
import com.zhijiansihang.finger.gen.entity.AddSolutionResponse;

import com.zhijiansihang.sys.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 增加收藏
 * 
 */
@Component("addSolutionService")
public class AddSolutionService implements MessageService<AddSolutionRequest, Response<AddSolutionResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(AddSolutionService.class);
	private static final String SERVICE_DESC = "增加收藏";
	@Autowired
	UserCollectionDAO userCollectionDAO;

	@Autowired
	RedisLock redisLock;
	@Override
	public void execute(AddSolutionRequest request, Response<AddSolutionResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		Long loginUserid = UserTools.getLoginUser().getId();
		String type = request.getType();
		String id = request.getId();
		UserCollectionDO userCollection =new UserCollectionDO();
		userCollection.setUserId(loginUserid);
		userCollection.setContentId(Long.parseLong(id));
		userCollection.setContentType(Byte.parseByte(type));
		String redisKey = this.getClass().getName() + "_" + loginUserid.toString();
		boolean tryLock = redisLock.tryLock(redisKey);
		if (tryLock){
			try {
				UserCollectionDO count = userCollectionDAO.getContentidtypeAndUserid(userCollection);
				if (count != null){
					response.getBody().setId(count.getId().toString());
					return;
				}
				userCollection.setCreateTime(new Date());
				userCollection.setUserId(loginUserid);
				int insert = userCollectionDAO.insert(userCollection);
				response.getBody().setId(insert+"");
			}finally {
				redisLock.unLock(redisKey);
			}
		}else {
			response.setHeader(ResponseHeaderBuilder.buildTimeout());
		}

	}
}
