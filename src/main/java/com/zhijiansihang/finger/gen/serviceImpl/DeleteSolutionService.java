package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserCollectionDAO;
import com.zhijiansihang.finger.gen.entity.DeleteSolutionRequest;
import com.zhijiansihang.finger.gen.entity.DeleteSolutionResponse;
import com.zhijiansihang.finger.mmc.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.stereotype.Component;

/**
 * 删除收藏
 * 
 */
@Component("deleteSolutionService")
public class DeleteSolutionService implements MessageService<DeleteSolutionRequest, Response<DeleteSolutionResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(DeleteSolutionService.class);
	private static final String SERVICE_DESC = "删除收藏";

	@Autowired
	UserCollectionDAO userCollectionDAO;
	@Override
	public void execute(DeleteSolutionRequest request, Response<DeleteSolutionResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);
		userCollectionDAO.deleteByPrimaryKey(Long.parseLong(request.getId()));
	}
}
