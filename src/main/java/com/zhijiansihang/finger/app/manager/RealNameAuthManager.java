package com.zhijiansihang.finger.app.manager;

import com.alibaba.fastjson.JSONObject;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserRealnameAuthRecordDAO;
import com.zhijiansihang.finger.app.sharing.lock.redis.RedisLock;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.UUID;

/**
 * Created by paul on 2018/1/22.
 */
@Component
public class RealNameAuthManager {
    private static final Logger LOG = LoggerFactory.getLogger(RealNameAuthManager.class);

    @Autowired
    RedisLock redisLock;
    @Autowired
    UserRealnameAuthRecordDAO userRealnameAuthRecordDAO;

    @Autowired
    RealNameAuthProperties realNameAuthProperties;

    public  boolean isReal(String realName,String idCard) throws Exception{
        boolean open = realNameAuthProperties.isOpen();
        if (!open){
            LOG.warn("实名认证接口未开启:请配置sjb.open=true");
            return true;
        }
        if (realNameAuthProperties.getKey()==null || realNameAuthProperties.getKey().length()==0){
            LOG.warn("实名认证接口未开启:请配置sjb.key=接入key");
            throw new RuntimeException("实名认证接口系统配置有误!");
        }
        if (StringUtils.isEmpty(realName) || StringUtils.isEmpty(idCard)){
            throw new RuntimeException("请求参数不合法!");
        }

        String redisKey = this.getClass().getName() + "_" + idCard.toString();
        boolean tryLock = redisLock.tryLock(redisKey);
        if (!tryLock){
            throw new RuntimeException("获取锁"+redisKey+"超时!");
        }
        try {
            //http://api.chinadatapay.com/communication/personal/1882?key=您申请的key值&name=姓名&idcard=身份证号
            CloseableHttpClient httpclient = HttpClients.createDefault();

            String param = "key="+realNameAuthProperties.getKey()+"&name="+realName+"&idcard="+idCard;
            HttpPost httpPost = new HttpPost("http://api.chinadatapay.com/communication/personal/1882"+"?"+param);
            String uuid = UUID.randomUUID().toString();
            userRealnameAuthRecordDAO.insert(uuid,realName,idCard);
            CloseableHttpResponse response2 = httpclient.execute(httpPost);
            LOG.info("数据宝实名认证{}:姓名[{}],身份证[{}],请求开始",uuid,realName,idCard);
            try {
                StatusLine statusLine = response2.getStatusLine();
                if (200 != statusLine.getStatusCode()){
                    LOG.error("数据宝实名认证第三方服务异常,响应返回[{}]",statusLine);
                    throw new RuntimeException("第三方服务异常!");
                }
                HttpEntity entity2 = response2.getEntity();
                InputStream content = entity2.getContent();
                String string = IOUtils.toString(content, Charset.forName("UTF-8"));
                LOG.info("数据宝实名认证{}:姓名[{}],身份证[{}],返回结果:{}",uuid,realName,idCard,string);
                JSONObject jsonObject = JSONObject.parseObject(string);
                String code = jsonObject.getString("code");
                String data = jsonObject.getString("data");
                boolean success = false;
                if (code!=null && data!=null && "10000".equals(code)&& data.contains("1")&& data.contains("result")){
                    success =true;
                }
                userRealnameAuthRecordDAO.updateResponse(uuid,success?1:2,string);
                return success;
            } finally {
                response2.close();
            }
        }finally {
            redisLock.unLock(redisKey);
        }

    }
}
