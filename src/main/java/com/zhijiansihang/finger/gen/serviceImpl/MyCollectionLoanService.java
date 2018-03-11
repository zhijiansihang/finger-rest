package com.zhijiansihang.finger.gen.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.zhijiansihang.common.ResponseHeader;
import com.zhijiansihang.common.ResponseHeaderBuilder;
import com.zhijiansihang.finger.app.dao.mysql.mapper.LoanDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.LoanDO;
import com.zhijiansihang.finger.app.tool.Page;
import com.zhijiansihang.finger.gen.tool.CheckTools;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.MyCollectionLoanRequest;
import com.zhijiansihang.finger.gen.entity.MyCollectionLoanResponse;
import com.zhijiansihang.finger.gen.entity.MyCollectionLoanResponse.LoanListElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * 我的收藏标的
 * 
 */
@Component("myCollectionLoanService")
public class MyCollectionLoanService implements MessageService<MyCollectionLoanRequest, Response<MyCollectionLoanResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(MyCollectionLoanService.class);
	private static final String SERVICE_DESC = "我的收藏标的";


	@Autowired
	LoanDAO loanDAO;
	@Override
	public void execute(MyCollectionLoanRequest request, Response<MyCollectionLoanResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		//产品类型:1.信托；2.资管；3.其他资产,4私募
		String productType = request.getProductType();
		String currentPage = request.getCurrentPage();
		if (currentPage == null || currentPage.trim().length() ==0){
			currentPage ="1";
		}else {
			currentPage = currentPage.trim();
		}
		if (productType == null || productType.trim().length() ==0){
			ResponseHeader responseHeader = ResponseHeaderBuilder.buildValidateError("请求参数productType错误");
			response.setHeader(responseHeader);
			return;
		}else {
			productType = productType.trim();
		}

		Page<LoanDO, LoanDO> page = Page.create();
		page.setCurrentPage(CheckTools.isInteger(request.getCurrentPage()) ? Integer.parseInt(request.getCurrentPage()) : 1);
		page.setPageSize(10);
		LoanDO select = new LoanDO();
		if (Integer.parseInt(productType) < 4){
			select.setLoanType((byte)1);
			select.setProductType(Short.parseShort(productType));
		}else {
			select.setLoanType((byte)2);
		}
		Long userid = UserTools.getLoginUser().getId();
		select.setInstitutionUserId(userid);
		page.setSelect(select);

		int count = loanDAO.countByCollectionLoan(select);
		page.setRecordCount(count);
		if (count > 0) {
			List<LoanDO> loanDOS = loanDAO.selectByCollectionLoan(select, page.getRowBounds());
			response.getBody().setLoanList(getLoanList(loanDOS));
		} else {
			response.getBody().setLoanList(new ArrayList<>());
		}

		response.getBody().setCurrentPage(page.getCurrentPage() + "");
		response.getBody().setPageCount(page.getPageCount() + "");
		response.getBody().setPageSize(page.getPageSize() + "");
		response.getBody().setRecordCount(page.getRecordCount() + "");
	}

	private List<LoanListElement> getLoanList(List<LoanDO> loanDOS) {
		List<LoanListElement> elems = new ArrayList<LoanListElement>();
		LoanListElement elem = new LoanListElement();
		elems.add(elem);

		elem.setAdaptationDeadline("10");
		elem.setBeginAmount("1");
		elem.setBrightSpot("0");
		elem.setInterestRate("10");
		elem.setInvestmentDeadline("10");
		elem.setIsRateFloating("0");
		elem.setLoanId("1");
		elem.setLoanStatus("10");
		elem.setLoanType("1");
		elem.setProductType("1");
		elem.setProductType("10");
		elem.setProgress("40");
		elem.setSafeguardWay("1");
		elem.setTitle("1");

		return elems;
	}
}
