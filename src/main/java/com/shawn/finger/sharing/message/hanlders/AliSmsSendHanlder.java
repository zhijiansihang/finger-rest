package com.shawn.finger.sharing.message.hanlders;


import com.shawn.finger.sharing.annotation.NotThreadSafe;
import com.shawn.finger.sharing.message.hanlders.AbstractSmsSendHanlder;
import com.shawn.finger.sharing.message.model.AliSms;
import com.shawn.finger.sharing.message.model.MessageInsertDatabase;
import com.shawn.finger.sharing.message.queue.TaskQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.shawn.finger.sharing.message.queue.QueueEnum.SMS_INSERTDB;


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
        if (aliSms instanceof MessageInsertDatabase) {
            TaskQueue.put(new SmsPutDbHandler(aliSms.insert()), SMS_INSERTDB);
        }
    }

    private boolean sendToAiyun(){
        /**
         * TODO
         */
        logger.info("短信发送往阿里云请求:"+ aliSms);
        return true;
    }
}
