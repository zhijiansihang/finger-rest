package com.zhijiansihang.finger.app.sharing.message.hanlders;


import com.zhijiansihang.finger.app.dao.mysql.mapper.SmsDAO;
import com.zhijiansihang.finger.app.manager.AliYunSmsManager;
import com.zhijiansihang.finger.app.sharing.annotation.NotThreadSafe;
import com.zhijiansihang.finger.app.sharing.message.model.AliSms;
import com.zhijiansihang.finger.app.sharing.message.model.MessageInsertDatabase;
import com.zhijiansihang.finger.app.sharing.message.queue.TaskQueue;
import com.zhijiansihang.finger.app.sharing.spring.ApplicationContextHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.zhijiansihang.finger.app.sharing.message.queue.QueueEnum.SMS_INSERTDB;


/**
 *
 * @author: Paul Zhang
 * @date: 16:21 2017/12/27
 */
@NotThreadSafe
public class AliSmsSendHanlder extends AbstractSmsSendHanlder {

    private static Logger logger = LoggerFactory.getLogger(AliSmsSendHanlder.class);
    private AliSms aliSms;

    public AliSmsSendHanlder(AliSms sms) {
        this.aliSms = sms;
    }

    @Override
    protected String name() {
        return "阿里云";
    }

    @Override
    protected Object content() {
        return aliSms;
    }

    @Override
    public boolean send() {
        return sendToAiyun();
    }

    @Override
    protected void success() {
        super.success();
    }

    private boolean sendToAiyun(){
        /**
         * TODO
         */
        logger.info("短信发送往阿里云请求:"+ aliSms);
        try {
            AliYunSmsManager.sendSms(aliSms);
        }catch (Exception e){
            logger.error("短信发送往阿里云error:",e);
            return false;
        }

        return true;
    }
}
