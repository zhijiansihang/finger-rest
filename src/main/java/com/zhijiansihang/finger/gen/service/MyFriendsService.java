package com.zhijiansihang.finger.gen.service;

import java.util.ArrayList;
import java.util.List;

import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.MyFriendsRequest;
import com.zhijiansihang.finger.gen.entity.MyFriendsResponse;
import com.zhijiansihang.finger.gen.entity.MyFriendsResponse.FriendListElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Y我的好友
 * 
 */
@Component("genmyFriendsService")
public class MyFriendsService implements MessageService<MyFriendsRequest, Response<MyFriendsResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(MyFriendsService.class);
	private static final String SERVICE_DESC = "Y我的好友";

	@Override
	public void execute(MyFriendsRequest request, Response<MyFriendsResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		response.getBody().setCurrentPage("1");
		response.getBody().setPageCount("1");
		response.getBody().setPageSize("10");
		response.getBody().setRecordCount("10");
		response.getBody().setFriendList(getFriendList());
	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}

	private List<FriendListElement> getFriendList() {
		List<FriendListElement> elems = new ArrayList<FriendListElement>();
		FriendListElement elem = new FriendListElement();
		elems.add(elem);

		elem.setFriendUserId("1");
		elem.setJgName("");
		elem.setLogo("1");
		elem.setRealName("2017-12-12");

		return elems;
	}
}
