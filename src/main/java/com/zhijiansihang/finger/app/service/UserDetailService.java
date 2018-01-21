package com.zhijiansihang.finger.app.service;


import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDAO;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserFinanceDetailDAO;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserFriendCountDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDOExample;
import com.zhijiansihang.finger.app.dao.mysql.model.UserFinanceDetailDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserFriendCountDO;
import com.zhijiansihang.finger.app.event.demo.UserRegisterEvent;
import com.zhijiansihang.finger.app.event.demo.UserRegisterListener;
import com.zhijiansihang.finger.app.sharing.spring.ApplicationContextHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

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

        if (userDOS != null || userDOS.size() > 0) {
            return userDOS.get(0);
        }
        return null;
    }
    @Transactional
    public UserDO register(String mobile){
        UserDO userDO = new UserDO();
        userDO.setMobile(mobile);
        userDO.setRoles((short)2);
        userDO.setPasswd("nopasswd");
        int userId = userDAO.insertSelective(userDO);

        UserFinanceDetailDO userFinanceDetailDO = new UserFinanceDetailDO();
        userFinanceDetailDO.setUserId((long)userId);
        userFinanceDetailDAO.insertSelective(userFinanceDetailDO);

        UserFriendCountDO userFriendCountDO = new UserFriendCountDO();
        userFriendCountDO.setUserId((long)userId);
        userFriendCountDAO.insertSelective(userFriendCountDO);
        UserDO userByMobile = getUserByMobile(mobile);

        UserRegisterEvent userRegisterEvent = new UserRegisterEvent(this);
        userRegisterEvent.setUserDO(userByMobile);
        ApplicationContextHelper.applicationContext.publishEvent(userRegisterEvent);
        return userByMobile;
    }
}
