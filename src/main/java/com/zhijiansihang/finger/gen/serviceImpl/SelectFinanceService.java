package com.zhijiansihang.finger.gen.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.zhijiansihang.finger.app.dao.mysql.mapper.UserFinanceDetailDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import com.zhijiansihang.finger.app.sharing.SharingProperties;
import com.zhijiansihang.finger.app.tool.Page;
import com.zhijiansihang.finger.app.vo.UserFinanceDetailSelect;
import com.zhijiansihang.finger.app.vo.UserFinanceDetailVO;
import com.zhijiansihang.finger.gen.entity.MyCollectionPersonResponse;
import com.zhijiansihang.finger.gen.tool.CheckTools;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.SelectFinanceRequest;
import com.zhijiansihang.finger.gen.entity.SelectFinanceResponse;
import com.zhijiansihang.finger.gen.entity.SelectFinanceResponse.FinanceListElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

/**
 * 发现投顾
 * 
 */
@Component("selectFinanceService")
public class SelectFinanceService implements MessageService<SelectFinanceRequest, Response<SelectFinanceResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(SelectFinanceService.class);
	private static final String SERVICE_DESC = "发现投顾";

	@Autowired
	UserFinanceDetailDAO userFinanceDetailDAO;
	@Autowired
	SharingProperties sharingProperties;
	@Override
	public void execute(SelectFinanceRequest request, Response<SelectFinanceResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		//0:默认排序1:按产品数量排序2:按预约单数排序3:按关注度排序
		String requestSort = request.getOrder();
		//0:全部1:机构理财师2:个人理财师
		String type = request.getType();

		if (requestSort== null || requestSort.length() == 0){
			requestSort = "0";
		}
		UserFinanceDetailSelect userFinanceDetailSelect = new UserFinanceDetailSelect();
		userFinanceDetailSelect.setFinanceOrder(Integer.parseInt(requestSort.trim()));
		userFinanceDetailSelect.setFinanceType(Integer.parseInt(type.trim()));

		Long id = UserTools.getLoginUser().getId();
		Page<UserFinanceDetailSelect, UserFinanceDetailVO> page = Page.create();
		page.setCurrentPage(CheckTools.isInteger(request.getCurrentPage()) ? Integer.parseInt(request.getCurrentPage()) : 1);
		page.setPageSize(CheckTools.isInteger(request.getPageSize()) ? Integer.parseInt(request.getPageSize()) : 10);
		page.setSelect(userFinanceDetailSelect);

		int count = userFinanceDetailDAO.selectCountByFinanceType(userFinanceDetailSelect);
		page.setRecordCount(count);

		if (count > 0) {
			List<UserFinanceDetailVO> cmsDOS = userFinanceDetailDAO.selectByFinanceType(userFinanceDetailSelect, page.getRowBounds());
			response.getBody().setFinanceList(getFinanceList(cmsDOS));
		}else {
			response.getBody().setFinanceList(new ArrayList<>());
		}
		response.getBody().setCurrentPage(page.getCurrentPage() + "");
		response.getBody().setPageCount(page.getPageCount() + "");
		response.getBody().setPageSize(page.getPageSize() + "");
		response.getBody().setRecordCount(page.getRecordCount() + "");
	}

	private List<FinanceListElement> getFinanceList(List<UserFinanceDetailVO> cmsDOS ) {
		List<FinanceListElement> elems = new ArrayList<FinanceListElement>();
		if (cmsDOS == null){
			return elems;
		}
		for (UserFinanceDetailVO userFinanceDetailVO : cmsDOS){
			FinanceListElement elem = new FinanceListElement();
			elems.add(elem);
			elem.setAdoptCount(userFinanceDetailVO.getAdoptCount() == null ? "0" : userFinanceDetailVO.getAdoptCount().toString());
			elem.setInstitutionName(CheckTools.nullToEmptyString(userFinanceDetailVO.getInstitutionName()));
			elem.setLoanCount(userFinanceDetailVO.getNewloancount() == null ? "0" : userFinanceDetailVO.getNewloancount().toString());
			if (userFinanceDetailVO.getLogo() != null && userFinanceDetailVO.getLogo().trim().length() > 0) {
				elem.setLogo(sharingProperties.getStaticServerLink() + userFinanceDetailVO.getLogo());
			} else {
				elem.setLogo("");
			}
			elem.setPosition(CheckTools.nullToEmptyString(userFinanceDetailVO.getPosition()));
			elem.setRealName(CheckTools.nullToEmptyString(userFinanceDetailVO.getNickName()));
			elem.setServiceDirection(CheckTools.nullToEmptyString(userFinanceDetailVO.getServiceDirection()));
			elem.setUserId(userFinanceDetailVO.getUserId().toString());
			elem.setUserOrderCount(userFinanceDetailVO.getUserOrderCount() == null ? "0" : userFinanceDetailVO.getUserOrderCount().toString());
		}
		return elems;
	}
}
