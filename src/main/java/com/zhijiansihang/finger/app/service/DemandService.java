package com.zhijiansihang.finger.app.service;


import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDemandDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDemandDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDemandDOExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandService {
    private static Logger logger = LoggerFactory.getLogger(DemandService.class);

    @Autowired
    private UserDemandDAO userDemandDAO;

    public List<UserDemandDO> findByUserId(Long userId) {
        logger.info("用户需求 列表");
        UserDemandDOExample example = new UserDemandDOExample();
        example.createCriteria().andUserIdEqualTo(userId);
        return  userDemandDAO.selectByExample(example);
    }
}
