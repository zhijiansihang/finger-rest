package com.zhijiansihang.finger.app.manager;

import com.zhijiansihang.finger.gen.controller.MobileController;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by paul on 2018/1/22.
 */
@Component
public class RealNameAuthManager {
    private static final Logger LOG = LoggerFactory.getLogger(RealNameAuthManager.class);

    public boolean isReal(String realName,String idCard) throws Exception{

        //http://api.chinadatapay.com/communication/personal/1882?key=您申请的key值&name=姓名&idcard=身份证号
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://api.chinadatapay.com/communication/personal/1882");
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("key", "1"));
        nvps.add(new BasicNameValuePair("name", realName));
        nvps.add(new BasicNameValuePair("idcard", idCard));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        CloseableHttpResponse response2 = httpclient.execute(httpPost);

        try {
            StatusLine statusLine = response2.getStatusLine();
            if (200 != statusLine.getStatusCode()){
                LOG.error("实名认证第三方服务异常,响应返回[{}]",statusLine);
                throw new RuntimeException("第三方服务异常!");
            }
            HttpEntity entity2 = response2.getEntity();
            InputStream content = entity2.getContent();
            String string = IOUtils.toString(content, Charset.forName("UTF-8"));
            return string.contains("\"result\": \"1\"");
        } finally {
            response2.close();
        }
    }
}
