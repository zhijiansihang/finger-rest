package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.finger.app.dao.mysql.mapper.LoanDAO;
import com.zhijiansihang.finger.app.dao.mysql.mapper.LoanInvestorFinanceDAO;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDAO;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserFinanceDetailDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.LoanDO;
import com.zhijiansihang.finger.app.dao.mysql.model.LoanInvestorFinanceDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserFinanceDetailDO;
import com.zhijiansihang.finger.app.sharing.SharingProperties;
import com.zhijiansihang.finger.gen.tool.CheckTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.LoanInvestorDetailRequest;
import com.zhijiansihang.finger.gen.entity.LoanInvestorDetailResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * 预约详情
 * 
 */
@Component("loanInvestorDetailService")
public class LoanInvestorDetailService implements MessageService<LoanInvestorDetailRequest, Response<LoanInvestorDetailResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(LoanInvestorDetailService.class);
	private static final String SERVICE_DESC = "预约详情";

	@Autowired
	LoanInvestorFinanceDAO loanInvestorFinanceDAO;
	@Autowired
	UserFinanceDetailDAO userFinanceDetailDAO;
	@Autowired
	SharingProperties sharingProperties;
	@Autowired
	UserDAO userDAO;
	@Autowired
	LoanDAO loanDAO;
	@Override
	public void execute(LoanInvestorDetailRequest request, Response<LoanInvestorDetailResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		String requestId = request.getId();
		LoanInvestorFinanceDO loanInvestorFinanceDO = loanInvestorFinanceDAO.selectByPrimaryKey(Long.parseLong(requestId));
		UserFinanceDetailDO userFinanceDetailDO = userFinanceDetailDAO.selectByPrimaryKey(loanInvestorFinanceDO.getFinanceUserId());
		LoanDO loanDO = loanDAO.selectByPrimaryKey(loanInvestorFinanceDO.getLoanId());

		UserDO userFinanceDO = userDAO.selectByPrimaryKey(loanInvestorFinanceDO.getFinanceUserId());
		UserDO userDO = userDAO.selectByPrimaryKey(loanInvestorFinanceDO.getUserId());

		response.getBody().setAmount(loanInvestorFinanceDO.getAmount().toString());
		response.getBody().setBasisIntere(loanDO.getInterestRate() ==null?"0.00":loanDO.getInterestRate().toString());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		response.getBody().setCreateTime(format.format(loanInvestorFinanceDO.getCreateTime()));
		response.getBody().setFinanceRealName(CheckTools.nullToEmptyString(userFinanceDO.getRealName()));
		response.getBody().setFinanceUserId(loanInvestorFinanceDO.getFinanceUserId().toString());
		response.getBody().setInvestorRealName(CheckTools.nullToEmptyString(userDO.getRealName()));
		response.getBody().setInvestorUserId(loanInvestorFinanceDO.getUserId().toString());
		response.getBody().setIsDeal(loanInvestorFinanceDO.getIsDeal().toString());
		response.getBody().setLoanId(loanInvestorFinanceDO.getLoanId().toString());
		if (userFinanceDO.getLogo() == null || userFinanceDO.getLogo().trim().length() ==0){
			response.getBody().setLogo("");
		}else {
			response.getBody().setLogo(sharingProperties.getStaticServerLink()+userFinanceDO.getLogo().trim());
		}
		response.getBody().setMobile(userDO.getMobile());
		response.getBody().setServicingWay(loanDO.getServicingWay()==null?"":loanDO.getServicingWay().toString());
		response.getBody().setTitle(loanDO.getTitle());
	}
}
