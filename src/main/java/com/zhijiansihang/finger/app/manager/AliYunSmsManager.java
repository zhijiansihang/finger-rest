package com.zhijiansihang.finger.app.manager;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.zhijiansihang.finger.app.sharing.message.hanlders.AbstractSmsSendHanlder;
import com.zhijiansihang.finger.app.sharing.message.model.AliSms;
import com.zhijiansihang.finger.app.sharing.spring.ApplicationContextHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author paul
 * @description
 * @date 2018/1/11
 */
@Component
public class AliYunSmsManager {

    private static Logger logger = LoggerFactory.getLogger(AliYunSmsManager.class);
    static {
        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
    }
    /**
     * 产品名称:云通信短信API产品,开发者无需替换
     */
    static final String product = "Dysmsapi";
    /**
     * 产品域名,开发者无需替换
     */
    static final String domain = "dysmsapi.aliyuncs.com";


    public static SendSmsResponse sendSms(AliSms aliSms) throws ClientException {

        AliYunSmsProperties yunSmsProperties = ApplicationContextHelper.getBean(AliYunSmsProperties.class);
        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", yunSmsProperties.getAccessKeyId(), yunSmsProperties.getAccessKeySecret());
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(aliSms.getMobile());
        AliYunSmsProperties aliYunSmsProperties = ApplicationContextHelper.getBean(AliYunSmsProperties.class);
        //必填:短信签名-可在短信控制台中找到
        if (aliYunSmsProperties.getMessageSignature() !=null && aliYunSmsProperties.getMessageSignature().length()>0)
        {request.setSignName(aliYunSmsProperties.getMessageSignature());}
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(aliSms.getTemplateCode());
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam(JSON.toJSONString(aliSms.getTemplateParam()));

        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        //request.setOutId("yourOutId");

        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        logger.info("阿里短信请求[{}]:响应code=[{}],message=[{}],ali流水号=[{}]",aliSms
                ,sendSmsResponse.getCode()
                ,sendSmsResponse.getMessage()
                ,sendSmsResponse.getBizId()
        );
        return sendSmsResponse;
    }


    public static QuerySendDetailsResponse querySendDetails(String bizId) throws ClientException {
        AliYunSmsProperties yunSmsProperties = ApplicationContextHelper.getBean(AliYunSmsProperties.class);
        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", yunSmsProperties.getAccessKeyId(), yunSmsProperties.getAccessKeySecret());
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象
        QuerySendDetailsRequest request = new QuerySendDetailsRequest();
        //必填-号码
        request.setPhoneNumber("15000000000");
        //可选-流水号
        request.setBizId(bizId);
        //必填-发送日期 支持30天内记录查询，格式yyyyMMdd
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
        request.setSendDate(ft.format(new Date()));
        //必填-页大小
        request.setPageSize(10L);
        //必填-当前页码从1开始计数
        request.setCurrentPage(1L);

        //hint 此处可能会抛出异常，注意catch
        QuerySendDetailsResponse querySendDetailsResponse = acsClient.getAcsResponse(request);

        return querySendDetailsResponse;
    }
}
