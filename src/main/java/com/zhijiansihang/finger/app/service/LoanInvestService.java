package com.zhijiansihang.finger.app.service;


import com.zhijiansihang.finger.app.dao.mysql.mapper.*;
import com.zhijiansihang.finger.app.dao.mysql.model.*;
import com.zhijiansihang.finger.app.event.demo.UserRegisterEvent;
import com.zhijiansihang.finger.app.sharing.spring.ApplicationContextHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LoanInvestService {
    private static Logger logger = LoggerFactory.getLogger(LoanInvestService.class);

    @Autowired
    LoanInvestorFinanceDAO loanInvestorFinanceDAO;

    @Autowired
    LoanDAO loanDAO;
    @Transactional
    public boolean invest(LoanInvestorFinanceDO loanInvestorFinanceDO){
        int i = loanInvestorFinanceDAO.insertSelective(loanInvestorFinanceDO);
        if (i==0){
            return false;
        }
        loanDAO.invest(loanInvestorFinanceDO);
        return true;
    }
}
