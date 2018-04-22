package com.zhijiansihang.finger.app.sharing;

import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDAO;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDemandDAO;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDemandSolutionDAO;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserSolutionDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDemandDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDemandSolutionDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserSolutionDO;
import com.zhijiansihang.finger.app.sharing.lock.redis.RedisLock;
import com.zhijiansihang.finger.app.sharing.spring.ApplicationContextHelper;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.zhijiansihang.finger.app.constant.UserConsts.USER_LOCK_RISK_INIT_PREFIX;

/**
 * @author paul
 * @description
 * @date 2018/1/2
 */
@Component
public class Quartz {
    private static final Logger logger = LoggerFactory.getLogger(Quartz.class);

    @Autowired
    UserDemandDAO userDemandDAO;
    @Autowired
    UserSolutionDAO userSolutionDAO;
    @Autowired
    RedisLock redisLock;

    @Autowired
    UserDAO userDAO;

    public void batchUserDemandSolution(){
        String px = "跑批需求方案匹配";
        logger.debug("==========>开始!");
        boolean batch_lock_demo = redisLock.tryLock("lock_batchUserDemandSolution", 12, TimeUnit.SECONDS,10,TimeUnit.MINUTES);
        if (!batch_lock_demo){
            logger.info(px+"==========>跑批获取batch_lock_demo失败,结束该次跑批!");
            return;
        }
        try {
            long user_solution_max = userSolutionDAO.getMaxId();
            if (user_solution_max == 0){
                logger.info(px+"==========>user_solution_max=0,结束该次跑批!");
                return;
            }
            long user_demand_max = userDemandDAO.getMaxId();
            if (user_demand_max==0){
                logger.info(px+"==========>user_demand_max=0,结束该次跑批!");
                return;
            }
            int i = 1;
            while (true){
                List<UserDemandDO> userDemandDOListPage =  userDemandDAO.getLowLastBatchid(user_solution_max, new RowBounds(0,100));
                if (userDemandDOListPage == null || userDemandDOListPage.size() == 0){
                    logger.info(px+"==========>批次【{}】userDemandDOListPage数量为0",i);
                    break;
                }
                logger.info(px+"==========>批次【{}】userDemandDOListPage数量为{}",i,userDemandDOListPage.size());
                for (UserDemandDO userDemandDO:userDemandDOListPage){
                    UserSolutionDO userSolutionDO = new UserSolutionDO();
                    userSolutionDO.setMoneySituation(userDemandDO.getMoneySituation());
                    userSolutionDO.setEarningType(userDemandDO.getEarningType());
                    userSolutionDO.setRiskAssessmentLevel(userDemandDO.getRiskAssessmentLevel());
                    userSolutionDO.setExpectedDeadline(userDemandDO.getExpectedDeadline());
                    List<UserSolutionDO> matchUserSolutionDOS = userSolutionDAO.selectMatch(userSolutionDO);
                    if (matchUserSolutionDOS == null || matchUserSolutionDOS.size() == 0){
                        userDemandDAO.updateLastBatchid(userDemandDO.getId(),user_solution_max);
                        continue;
                    }else {
                        String redisKey = USER_LOCK_RISK_INIT_PREFIX + userDemandDO.getUserId();
                        boolean tryLock = redisLock.tryLock(redisKey,50, TimeUnit.SECONDS);
                        if (tryLock) {
                            try {
                                ApplicationContextHelper.getBean(Quartz.class).userDemandMatchSolutionInsert(userDemandDO, matchUserSolutionDOS, user_solution_max);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }else {
                            logger.info(px+"==========>批次【{}】userDemand id={}获取锁失败，登录下一个批次处理",i,userDemandDO.getId());
                        }
                    }
                }
                i++;
            }
        }finally {
            redisLock.unLock("lock_batchUserDemandSolution");
        }
        logger.debug("==========>跑批测试结束!");
    }

    @Autowired
    UserDemandSolutionDAO userDemandSolutionDAO;
    @Transactional
    public void userDemandMatchSolutionInsert(UserDemandDO userDemandDO,List<UserSolutionDO> matchUserSolutionDOS,Long userSolutionMax){
        int i = userDemandDAO.updateLastBatchid(userDemandDO.getId(), userSolutionMax);

        if (i!=1){
            throw new RuntimeException("更新失败!");
        }
        int i1 = userDemandDAO.addMatchSolutionCount(userDemandDO.getId(), matchUserSolutionDOS.size());
        if (i1!=1){
            throw new RuntimeException("更新失败!");
        }
        for (UserSolutionDO   userSolutionDO:matchUserSolutionDOS){
            UserDemandSolutionDO record = new UserDemandSolutionDO();
            record.setDemandId(userDemandDO.getId());
            record.setDemandUserId(userDemandDO.getUserId());
            record.setSolutionId(userSolutionDO.getId());
            record.setSolutionUserId(userSolutionDO.getUserId());
            userDemandSolutionDAO.insertSelective(record);
            userSolutionDAO.addMatchDemandCount(userSolutionDO.getId());
        }
    }
}
