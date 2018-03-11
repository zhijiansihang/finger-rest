package com.zhijiansihang.finger.gen.serviceImpl;

import com.sun.org.apache.regexp.internal.RE;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.common.ResponseHeader;
import com.zhijiansihang.common.ResponseHeaderBuilder;
import com.zhijiansihang.finger.app.dao.mysql.mapper.LoanDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.LoanDO;
import com.zhijiansihang.finger.app.tool.Page;
import com.zhijiansihang.finger.gen.entity.GetPublicLoanRequest;
import com.zhijiansihang.finger.gen.entity.GetPublicLoanResponse;
import com.zhijiansihang.finger.gen.entity.GetPublicLoanResponse.LoanListElement;
import com.zhijiansihang.finger.gen.tool.CheckTools;
import com.zhijiansihang.finger.mmc.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取公募产品列表
 * 
 */
@Component("getPublicLoanService")
public class GetPublicLoanService implements MessageService<GetPublicLoanRequest, Response<GetPublicLoanResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(GetPublicLoanService.class);
	private static final String SERVICE_DESC = "获取公募产品列表";


	@Autowired
	LoanDAO loanDAO;
	@Override
	public void execute(GetPublicLoanRequest request, Response<GetPublicLoanResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		String currentPage = request.getCurrentPage();
		if (currentPage == null || currentPage.trim().length() ==0){
			currentPage ="1";
		}else {
			currentPage = currentPage.trim();
		}
		//投资期限
		String investmentDeadline = request.getInvestmentDeadline();
		if (investmentDeadline == null || investmentDeadline.trim().length() ==0){
			investmentDeadline =null;
		}else {
			investmentDeadline = investmentDeadline.trim();
		}
		//投资方向
		String productDirection = request.getProductDirection();
		if (productDirection == null || productDirection.trim().length() ==0){
			productDirection =null;
		}else {
			productDirection = productDirection.trim();
		}
		//公墓类型：产品类型
		String productType = request.getProductType();
		if (productType == null || productType.trim().length() ==0){
			ResponseHeader responseHeader = ResponseHeaderBuilder.buildValidateError("请求参数productType错误");
			response.setHeader(responseHeader);
			return;
		}else {
			productType = productType.trim();
		}
		//大小配比
		String ratioType = request.getRatioType();
		if (ratioType == null || ratioType.trim().length() ==0){
			ratioType =null;
		}else {
			ratioType = ratioType.trim();
		}
		//付息方式:
		String servicingWay = request.getServicingWay();
		if (servicingWay == null || servicingWay.trim().length() ==0){
			servicingWay =null;
		}else {
			servicingWay = servicingWay.trim();
		}


		Page<LoanDO, LoanDO> page = Page.create();
		page.setCurrentPage(CheckTools.isInteger(request.getCurrentPage()) ? Integer.parseInt(request.getCurrentPage()) : 1);
		page.setPageSize(10);
		LoanDO select = new LoanDO();
		select.setInvestmentDeadline(investmentDeadline == null?null:Short.parseShort(investmentDeadline));
		select.setProductDirection(productDirection);
		select.setProductType(Short.parseShort(productType));
		select.setRatioType(ratioType == null?null:Short.parseShort(ratioType));
		select.setServicingWay(servicingWay == null?null:Short.parseShort(servicingWay));
		/**
		 * 1:公墓，2私募
		 */
		select.setLoanType((byte)2);
		page.setSelect(select);

		int count = loanDAO.countByLoan(select);
		page.setRecordCount(count);
		if (count > 0) {
			List<LoanDO> loanDOS = loanDAO.selectByLoan(select, page.getRowBounds());
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
		elem.setFundType("1");
		elem.setInterestRate("10");
		elem.setInvestmentDeadline("10");
		elem.setIsRateFloating("0");
		elem.setLoanId("1");
		elem.setLoanStatus("10");
		elem.setLoanType("1");
		elem.setProductType("10");
		elem.setProgress("40");
		elem.setSafeguardWay("1");
		elem.setTitle("1");

		return elems;
	}
}
