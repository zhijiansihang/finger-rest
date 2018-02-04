package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.common.Response;
import com.zhijiansihang.common.ResponseHeader;
import com.zhijiansihang.common.ResponseHeaderBuilder;
import com.zhijiansihang.common.RetCode;
import com.zhijiansihang.finger.app.dao.mysql.mapper.*;
import com.zhijiansihang.finger.app.dao.mysql.model.*;
import com.zhijiansihang.finger.app.service.LoanInvestService;
import com.zhijiansihang.finger.app.sharing.lock.redis.RedisLock;
import com.zhijiansihang.finger.gen.entity.InvestRequest;
import com.zhijiansihang.finger.gen.entity.InvestResponse;
import com.zhijiansihang.finger.gen.tool.CheckTools;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.gateway.security.core.JwtUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 预约
 */
@Component("investService")
public class InvestService implements MessageService<InvestRequest, Response<InvestResponse>> {

    private static final Logger LOG = LoggerFactory.getLogger(InvestService.class);
    private static final String SERVICE_DESC = "预约";
    @Autowired
    LoanInvestorFinanceDAO loanInvestorFinanceDAO;

    @Autowired
    LoanDAO loanDAO;
    @Autowired
    UserFinanceDetailDAO userFinanceDetailDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    LoanInvestService loanInvestService;

    @Autowired
    RedisLock redisLock;

    @Autowired
    UserServiceRecordDAO userServiceRecordDAO;


    @Override
    public void execute(InvestRequest request, Response<InvestResponse> response) {
        LOG.info("[{}][request={}]", SERVICE_DESC, request);

        Long loginUserid = UserTools.getLoginUser().getId();
        String financeUserId = request.getFinanceUserId();
        String loanId = request.getLoanId();
        String realName = request.getRealName();
        String amount = request.getAmount();

        if (!CheckTools.isInteger(amount) || new BigDecimal(amount).compareTo(BigDecimal.ZERO) < 1){
            ResponseHeader responseHeader = ResponseHeaderBuilder.buildValidateError("金额不正确");
            response.setHeader(responseHeader);
            return;
        }
        LoanDO loanDO = loanDAO.selectByPrimaryKey(Long.parseLong(loanId));
        if (loanDO == null){
            ResponseHeader responseHeader = ResponseHeaderBuilder.buildValidateError("标的不存在");
            response.setHeader(responseHeader);
            return;
        }
        UserFinanceDetailDO userFinanceDetailDO = userFinanceDetailDAO.selectByPrimaryKey(Long.parseLong(financeUserId));
        if (userFinanceDetailDO == null){
            ResponseHeader responseHeader = ResponseHeaderBuilder.buildValidateError("理财师不存在");
            response.setHeader(responseHeader);
            return;
        }
        UserDO userDO = userDAO.selectByPrimaryKey(loginUserid);
        if (userDO.getRealName() == null || userDO.getRealName().trim().length() == 0 ||
                realName == null || realName.trim().length() == 0 ){
            ResponseHeader responseHeader = ResponseHeaderBuilder.buildValidateError("姓名不能为空");
            response.setHeader(responseHeader);
            return;
        }
        if (new BigDecimal(amount).compareTo(loanDO.getAmount().divide(BigDecimal.valueOf(2L))) == 1){
            ResponseHeader responseHeader = ResponseHeaderBuilder.buildValidateError("预约金额不可超过募集金额的50%");
            response.setHeader(responseHeader);
            return;
        }

        LoanInvestorFinanceDO loanInvestorFinanceDO = new LoanInvestorFinanceDO();
        loanInvestorFinanceDO.setLoanId(Long.parseLong(loanId));
        loanInvestorFinanceDO.setUserId(loginUserid);

        String redisKey = this.getClass().getName() + "_"+loanId + "_"+loginUserid;
        boolean tryLock = redisLock.tryLock(redisKey);
        if (tryLock){
            try {
                int count = loanInvestorFinanceDAO.countBuy(loanInvestorFinanceDO);
                if (count > 0 ){
                    ResponseHeader responseHeader = ResponseHeaderBuilder.buildValidateError("每位投资人一个产品只能预约一次");
                    response.setHeader(responseHeader);
                    return;
                }
                String userDORealName = userDO.getRealName();
                if (userDORealName == null || userDORealName.length() == 0 ){
                    loanInvestorFinanceDO.setRealName(realName);
                }else {
                    loanInvestorFinanceDO.setRealName(userDO.getRealName());
                }
                loanInvestorFinanceDO.setMobile(userDO.getMobile());
                loanInvestorFinanceDO.setAmount(new BigDecimal(amount));
                loanInvestorFinanceDO.setFinanceUserId(Long.parseLong(financeUserId));
                boolean invest = loanInvestService.invest(loanInvestorFinanceDO);
                if (!invest){
                    ResponseHeader responseHeader = ResponseHeaderBuilder.build(RetCode.INTERNALEXCEP,"请稍后重试");
                    response.setHeader(responseHeader);
                    return;
                }else {
                    UserServiceRecordDO userServiceRecordDO = new UserServiceRecordDO();
                    userServiceRecordDO.setUserId(Long.parseLong(financeUserId));
                    userServiceRecordDO.setPersonUserId(loginUserid);
                    userServiceRecordDO.setCreateTime(new Date());
                    userServiceRecordDO.setServiceType((byte) 0);
                    userServiceRecordDAO.insertSelective(userServiceRecordDO);

                    userFinanceDetailDAO.addUserOrderCount(Long.parseLong(financeUserId));
                }
            }finally {
                redisLock.unLock(redisKey);
            }
        }else {
            response.setHeader(ResponseHeaderBuilder.buildTimeout());
        }
    }
}
