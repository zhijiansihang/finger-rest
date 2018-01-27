package com.zhijiansihang.finger.gen.entity;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.zhijiansihang.finger.mmc.MobileMessage;


/**
 * Y获取banner咨询公告.服务端响应
 * 
 * @author 代码生成器v1.0
 * 
 */
@JsonInclude(Include.NON_NULL)
public class GetCmsResponse extends MobileMessage {


	/**
	 * @see com.zhijiansihang.finger.gen.entity.GetCmsResponse#getCmsList
	 * 
	 */
	@JsonInclude(Include.NON_NULL)
	public static class CmsListElement {

		private String content;
		private String hrefLink;
		private String id;
		private String imageAccessPath;
		private String subTitle;
		private String title;

		/**
		 * @return 内容
		 */
		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		/**
		 * @return 跳转链接
		 */
		public String getHrefLink() {
			return hrefLink;
		}

		public void setHrefLink(String hrefLink) {
			this.hrefLink = hrefLink;
		}

		/**
		 * @return id
		 */
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		/**
		 * @return 前台图片的链接
		 */
		public String getImageAccessPath() {
			return imageAccessPath;
		}

		public void setImageAccessPath(String imageAccessPath) {
			this.imageAccessPath = imageAccessPath;
		}

		/**
		 * @return 副标题
		 */
		public String getSubTitle() {
			return subTitle;
		}

		public void setSubTitle(String subTitle) {
			this.subTitle = subTitle;
		}

		/**
		 * @return 标题
		 */
		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
	
		@Override
		public String toString() {
			String str = ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
			return str;
		}
	}

	private String currentPage;
	private String pageCount;
	private String pageSize;
	private String recordCount;
	private String typeCode;
	private List<CmsListElement> cmsList;

	public GetCmsResponse() {
		super();
		StringBuffer sb = new StringBuffer();
		
		
		String eps = sb.toString();
		if(eps.endsWith(",")){
			eps = eps.substring(0, eps.length() - 1);
		}
		this.setMsgeps(eps);
	}

	public GetCmsResponse(String statusCode, String statusMessage) {
		this.setStatusCode(statusCode);
		this.setStatusMessage(statusMessage);
	}


	/**
	 * @return 当前页
	 */
	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return 总页数
	 */
	public String getPageCount() {
		return pageCount;
	}

	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
	}

	/**
	 * @return 每页多少条
	 */
	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return 总记录数
	 */
	public String getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(String recordCount) {
		this.recordCount = recordCount;
	}

	/**
	 * @return banner=100bannernotice200公告information300资讯avatar400头像exam500考题
	 */
	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	/**
	 * @return 
	 */
	public List<CmsListElement> getCmsList() {
		return cmsList;
	}

	public void setCmsList(List<CmsListElement> cmsList) {
		this.cmsList = cmsList;
	}

}