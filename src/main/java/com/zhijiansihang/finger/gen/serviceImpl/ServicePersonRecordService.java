package com.zhijiansihang.finger.gen.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.zhijiansihang.common.ResponseHeader;
import com.zhijiansihang.common.ResponseHeaderBuilder;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserServiceRecordDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import com.zhijiansihang.finger.app.sharing.SharingProperties;
import com.zhijiansihang.finger.app.tool.Page;
import com.zhijiansihang.finger.app.vo.UserServiceRecordVO;
import com.zhijiansihang.finger.gen.tool.CheckTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.ServicePersonRecordRequest;
import com.zhijiansihang.finger.gen.entity.ServicePersonRecordResponse;
import com.zhijiansihang.finger.gen.entity.ServicePersonRecordResponse.ServicePersonListElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 点咨询和预约客户
 * 
 */
@Component("servicePersonRecordService")
public class ServicePersonRecordService implements MessageService<ServicePersonRecordRequest, Response<ServicePersonRecordResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(ServicePersonRecordService.class);
	private static final String SERVICE_DESC = "点咨询和预约客户";
	@Autowired
	UserServiceRecordDAO userServiceRecordDAO;
	@Autowired
	SharingProperties sharingProperties;
	@Override
	public void execute(ServicePersonRecordRequest request, Response<ServicePersonRecordResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		String financeUserid = request.getFinanceUserid();
		if (!CheckTools.isInteger(financeUserid)){
			ResponseHeader responseHeader = ResponseHeaderBuilder.buildValidateError("请求参数financeUserid错误");
			response.setHeader(responseHeader);
			return;
		}

		Page<Long, UserDO> page = Page.create();
		page.setCurrentPage(CheckTools.isInteger(request.getCurrentPage()) ? Integer.parseInt(request.getCurrentPage()) : 1);
		page.setPageSize(CheckTools.isInteger(request.getPageSize()) ? Integer.parseInt(request.getPageSize()) : 10);
		page.setSelect(Long.parseLong(financeUserid));
		int count = userServiceRecordDAO.countByUserid(Long.parseLong(financeUserid));
		page.setRecordCount(count);

		if (count > 0) {
			List<UserServiceRecordVO> cmsDOS = userServiceRecordDAO.selectByUseridPage(Long.parseLong(financeUserid), page.getRowBounds());
			response.getBody().setServicePersonList(getServicePersonList(cmsDOS));
		}else {
			response.getBody().setServicePersonList(new ArrayList<>());
		}
		response.getBody().setCurrentPage(page.getCurrentPage() + "");
		response.getBody().setPageCount(page.getPageCount() + "");
		response.getBody().setPageSize(page.getPageSize() + "");
		response.getBody().setRecordCount(page.getRecordCount() + "");
	}

	private List<ServicePersonListElement> getServicePersonList(List<UserServiceRecordVO> cmsDOS) {
		List<ServicePersonListElement> elems = new ArrayList<ServicePersonListElement>();
		if (cmsDOS == null){
			return elems;
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		for (UserServiceRecordVO userServiceRecordVO : cmsDOS){
			ServicePersonListElement elem = new ServicePersonListElement();
			elems.add(elem);
			elem.setCreateTime(format.format(userServiceRecordVO.getCreateTime()));
			if (userServiceRecordVO.getLogo() !=null && userServiceRecordVO.getLogo().trim().length()>0){
				elem.setLogo(sharingProperties.getStaticServerLink()+userServiceRecordVO.getLogo());
			}else {
				elem.setLogo("");
			}
			elem.setRealName(userServiceRecordVO.getRealName());
			elem.setType(userServiceRecordVO.getServiceType().toString());
		}


		return elems;
	}
}
