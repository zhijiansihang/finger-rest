package com.zhijiansihang.finger.gen.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zhijiansihang.finger.mmc.MobileMessage;

/**
 * Y获取短信验证码.客户端请求
 * 
 * @author 代码生成器v1.0
 * 
 */
 @JsonIgnoreProperties(ignoreUnknown = true)
public class GetSmsRequest extends MobileMessage {


	private String kaptchaCode;
	private String kaptchaToken;
	private String mobile;

	public GetSmsRequest() {
		super();
	}	

	/**
	 * @return 图形验证码只可以使用一次
	 */
	public String getKaptchaCode() {
		return kaptchaCode;
	}

	public void setKaptchaCode(String kaptchaCode) {
		this.kaptchaCode = kaptchaCode;
	}

	/**
	 * @return 请求图形验证码返回的token
	 */
	public String getKaptchaToken() {
		return kaptchaToken;
	}

	public void setKaptchaToken(String kaptchaToken) {
		this.kaptchaToken = kaptchaToken;
	}

	/**
	 * @return 手机号
	 */
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}