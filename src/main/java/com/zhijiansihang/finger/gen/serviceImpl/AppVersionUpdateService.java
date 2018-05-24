package com.zhijiansihang.finger.gen.serviceImpl;

import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.app.constant.PlatfromType;
import com.zhijiansihang.finger.app.dao.mysql.mapper.AppVersionDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.AppVersionDO;
import com.zhijiansihang.finger.app.dao.mysql.model.AppVersionDOExample;
import com.zhijiansihang.finger.gen.entity.AppVersionUpdateRequest;
import com.zhijiansihang.finger.gen.entity.AppVersionUpdateResponse;
import com.zhijiansihang.finger.gen.entity.AppVersionUpdateResponse.UpdateListElement;
import com.zhijiansihang.finger.mmc.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
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

	public static final String UPDATE_STATUS_FORCE = "3";
	public static final String UPDATE_STATUS_PROMPT = "2";
	public static final String UPDATE_STATUS_NO = "1";
	public static final String UPDATE_STATUS_REVIEWING = "-1";

	@Autowired
	private AppVersionDAO appVersionDAO;

	@Override
	public void execute(AppVersionUpdateRequest request, Response<AppVersionUpdateResponse> response) {
		LOG.info("[{}][request={}]", SERVICE_DESC, request);

		String appName = "finger";
		String platform = "android";
		if(request.getPlatformType().equals(String.valueOf(PlatfromType.IOS.getCode()))){
			platform = "ios";
		}
		Integer versionCode = Integer.parseInt(request.getVersionCode());

		AppVersionDOExample example = new AppVersionDOExample();
		AppVersionDOExample.Criteria creteria = example.createCriteria();
		creteria.andAppNameEqualTo(appName);
		creteria.andPlatformEqualTo(platform);
		creteria.andVersionCodeEqualTo(versionCode);

		AppVersionDO currAppVersion = null; // 当前版本
		List<AppVersionDO> appVersionDOS = appVersionDAO.selectByExample(example);
		if(null != appVersionDOS && appVersionDOS.size() > 0){
			currAppVersion = appVersionDOS.get(0);
		}
		AppVersionDO newestVersion = appVersionDAO.getNewestVersionByAppNameAndPlatform(appName, platform); // 最新版本
		String  reviewing = "1";

		if(null == currAppVersion) {
			if (null == newestVersion) { //没查到最新版本，不提示更新
				newestVersion = new AppVersionDO();
				newestVersion.setUpdateStatus(UPDATE_STATUS_NO);
			} else { //没查到当前版本，强制更新到最新版
				if(versionCode > newestVersion.getVersionCode()){ //当前版本高于库中最高版本时不提示更新
					newestVersion.setUpdateStatus(UPDATE_STATUS_NO);
				} else {
					newestVersion.setUpdateStatus(UPDATE_STATUS_FORCE);
				}

			}
		} else {
			if (null == newestVersion) { // 没查到最新版本，不提示更新
				newestVersion = new AppVersionDO();
				newestVersion.setUpdateStatus(UPDATE_STATUS_NO);
			} else {
				if(currAppVersion.getVersionCode() == newestVersion.getVersionCode()){ // 当前版本是最新版本
					newestVersion.setUpdateStatus(UPDATE_STATUS_NO);
				}else if(currAppVersion.getVersionCode() < newestVersion.getMinVersionCode()){ // 当前版本小于最新版的最低兼容版本，强制更新
					newestVersion.setUpdateStatus(UPDATE_STATUS_FORCE);
				}else{
					newestVersion.setUpdateStatus(UPDATE_STATUS_PROMPT); // 推荐升级
				}
			}
			if (currAppVersion.getUpdateStatus() != null && UPDATE_STATUS_REVIEWING.equals(currAppVersion.getUpdateStatus())){ // 当前版本是提审中
				//提审中状态，flag字段返回不提示更新，reviewing字段返回提审中
				reviewing = UPDATE_STATUS_REVIEWING;
			}
		}



		response.getBody().setContent(newestVersion.getUpdateContent());
		response.getBody().setFlag(newestVersion.getUpdateStatus());
		response.getBody().setReviewing(reviewing);
		response.getBody().setTitle(newestVersion.getUpdateTitle());
		SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd");
		response.getBody().setUpdateTime(newestVersion.getUpdateTime() == null ? null : format0.format(newestVersion.getUpdateTime()));
		response.getBody().setUrl(newestVersion.getUpdateUrl());
		response.getBody().setVersionName(newestVersion.getVersionName());
		response.getBody().setUpdateList(getUpdateList());
	  	//挡板服务标志，实现该服务时，不要给mode赋值了，把下边的代码删了
//		response.getBody().setMode("test");
	}

	private List<UpdateListElement> getUpdateList() {
		List<UpdateListElement> elems = new ArrayList<UpdateListElement>();
		UpdateListElement elem = new UpdateListElement();
		elems.add(elem);

//		elem.setCurrVersion("2.0.1");
//		elem.setDownloadPath("https://www.meme2c.com/");
//		elem.setIndexURL("static.meimeitech.com/app/fund/20170811130000/index.html");
//		elem.setIswhole("0");
//		elem.setModule("fund");
//		elem.setUpdateContent("基金模块页面样式修改");
//		elem.setUpdateStrategy("2");
//		elem.setUpdateTitle("基金模块升级");
//		elem.setZipFileSize("30M");

		return elems;
	}
}
