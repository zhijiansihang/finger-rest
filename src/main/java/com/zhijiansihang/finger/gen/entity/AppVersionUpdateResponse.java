package com.zhijiansihang.finger.gen.entity;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.zhijiansihang.finger.mmc.MobileMessage;


/**
 * 检查版本更新.服务端响应
 * 
 * @author 代码生成器v1.0
 * 
 */
@JsonInclude(Include.NON_NULL)
public class AppVersionUpdateResponse extends MobileMessage {


	/**
	 * @see com.zhijiansihang.finger.gen.entity.AppVersionUpdateResponse#getUpdateList
	 * 
	 */
	@JsonInclude(Include.NON_NULL)
	public static class UpdateListElement {

		private String currVersion;
		private String downloadPath;
		private String indexURL;
		private String iswhole;
		private String module;
		private String updateContent;
		private String updateStrategy;
		private String updateTitle;
		private String zipFileSize;

		/**
		 * @return 模块当前版本
		 */
		public String getCurrVersion() {
			return currVersion;
		}

		public void setCurrVersion(String currVersion) {
			this.currVersion = currVersion;
		}

		/**
		 * @return 更新文件下载地址
		 */
		public String getDownloadPath() {
			return downloadPath;
		}

		public void setDownloadPath(String downloadPath) {
			this.downloadPath = downloadPath;
		}

		/**
		 * @return index地址
		 */
		public String getIndexURL() {
			return indexURL;
		}

		public void setIndexURL(String indexURL) {
			this.indexURL = indexURL;
		}

		/**
		 * @return 0-增量更新  1-全量更新
		 */
		public String getIswhole() {
			return iswhole;
		}

		public void setIswhole(String iswhole) {
			this.iswhole = iswhole;
		}

		/**
		 * @return 模块名称
		 */
		public String getModule() {
			return module;
		}

		public void setModule(String module) {
			this.module = module;
		}

		/**
		 * @return 更新内容
		 */
		public String getUpdateContent() {
			return updateContent;
		}

		public void setUpdateContent(String updateContent) {
			this.updateContent = updateContent;
		}

		/**
		 * @return 更新策略
		 */
		public String getUpdateStrategy() {
			return updateStrategy;
		}

		public void setUpdateStrategy(String updateStrategy) {
			this.updateStrategy = updateStrategy;
		}

		/**
		 * @return 更新标题
		 */
		public String getUpdateTitle() {
			return updateTitle;
		}

		public void setUpdateTitle(String updateTitle) {
			this.updateTitle = updateTitle;
		}

		/**
		 * @return 更新文件大小
		 */
		public String getZipFileSize() {
			return zipFileSize;
		}

		public void setZipFileSize(String zipFileSize) {
			this.zipFileSize = zipFileSize;
		}
	
		@Override
		public String toString() {
			String str = ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
			return str;
		}
	}

	private String content;
	private String flag;
	private String reviewing;
	private String title;
	private String updateTime;
	private String url;
	private String versionName;
	private List<UpdateListElement> updateList;

	public AppVersionUpdateResponse() {
		super();
		StringBuffer sb = new StringBuffer();
		
		
		String eps = sb.toString();
		if(eps.endsWith(",")){
			eps = eps.substring(0, eps.length() - 1);
		}
		this.setMsgeps(eps);
	}

	public AppVersionUpdateResponse(String statusCode, String statusMessage) {
		this.setStatusCode(statusCode);
		this.setStatusMessage(statusMessage);
	}


	/**
	 * @return 版本升级内容
	 */
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return 3为强制升级，2为推荐升级，1为不需要升级，-1提审中
	 */
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * @return ios审核：1-非审核状态  -1  -审核状态
	 */
	public String getReviewing() {
		return reviewing;
	}

	public void setReviewing(String reviewing) {
		this.reviewing = reviewing;
	}

	/**
	 * @return 版本升级标题
	 */
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return 更新时间
	 */
	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return 下载链接
	 */
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return 版本号，如1.0.3
	 */
	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	/**
	 * @return 模块更新列表
	 */
	public List<UpdateListElement> getUpdateList() {
		return updateList;
	}

	public void setUpdateList(List<UpdateListElement> updateList) {
		this.updateList = updateList;
	}

}