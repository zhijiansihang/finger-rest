package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.common.ResponseHeader;
import com.zhijiansihang.common.ResponseHeaderBuilder;
import com.zhijiansihang.common.RetCode;
import com.zhijiansihang.finger.app.dao.mysql.mapper.LoanInvestorFinanceDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.LoanInvestorFinanceDO;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.FinanceOperateLoanInvestorRequest;
import com.zhijiansihang.finger.gen.entity.FinanceOperateLoanInvestorResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

import static com.zhijiansihang.common.RetCode.UPDATEERROR;

/**
 * 理财师操作预约记录
 * 
 */
@Component("financeOperateLoanInvestorService")
public class FinanceOperateLoanInvestorService implements MessageService<FinanceOperateLoanInvestorRequest, Response<FinanceOperateLoanInvestorResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(FinanceOperateLoanInvestorService.class);
	private static final String SERVICE_DESC = "理财师操作预约记录";

	@Autowired
	LoanInvestorFinanceDAO loanInvestorFinanceDAO;
	@Override
	public void execute(FinanceOperateLoanInvestorRequest request, Response<FinanceOperateLoanInvestorResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		Long userId = UserTools.getLoginUser().getId();
		String id = request.getId();
		LoanInvestorFinanceDO loanInvestorFinanceDO = new LoanInvestorFinanceDO();
		loanInvestorFinanceDO.setFinanceUserId(userId);
		loanInvestorFinanceDO.setId(Long.parseLong(id));
		loanInvestorFinanceDO.setIsDeal((byte)1);
		loanInvestorFinanceDO.setUpdateTime(new Date());
		int i = loanInvestorFinanceDAO.updateByPrimaryKeySelective(loanInvestorFinanceDO);
		if (i==0){
			ResponseHeader responseHeader = ResponseHeaderBuilder.build(UPDATEERROR,UPDATEERROR.getMessage());
			response.setHeader(responseHeader);
			return;
		}
	}
}
