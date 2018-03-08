package com.zhijiansihang.finger.app.manager;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author: Paul Zhang
 * @date: 16:21 2017/12/27
 */
@ConfigurationProperties(prefix = "sjb", ignoreUnknownFields = true)
@Component
public class RealNameAuthProperties {

    /**
     * 请求数据宝的私钥
     */
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
