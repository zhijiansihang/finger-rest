package com.zhijiansihang.finger.app.controller;

import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.app.service.LoanInvestorFinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan/investor")
public class LoanInvestorFinanceController {

    @Autowired
    private LoanInvestorFinanceService loanInvestorFinanceService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public Response page(Long loanId) {
        return loanInvestorFinanceService.findLoanInvestorFinanceByLoanId(loanId);
    }


}
