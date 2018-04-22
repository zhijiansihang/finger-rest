package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import com.zhijiansihang.finger.gen.entity.IsRegisterJgRequest;
import com.zhijiansihang.finger.gen.entity.IsRegisterJgResponse;
import com.zhijiansihang.finger.mmc.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 是否注册极光
 */
@Component("isRegisterJgService")
public class IsRegisterJgService implements MessageService<IsRegisterJgRequest, Response<IsRegisterJgResponse>> {

    private static final Logger LOG = LoggerFactory.getLogger(IsRegisterJgService.class);
    private static final String SERVICE_DESC = "是否注册极光";


    @Autowired
    UserDAO userDAO;

    @Override
    public void execute(IsRegisterJgRequest request, Response<IsRegisterJgResponse> response) {
        LOG.info("[{}][request={}]", SERVICE_DESC, request);

        String userId = request.getUserId();

        UserDO userDO = userDAO.selectByPrimaryKey(Long.parseLong(userId));
        if (userDO != null && userDO.getIsRegisterJg() != null && userDO.getIsRegisterJg().intValue() == 1) {
            response.getBody().setResult("1");
        } else {
            response.getBody().setResult("0");
        }
    }
}
