package com.zhijiansihang.finger.gen.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.zhijiansihang.finger.app.dao.mysql.mapper.LoanInvestorFinanceDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import com.zhijiansihang.finger.app.tool.Page;
import com.zhijiansihang.finger.app.vo.LoanInvestorFinanceVO;
import com.zhijiansihang.finger.gen.tool.CheckTools;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.MyLoanInvestorRequest;
import com.zhijiansihang.finger.gen.entity.MyLoanInvestorResponse;
import com.zhijiansihang.finger.gen.entity.MyLoanInvestorResponse.LoanInvestorListElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;

/**
 * 我的预约记录
 * 
 */
@Component("myLoanInvestorService")
public class MyLoanInvestorService implements MessageService<MyLoanInvestorRequest, Response<MyLoanInvestorResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(MyLoanInvestorService.class);
	private static final String SERVICE_DESC = "我的预约记录";

	@Autowired
	LoanInvestorFinanceDAO loanInvestorFinanceDAO;
	@Override
	public void execute(MyLoanInvestorRequest request, Response<MyLoanInvestorResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		Long id = UserTools.getLoginUser().getId();
		int isDeal = Integer.parseInt(request.getIsDeal());
		if (isDeal == 0) {
			isDeal = 0;
		} else {
			isDeal = 1;
		}
		Page<Long, UserDO> page = Page.create();
		page.setCurrentPage(CheckTools.isInteger(request.getCurrentPage()) ? Integer.parseInt(request.getCurrentPage()) : 1);
		page.setPageSize(CheckTools.isInteger(request.getPageSize()) ? Integer.parseInt(request.getPageSize()) : 10);
		page.setSelect(id.longValue());
		int count = 0 ;
		if (isDeal == 0){
			count = loanInvestorFinanceDAO.countNotDealByUserid(id);
		}else {
			count = loanInvestorFinanceDAO.countDealByUserid(id);
		}
		page.setRecordCount(count);

		if (count > 0) {
			List<LoanInvestorFinanceVO> cmsDOS = new ArrayList<>();
			if (isDeal == 0){
				cmsDOS = loanInvestorFinanceDAO.selectNotDealByUseridPage(id, page.getRowBounds());
			}else {
				cmsDOS = loanInvestorFinanceDAO.selectDealByUseridPage(id, page.getRowBounds());
			}
			response.getBody().setLoanInvestorList(getLoanInvestorList(cmsDOS));
		} else {
			response.getBody().setLoanInvestorList(new ArrayList<>());
		}
		response.getBody().setCurrentPage(page.getCurrentPage() + "");
		response.getBody().setPageCount(page.getPageCount() + "");
		response.getBody().setPageSize(page.getPageSize() + "");
		response.getBody().setRecordCount(page.getRecordCount() + "");
	}

	private List<LoanInvestorListElement> getLoanInvestorList(List<LoanInvestorFinanceVO> cmsDOS) {
		List<LoanInvestorListElement> elems = new ArrayList<LoanInvestorListElement>();
		if (cmsDOS == null){
			return elems;
		}
		for (LoanInvestorFinanceVO loanInvestorFinanceVO : cmsDOS){
			LoanInvestorListElement elem = new LoanInvestorListElement();
			elems.add(elem);

			elem.setAmount(loanInvestorFinanceVO.getAmount().toEngineeringString());
			elem.setId(loanInvestorFinanceVO.getId().toString());
			elem.setTitle(loanInvestorFinanceVO.getTitle());
		}


		return elems;
	}
}
