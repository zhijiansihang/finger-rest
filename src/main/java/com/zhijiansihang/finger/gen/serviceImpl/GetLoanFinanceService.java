package com.zhijiansihang.finger.gen.serviceImpl;

import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserFinanceDetailDAO;
import com.zhijiansihang.finger.app.sharing.SharingProperties;
import com.zhijiansihang.finger.app.vo.UserFinanceDetailVO;
import com.zhijiansihang.finger.gen.entity.GetLoanFinanceRequest;
import com.zhijiansihang.finger.gen.entity.GetLoanFinanceResponse;
import com.zhijiansihang.finger.gen.entity.GetLoanFinanceResponse.FinanceListElement;
import com.zhijiansihang.finger.mmc.MessageService;
import org.hibernate.validator.constraints.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取标的理财师列表
 */
@Component("getLoanFinanceService")
public class GetLoanFinanceService implements MessageService<GetLoanFinanceRequest, Response<GetLoanFinanceResponse>> {

    private static final Logger LOG = LoggerFactory.getLogger(GetLoanFinanceService.class);
    private static final String SERVICE_DESC = "获取标的理财师列表";

    @Autowired
    UserFinanceDetailDAO userFinanceDetailDAO;

    @Autowired
    SharingProperties sharingProperties;

    @Override
    public void execute(GetLoanFinanceRequest request, Response<GetLoanFinanceResponse> response) {
        LOG.info("[{}][request={}]", SERVICE_DESC, request);

        Long loanId = Long.parseLong(request.getLoanId());

        List<UserFinanceDetailVO> loanFinance =
                userFinanceDetailDAO.getLoanFinance(loanId);
        response.getBody().setFinanceList(getFinanceList(loanFinance));

    }

    private List<FinanceListElement> getFinanceList(List<UserFinanceDetailVO> loanFinance) {
        List<FinanceListElement> elems = new ArrayList<FinanceListElement>();
        if (loanFinance == null) {
            return elems;
        }
        for (UserFinanceDetailVO userFinanceDetailVO : loanFinance) {
            FinanceListElement elem = new FinanceListElement();
            elems.add(elem);
            if (userFinanceDetailVO.getLogo() == null) {
                elem.setLogo("");
            } else {
                elem.setLogo(sharingProperties.getStaticServerLink() + userFinanceDetailVO.getLogo());
            }
            elem.setRealName(userFinanceDetailVO.getNickName() == null ? "" : userFinanceDetailVO.getNickName());
            elem.setUserId(userFinanceDetailVO.getUserId().toString());
            elem.setWorkAge(userFinanceDetailVO.getServiceConcept() == null ? "" : userFinanceDetailVO.getServiceConcept());
        }
        return elems;
    }
}
