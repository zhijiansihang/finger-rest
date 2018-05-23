package com.zhijiansihang.finger.gen.serviceImpl;

import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.AppVersionUpdateRequest;
import com.zhijiansihang.finger.gen.entity.AppVersionUpdateResponse;
import com.zhijiansihang.finger.gen.entity.AppVersionUpdateResponse.UpdateListElement;
import com.zhijiansihang.finger.mmc.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 检查版本更新
 * 
 */
@Component("appVersionUpdateService")
public class AppVersionUpdateService implements MessageService<AppVersionUpdateRequest, Response<AppVersionUpdateResponse>> {

	private static final Logger LOG = LoggerFactory.getLogger(AppVersionUpdateService.class);
	private static final String SERVICE_DESC = "检查版本更新";

	@Override
	public void execute(AppVersionUpdateRequest request, Response<AppVersionUpdateResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		response.getBody().setContent("");
		response.getBody().setFlag("");
		response.getBody().setReviewing("-1");
		response.getBody().setTitle("");
		response.getBody().setUpdateTime("");
		response.getBody().setUrl("");
		response.getBody().setVersionName("");
		response.getBody().setUpdateList(getUpdateList());
	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
		response.getBody().setMode("test");
	}

	private List<UpdateListElement> getUpdateList() {
		List<UpdateListElement> elems = new ArrayList<UpdateListElement>();
		UpdateListElement elem = new UpdateListElement();
		elems.add(elem);

		elem.setCurrVersion("2.0.1");
		elem.setDownloadPath("https://www.meme2c.com/");
		elem.setIndexURL("static.meimeitech.com/app/fund/20170811130000/index.html");
		elem.setIswhole("0");
		elem.setModule("fund");
		elem.setUpdateContent("基金模块页面样式修改");
		elem.setUpdateStrategy("2");
		elem.setUpdateTitle("基金模块升级");
		elem.setZipFileSize("30M");

		return elems;
	}
}
