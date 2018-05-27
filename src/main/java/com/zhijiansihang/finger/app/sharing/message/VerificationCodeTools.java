package com.zhijiansihang.finger.app.sharing.message;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.zhijiansihang.finger.app.sharing.SharingProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.zhijiansihang.finger.app.constant.ConfigConsts.KAPTCHA_TOKEN;
import static com.zhijiansihang.finger.app.constant.ConfigConsts.SMS_TOKEN;


/**
 * Created by paul on 2017/12/30.
 */
@Component
public class VerificationCodeTools {

    private static final Logger logger = LoggerFactory.getLogger(VerificationCodeTools.class);
    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Autowired
    SharingProperties sharingProperties;

    private static final String ROOT = "/";

    public static String getRandom4() {
        String random = getRandom(4);
        return random;
    }
    public static String getRandom(int place) {
        if (place <= 4) {
            place = 4;
        }
        final int length = place;
        StringBuilder num = new StringBuilder("");
        for (int i = 0; i < length; i++) {
            num = num.append((int) Math.floor(Math.random() * 9 + 1));
        }
        return num.toString();
    }

    public String generateCode(){
        boolean openThirdpartyService = sharingProperties.isOpenThirdpartyService();
        //验证码默认值
        String code = "1111";
        if (openThirdpartyService){
            code = getRandom4();
        }
        return code;
    }
    @Autowired
    SmsFacade smsFacade;
    public boolean send(String mobile) {
        if (!StringUtils.hasLength(mobile)){
            return false;

        }
        String createText = "";
        String ignoreMobiles = sharingProperties.getIgnoreMobiles();
        if (ignoreMobiles!= null && ignoreMobiles.contains(mobile)){
            createText = "1111";
        }else {
            createText = generateCode();
        }
        boolean openThirdpartyService = sharingProperties.isOpenThirdpartyService();
        if (!openThirdpartyService){
            redisTemplate.opsForValue().set(SMS_TOKEN + mobile, createText);
            redisTemplate.expire(SMS_TOKEN + mobile, 5, TimeUnit.MINUTES);
            logger.info("手机号[{}]短信验证码发送code={},挡板不发送",mobile,createText);
            return true;
        }
        logger.info("手机号[{}]短信验证码发送code={},开始请求第三方",mobile,createText);
        boolean verificationCode = smsFacade.sendVerificationCode(mobile, createText);
        if (verificationCode) {
            redisTemplate.opsForValue().set(SMS_TOKEN + mobile, createText);
            redisTemplate.expire(SMS_TOKEN + mobile, 5, TimeUnit.MINUTES);
        }
        return true;
    }

    /**
     * 短信图形验证码
     * @return
     */
    public boolean check(String mobile,String code){
        if (!StringUtils.hasLength(mobile)){
           return false;
        }
        if (!StringUtils.hasLength(code)){
           return false;
        }

        String rightCode = redisTemplate.opsForValue().get(SMS_TOKEN + mobile);
        if (rightCode!=null){
            redisTemplate.delete(SMS_TOKEN + mobile);
        }

        if (code.equals(rightCode)){
            return true;
        }
        return false;
    }
}
