package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.common.ResponseHeader;
import com.zhijiansihang.common.ResponseHeaderBuilder;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserSolutionDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDemandDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserSolutionDO;
import com.zhijiansihang.finger.app.sharing.lock.redis.RedisLock;
import com.zhijiansihang.finger.gen.tool.CheckTools;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.CreateMySolutionRequest;
import com.zhijiansihang.finger.gen.entity.CreateMySolutionResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.zhijiansihang.common.RetCode.NEEDUPDATE;

/**
 * 发布我的方案
 */
@Component("createMySolutionService")
public class CreateMySolutionService implements MessageService<CreateMySolutionRequest, Response<CreateMySolutionResponse>> {

    private static final Logger LOG = LoggerFactory.getLogger(CreateMySolutionService.class);
    private static final String SERVICE_DESC = "发布我的方案";

    @Autowired
    RedisLock redisLock;

    @Autowired
    UserSolutionDAO userSolutionDAO;

    @Override
    public void execute(CreateMySolutionRequest request, Response<CreateMySolutionResponse> response) {
        LOG.info("[{}][request={}]", SERVICE_DESC, request);

        long userId = UserTools.getLoginUser().getId();
        if (!CheckTools.isInteger(request.getEarningType()) ||
                !CheckTools.isInteger(request.getMoneySituation()) ||
                !CheckTools.isInteger(request.getExpectedDeadline()) ||
                !CheckTools.isInteger(request.getRiskAssessmentLevel()) ||
                CheckTools.stringEmptyString(request.getSolution())
                ) {
            ResponseHeader responseHeader = ResponseHeaderBuilder.buildValidateError("参数不能为空");
            response.setHeader(responseHeader);
            return;
        }

        UserSolutionDO userSolutionDO = new UserSolutionDO();
        userSolutionDO.setUserId(userId);
        userSolutionDO.setMoneySituation(Short.parseShort(request.getMoneySituation()));
        userSolutionDO.setEarningType(Short.parseShort(request.getEarningType()));
        userSolutionDO.setExpectedDeadline(Short.parseShort(request.getExpectedDeadline()));
        userSolutionDO.setSolution(request.getSolution().trim());
        userSolutionDO.setRiskAssessmentLevel(Short.parseShort(request.getRiskAssessmentLevel()));
        String redisKey = this.getClass().getName() + "_" + userId;
        boolean tryLock = redisLock.tryLock(redisKey);
        if (tryLock) {
            try {
                int count = userSolutionDAO.existSameType(userSolutionDO);
                if (count > 0) {
                    ResponseHeader responseHeader = ResponseHeaderBuilder.build(NEEDUPDATE, NEEDUPDATE.getMessage());
                    response.setHeader(responseHeader);
                    List<UserSolutionDO> sameTypeList = userSolutionDAO.getSameTypeList(userSolutionDO);
                    if (sameTypeList !=null && sameTypeList.size() > 0){
                        response.getBody().setSolutionId(sameTypeList.get(0).getId().toString());
                    }
                    return;
                }
                int max = userSolutionDAO.getMaxSerialNumber(userId);
                userSolutionDO.setSerialNumber((long) (max + 1));
                int insertSelective = userSolutionDAO.insertSelective(userSolutionDO);
                response.getBody().setSolutionId(insertSelective + "");
            } finally {
                redisLock.unLock(redisKey);
            }
        } else {
            response.setHeader(ResponseHeaderBuilder.buildTimeout());
        }
    }
}
