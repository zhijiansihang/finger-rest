package com.zhijiansihang.finger.gen.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.zhijiansihang.finger.app.dao.mysql.mapper.LoanInvestorFinanceDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import com.zhijiansihang.finger.app.sharing.SharingProperties;
import com.zhijiansihang.finger.app.tool.Page;
import com.zhijiansihang.finger.app.vo.LoanInvestorFinanceVO;
import com.zhijiansihang.finger.gen.tool.CheckTools;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.FinanceLoanInvestorRequest;
import com.zhijiansihang.finger.gen.entity.FinanceLoanInvestorResponse;
import com.zhijiansihang.finger.gen.entity.FinanceLoanInvestorResponse.LoanInvestorListElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 理财师查看属于预约自己的记录
 */
@Component("financeLoanInvestorService")
public class FinanceLoanInvestorService implements MessageService<FinanceLoanInvestorRequest, Response<FinanceLoanInvestorResponse>> {

    private static final Logger LOG = LoggerFactory.getLogger(FinanceLoanInvestorService.class);
    private static final String SERVICE_DESC = "理财师查看属于预约自己的记录";

    @Autowired
    LoanInvestorFinanceDAO loanInvestorFinanceDAO;
    @Autowired
    SharingProperties sharingProperties;

    @Override
    public void execute(FinanceLoanInvestorRequest request, Response<FinanceLoanInvestorResponse> response) {
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
            count = loanInvestorFinanceDAO.countNotDealByFinanceUserid(id);
        }else {
            count = loanInvestorFinanceDAO.countDealByFinanceUserid(id);
        }
        page.setRecordCount(count);

        if (count > 0) {
            List<LoanInvestorFinanceVO> cmsDOS = new ArrayList<>();
            if (isDeal == 0){
                cmsDOS = loanInvestorFinanceDAO.selectNotDealByFinanceUseridPage(id, page.getRowBounds());
            }else {
                cmsDOS = loanInvestorFinanceDAO.selectDealByFinanceUseridPage(id, page.getRowBounds());
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
            elem.setRealName(CheckTools.nullToEmptyString(loanInvestorFinanceVO.getNickName()));
            elem.setTitle(loanInvestorFinanceVO.getTitle());
            if (loanInvestorFinanceVO.getLogo() == null || loanInvestorFinanceVO.getLogo().length()==0){
                elem.setLogo("");
            }else {
                elem.setLogo(sharingProperties.getStaticServerLink()+loanInvestorFinanceVO.getLogo().trim());
            }
            SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            elem.setCreatetime(format0.format(loanInvestorFinanceVO.getCreateTime()));
        }
        return elems;
    }
}
