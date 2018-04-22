package com.zhijiansihang.finger.gen.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.zhijiansihang.finger.app.dao.mysql.mapper.UserCollectionDAO;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserFinanceDetailDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import com.zhijiansihang.finger.app.sharing.SharingProperties;
import com.zhijiansihang.finger.app.tool.Page;
import com.zhijiansihang.finger.app.vo.UserFinanceDetailVO;
import com.zhijiansihang.finger.gen.entity.MyFriendsResponse;
import com.zhijiansihang.finger.gen.tool.CheckTools;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.MyCollectionPersonRequest;
import com.zhijiansihang.finger.gen.entity.MyCollectionPersonResponse;
import com.zhijiansihang.finger.gen.entity.MyCollectionPersonResponse.FinanceListElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 我的收藏-店铺
 */
@Component("myCollectionPersonService")
public class MyCollectionPersonService implements MessageService<MyCollectionPersonRequest, Response<MyCollectionPersonResponse>> {

    private static final Logger LOG = LoggerFactory.getLogger(MyCollectionPersonService.class);
    private static final String SERVICE_DESC = "我的收藏-店铺";

    @Autowired
    UserFinanceDetailDAO userFinanceDetailDAO;
    @Autowired
    UserCollectionDAO userCollectionDAO;

    @Autowired
    SharingProperties sharingProperties;

    @Override
    public void execute(MyCollectionPersonRequest request, Response<MyCollectionPersonResponse> response) {
        LOG.info("[{}][request={}]", SERVICE_DESC, request);

        Long userId = UserTools.getLoginUser().getId();
        Page<Long, UserDO> page = Page.create();
        page.setCurrentPage(CheckTools.isInteger(request.getCurrentPage()) ? Integer.parseInt(request.getCurrentPage()) : 1);
        page.setPageSize(CheckTools.isInteger(request.getPageSize()) ? Integer.parseInt(request.getPageSize()) : 10);
        page.setSelect(userId.longValue());
        int count = userCollectionDAO.countFinanceByUserid(userId);
        page.setRecordCount(count);

        if (count > 0) {
            List<UserFinanceDetailVO> cmsDOS = userFinanceDetailDAO.selectCollectionPage(userId, page.getRowBounds());
            response.getBody().setFinanceList(getFinanceList(cmsDOS));
        } else {
            response.getBody().setFinanceList(new ArrayList<>());
        }
        response.getBody().setCurrentPage(page.getCurrentPage() + "");
        response.getBody().setPageCount(page.getPageCount() + "");
        response.getBody().setPageSize(page.getPageSize() + "");
        response.getBody().setRecordCount(page.getRecordCount() + "");
    }

    private List<FinanceListElement> getFinanceList(List<UserFinanceDetailVO> cmsDOS) {
        List<FinanceListElement> elems = new ArrayList<FinanceListElement>();
        if (cmsDOS == null) {
            return elems;
        }
        for (UserFinanceDetailVO userFinanceDetailVO : cmsDOS) {
            FinanceListElement elem = new FinanceListElement();
            elems.add(elem);
            elem.setPosition(userFinanceDetailVO.getPosition() == null?"":userFinanceDetailVO.getPosition());
            elem.setAdoptCount(userFinanceDetailVO.getAdoptCount() == null ? "0" : userFinanceDetailVO.getAdoptCount().toString());
            elem.setInstitutionName(CheckTools.nullToEmptyString(userFinanceDetailVO.getInstitutionName()));
            elem.setServiceDirection(CheckTools.nullToEmptyString(userFinanceDetailVO.getServiceDirection()));
            elem.setFinanceUserId(userFinanceDetailVO.getUserId().toString());
            elem.setIsNameAuth("已认证");
            elem.setLoanCount(userFinanceDetailVO.getLoanCount() == null ? "0" : userFinanceDetailVO.getLoanCount().toString());
            if (userFinanceDetailVO.getLogo() != null && userFinanceDetailVO.getLogo().trim().length() > 0) {
                elem.setLogo(sharingProperties.getStaticServerLink() + userFinanceDetailVO.getLogo());
            } else {
                elem.setLogo("");
            }
            elem.setRealName(CheckTools.nullToEmptyString(userFinanceDetailVO.getNickName()));
            elem.setUserOrderCount(userFinanceDetailVO.getUserOrderCount() == null ? "0" : userFinanceDetailVO.getUserOrderCount().toString());
        }
        return elems;
    }
}
