package com.zhijiansihang.finger.gen.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zhijiansihang.finger.mmc.MobileMessage;

/**
 * 分险评测结果.客户端请求
 * 
 * @author 代码生成器v1.0
 * 
 */
 @JsonIgnoreProperties(ignoreUnknown = true)
public class RiskAssessmentResultPostRequest extends MobileMessage {


	private String answers;
	private String result;

	public RiskAssessmentResultPostRequest() {
		super();
	}	

	/**
	 * @return 答案json数组，需客户端同意协商定义，获取上一次答案原路返回
	 */
	public String getAnswers() {
		return answers;
	}

	public void setAnswers(String answers) {
		this.answers = answers;
	}

	/**
	 * @return 1:保守型2:稳健型3:成熟型4:进取型5:激进型
	 */
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
}