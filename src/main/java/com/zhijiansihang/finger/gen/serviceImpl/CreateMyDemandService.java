package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.common.ResponseHeader;
import com.zhijiansihang.common.ResponseHeaderBuilder;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDemandDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDemandDO;
import com.zhijiansihang.finger.app.sharing.lock.redis.RedisLock;
import com.zhijiansihang.finger.gen.tool.CheckTools;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.CreateMyDemandRequest;
import com.zhijiansihang.finger.gen.entity.CreateMyDemandResponse;

import com.zhijiansihang.gateway.security.core.JwtUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.zhijiansihang.common.RetCode.NEEDUPDATE;

/**
 * 发布我的需求
 */
@Component("createMyDemandService")
public class CreateMyDemandService implements MessageService<CreateMyDemandRequest, Response<CreateMyDemandResponse>> {

    private static final Logger LOG = LoggerFactory.getLogger(CreateMyDemandService.class);
    private static final String SERVICE_DESC = "发布我的需求";

    @Autowired
    UserDemandDAO userDemandDAO;
    @Autowired
    RedisLock redisLock;
    @Override
    public void execute(CreateMyDemandRequest request, Response<CreateMyDemandResponse> response) {
        LOG.info("[{}][request={}]", SERVICE_DESC, request);
        long userId = UserTools.getLoginUser().getId();
        if (!CheckTools.isInteger(request.getEarningType()) ||
                !CheckTools.isInteger(request.getMoneySituation()) ||
                !CheckTools.isInteger(request.getExpectedDeadline()) ||
                CheckTools.stringEmptyString(request.getAdditionalRemarks())
                ){
            ResponseHeader responseHeader = ResponseHeaderBuilder.buildValidateError("参数不能为空");
            response.setHeader(responseHeader);
            return;
        }
        UserDemandDO userDemandDO = new UserDemandDO();
        userDemandDO.setUserId(userId);
        userDemandDO.setMoneySituation(Short.parseShort(request.getMoneySituation()));
        userDemandDO.setEarningType(Short.parseShort(request.getEarningType()));
        userDemandDO.setExpectedDeadline(Short.parseShort(request.getExpectedDeadline()));
        userDemandDO.setAdditionalRemarks(request.getAdditionalRemarks().trim());

        String redisKey = this.getClass().getName() + "_" + userId;
        boolean tryLock = redisLock.tryLock(redisKey);
        if (tryLock){
            try {
                int count = userDemandDAO.existSameType(userDemandDO);
                if (count>0){
                    ResponseHeader responseHeader = ResponseHeaderBuilder.build(NEEDUPDATE,NEEDUPDATE.getMessage());
                    response.setHeader(responseHeader);

                    List<UserDemandDO> sameTypeList = userDemandDAO.getSameTypeList(userDemandDO);
                    if (sameTypeList !=null && sameTypeList.size() > 0){
                        response.getBody().setDemandId(sameTypeList.get(0).getId().toString());
                    }
                    return;
                }
                int max = userDemandDAO.getMaxSerialNumber(userId);
                userDemandDO.setSerialNumber((long) (max+1));
                int insertSelective = userDemandDAO.insertSelective(userDemandDO);
                response.getBody().setDemandId(insertSelective+"");
            }finally {
                redisLock.unLock(redisKey);
            }
        }else {
            response.setHeader(ResponseHeaderBuilder.buildTimeout());
        }
    }
}
