package com.zhijiansihang.finger.app.event.demo;

import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDAO;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDemandDAO;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDemandSolutionDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import com.zhijiansihang.finger.app.sharing.lock.redis.RedisLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import static com.zhijiansihang.finger.app.constant.UserConsts.USER_LOCK_RISK_INIT_PREFIX;
import static com.zhijiansihang.finger.app.sharing.SharingSpringConfig.ASYNC_LISTENER;


/**
 *
 * @author: Paul Zhang
 * @date: 16:21 2017/12/27
 */
@Component
@Async(ASYNC_LISTENER)
public class RiskAssessmentModifyListener implements ApplicationListener<RiskAssessmentModifyEvent> {
    private static final Logger logger = LoggerFactory.getLogger(RiskAssessmentModifyListener.class);
    @Autowired
    UserDAO userDAO;

    @Autowired
    UserDemandDAO userDemandDAO;

    @Autowired
    UserDemandSolutionDAO userDemandSolutionDAO;

    @Autowired
    RedisLock redisLock;
    @Override
    public void onApplicationEvent(RiskAssessmentModifyEvent demoEvent) {
        logger.info("用户等级发生变化接收注册到消息:{}",demoEvent.getUserId());

        UserDO userDO = userDAO.selectByPrimaryKey(demoEvent.getUserId());
        if (userDO == null || userDO.getRiskAssessmentLevel() == null){
            return;
        }
        String redisKey = USER_LOCK_RISK_INIT_PREFIX + demoEvent.getUserId();
        boolean tryLock = redisLock.tryLock(redisKey,100, TimeUnit.SECONDS);
        if (tryLock) {
            try {
                userDemandDAO.updateAgainRishBatchByUserid(demoEvent.getUserId());
                userDemandSolutionDAO.deleteByUserid(demoEvent.getUserId());
            } finally {
                redisLock.unLock(redisKey);
            }
        }
    }
}
