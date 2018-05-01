package com.zhijiansihang.finger.app.manager;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author: Paul Zhang
 * @date: 16:21 2017/12/27
 */
@ConfigurationProperties(prefix = "sms.aliyun", ignoreUnknownFields = true)
@Component
public class AliYunSmsProperties {
    public String getMessageSignature() {
        return messageSignature;
    }

    public void setMessageSignature(String messageSignature) {
        this.messageSignature = messageSignature;
    }

    private String messageSignature;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    private String accessKeyId;

    private String accessKeySecret;

}
