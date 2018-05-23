package com.zhijiansihang.finger.gen.entity;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zhijiansihang.finger.mmc.MobileMessage;

/**
 * 检查版本更新.客户端请求
 * 
 * @author 代码生成器v1.0
 * 
 */
 @JsonIgnoreProperties(ignoreUnknown = true)
public class AppVersionUpdateRequest extends MobileMessage {


	/**
	 * @see com.zhijiansihang.finger.gen.entity.AppVersionUpdateRequest#getMvList
	 * 
	 */
	public static class ElementMvList {

		private String module;
		private String version;

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
		 * @return 模块版本
		 */
		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}
	
		@Override
		public String toString() {
			String str = ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
			return str;
		}
	}

	private List<ElementMvList> mvList;

	public AppVersionUpdateRequest() {
		super();
	}	

	/**
	 * @return 模块列表
	 */
	public List<ElementMvList> getMvList() {
		return mvList;
	}

	public void setMvList(List<ElementMvList> mvList) {
		this.mvList = mvList;
	}
	
}