package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.common.ResponseHeader;
import com.zhijiansihang.common.ResponseHeaderBuilder;
import com.zhijiansihang.finger.app.constant.UserConsts;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDAO;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserFinanceDetailDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserFinanceDetailDO;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.MyFinanceDetailRequest;
import com.zhijiansihang.finger.gen.entity.MyFinanceDetailResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.zhijiansihang.common.RetCode.NOPERMISSION;

/**
 * 我的资料
 */
@Component("myFinanceDetailService")
public class MyFinanceDetailService implements MessageService<MyFinanceDetailRequest, Response<MyFinanceDetailResponse>> {

    private static final Logger LOG = LoggerFactory.getLogger(MyFinanceDetailService.class);
    private static final String SERVICE_DESC = "我的资料";

    @Autowired
    UserFinanceDetailDAO userFinanceDetailDAO;
    @Autowired
    UserDAO userDAO;

    @Override
    public void execute(MyFinanceDetailRequest request, Response<MyFinanceDetailResponse> response) {
        LOG.info("[{}][request={}]", SERVICE_DESC, request);

        Long userId = UserTools.getLoginUser().getId();
        UserDO userDO = userDAO.selectByPrimaryKey(userId);
        Short roles = userDO.getRoles();
        if (!UserConsts.UserRolesEnum.FINANCE.name().equals(UserConsts.getUserRoles(roles.intValue()))) {
            ResponseHeader responseHeader = ResponseHeaderBuilder.build(NOPERMISSION, "只允许理财师可以操作");
            response.setHeader(responseHeader);
            return;
        }
        UserFinanceDetailDO userFinanceDetailDO = userFinanceDetailDAO.selectByPrimaryKey(userId);
        response.getBody().setEducationLevel(userFinanceDetailDO.getEducationLevel());
        response.getBody().setIsAdd(userFinanceDetailDO.getIsAdd() != null ? userFinanceDetailDO.getIsAdd().toString() : "0");
        response.getBody().setPersonalProfile(userFinanceDetailDO.getPersonalProfile());
        response.getBody().setPosition(userFinanceDetailDO.getPosition());
        response.getBody().setSchoolName(userFinanceDetailDO.getSchoolName());
        response.getBody().setServiceConcept(userFinanceDetailDO.getServiceConcept());
        response.getBody().setServiceDirection(userFinanceDetailDO.getServiceDirection());
        response.getBody().setWorkAge(userFinanceDetailDO.getWorkAge() == null ? "" : userFinanceDetailDO.getWorkAge().toString());
        response.getBody().setWorkingExperience(userFinanceDetailDO.getWorkingExperience());
    }
}
