package com.zhijiansihang.finger.app.service;


import com.google.common.collect.Lists;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.app.dao.mysql.mapper.LoanInvestorFinanceDAO;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.*;
import com.zhijiansihang.finger.app.vo.LoanInvestorFinanceVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanInvestorFinanceService {
    private static Logger logger = LoggerFactory.getLogger(LoanInvestorFinanceService.class);

    @Autowired
    private LoanInvestorFinanceDAO loanInvestorFinanceDAO;

    @Autowired
    private UserDAO userDAO;
    /**
     * 标的预约详情
     *
     * @param loanId
     * @return
     */
    public Response findLoanInvestorFinanceByLoanId(Long loanId) {
        logger.info("标的预约详情");
        LoanInvestorFinanceDOExample example = new LoanInvestorFinanceDOExample();
        LoanInvestorFinanceDOExample.Criteria criteria = example.createCriteria();
        criteria.andLoanIdEqualTo(loanId);
        List<LoanInvestorFinanceVO> loanInvestorFinanceVOS = Lists.newArrayList();
        loanInvestorFinanceDAO.selectByExample(example).forEach( loanInvestorFinanceDO ->{
            LoanInvestorFinanceVO loanInvestorFinanceVO = new LoanInvestorFinanceVO();
            BeanUtils.copyProperties(loanInvestorFinanceDO, loanInvestorFinanceVO);
            UserDO userDO =  userDAO.selectByPrimaryKey(loanInvestorFinanceDO.getFinanceUserId());
            if (userDO != null){
                loanInvestorFinanceVO.setFinanceUserName(userDO.getNickName());
            }
            loanInvestorFinanceVOS.add(loanInvestorFinanceVO);
        } );
        return Response.success(loanInvestorFinanceVOS);
    }


}
