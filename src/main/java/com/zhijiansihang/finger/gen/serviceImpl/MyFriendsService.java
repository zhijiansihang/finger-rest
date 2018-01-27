package com.zhijiansihang.finger.gen.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.zhijiansihang.finger.app.dao.mysql.mapper.UserFriendDAO;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserInstitutionDetailDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.CmsDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import com.zhijiansihang.finger.app.sharing.SharingProperties;
import com.zhijiansihang.finger.app.tool.Page;
import com.zhijiansihang.finger.app.vo.CmsVO;
import com.zhijiansihang.finger.gen.tool.CheckTools;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.MyFriendsRequest;
import com.zhijiansihang.finger.gen.entity.MyFriendsResponse;
import com.zhijiansihang.finger.gen.entity.MyFriendsResponse.FriendListElement;

import org.hibernate.annotations.Check;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * 我的好友
 */
@Component("myFriendsService")
public class MyFriendsService implements MessageService<MyFriendsRequest, Response<MyFriendsResponse>> {

    private static final Logger LOG = LoggerFactory.getLogger(MyFriendsService.class);
    private static final String SERVICE_DESC = "我的好友";

    @Autowired
    SharingProperties sharingProperties;
    @Autowired
    UserFriendDAO userFriendDAO;

    @Override
    public void execute(MyFriendsRequest request, Response<MyFriendsResponse> response) {
        LOG.info("[{}][request={}]", SERVICE_DESC, request);
        Long id = UserTools.getLoginUser().getId();
        Page<Long, UserDO> page = Page.create();
        page.setCurrentPage(CheckTools.isInteger(request.getCurrentPage()) ? Integer.parseInt(request.getCurrentPage()) : 1);
        page.setCurrentPage(CheckTools.isInteger(request.getPageSize()) ? Integer.parseInt(request.getPageSize()) : 10);
        page.setSelect(id.longValue());
        int count = userFriendDAO.countByUserid(id);
        page.setRecordCount(count);

        if (count > 0) {
            List<UserDO> cmsDOS = userFriendDAO.selectByUseridPage(id, page.getRowBounds());
            response.getBody().setFriendList(getFriendList(cmsDOS));
        }else {
            response.getBody().setFriendList(new ArrayList<>());
        }
        response.getBody().setCurrentPage(page.getCurrentPage() + "");
        response.getBody().setPageCount(page.getPageCount() + "");
        response.getBody().setPageSize(page.getPageSize() + "");
        response.getBody().setRecordCount(page.getRecordCount() + "");


    }

    private List<FriendListElement> getFriendList(List<UserDO> cmsDOS) {

        List<FriendListElement> elems = new ArrayList<FriendListElement>();
        if (cmsDOS == null) {
            return elems;
        }
        for (UserDO userDO : cmsDOS) {
            FriendListElement elem = new FriendListElement();
            elems.add(elem);
            elem.setFriendUserId(userDO.getUserId().toString());
            if (userDO.getLogo() !=null && userDO.getLogo().trim().length()>0){
                elem.setLogo(sharingProperties.getStaticServerLink()+userDO.getLogo());
            }else {
                elem.setLogo("");
            }
            elem.setRealName(userDO.getRealName());
        }

        return elems;
    }
}
