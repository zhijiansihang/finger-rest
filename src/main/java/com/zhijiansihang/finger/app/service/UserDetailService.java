package com.zhijiansihang.finger.app.service;


import com.zhijiansihang.finger.app.constant.CmsConsts;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDAO;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserFinanceDetailDAO;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserFriendCountDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDOExample;
import com.zhijiansihang.finger.app.dao.mysql.model.UserFinanceDetailDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserFriendCountDO;
import com.zhijiansihang.finger.app.event.demo.RiskAssessmentModifyEvent;
import com.zhijiansihang.finger.app.event.demo.UserRegisterEvent;
import com.zhijiansihang.finger.app.sharing.spring.ApplicationContextHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserDetailService {
    private static Logger logger = LoggerFactory.getLogger(UserDetailService.class);
    @Autowired
    UserDAO userDAO;

    @Autowired
    UserFinanceDetailDAO userFinanceDetailDAO;

    @Autowired
    UserFriendCountDAO userFriendCountDAO;

    /**
     * 通过手机号拿用户
     * @param mobile
     * @return null 为不存在
     */
    public UserDO getUserByMobile(String mobile) {
        UserDOExample example = new UserDOExample();
        UserDOExample.Criteria criteria = example.createCriteria();
        criteria.andMobileEqualTo(mobile);
        List<UserDO> userDOS = userDAO.selectByExample(example);

        if (userDOS != null && userDOS.size() > 0) {
            return userDOS.get(0);
        }
        return null;
    }
    @Transactional
    public UserDO register(String mobile,Short source){
        UserDO userDO = new UserDO();
        userDO.setMobile(mobile);
        userDO.setRoles((short)2);
        userDO.setPasswd("nopasswd");
        userDO.setSource(source);
        int userId = userDAO.insertSelective(userDO);

        UserFinanceDetailDO userFinanceDetailDO = new UserFinanceDetailDO();
        userFinanceDetailDO.setUserId((long)userId);
        userFinanceDetailDAO.insertSelective(userFinanceDetailDO);

        UserFriendCountDO userFriendCountDO = new UserFriendCountDO();
        userFriendCountDO.setUserId((long)userId);
        userFriendCountDO.setFriendCounts(0L);
        userFriendCountDAO.insertSelective(userFriendCountDO);
        UserDO userByMobile = getUserByMobile(mobile);

        UserRegisterEvent userRegisterEvent = new UserRegisterEvent(this);
        userRegisterEvent.setUserDO(userByMobile);
        ApplicationContextHelper.applicationContext.publishEvent(userRegisterEvent);
        return userByMobile;
    }

    @Transactional
    public boolean updateRiskAssessment(Long userId, CmsConsts.RiskAssessmentEnum riskAssessmentEnum){
        UserDO userDO = userDAO.selectByPrimaryKey(userId);
        if (userDO == null){
            return false;
        }
        Short riskAssessmentLevel = userDO.getRiskAssessmentLevel();
        if (riskAssessmentLevel != null || riskAssessmentEnum.getRole().intValue() == riskAssessmentLevel.intValue()){
            return true;
        }
        UserDO updateUser = new UserDO();
        updateUser.setUserId(userId);
        updateUser.setRiskAssessmentLevel(riskAssessmentEnum.getRole().shortValue());
        int i = userDAO.updateByPrimaryKeySelective(updateUser);
        if (i != 1){
            throw new IllegalArgumentException();
        }

        RiskAssessmentModifyEvent event = new RiskAssessmentModifyEvent(this);
        event.setUserId(userId);
        ApplicationContextHelper.applicationContext.publishEvent(event);
        return true;
    }
}
