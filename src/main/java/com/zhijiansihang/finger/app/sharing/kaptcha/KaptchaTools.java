package com.zhijiansihang.finger.app.sharing.kaptcha;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.zhijiansihang.finger.app.constant.ConfigConsts.KAPTCHA_TOKEN;


/**
 * Created by paul on 2017/12/30.
 */
@Component
public class KaptchaTools {

    private static final Logger logger = LoggerFactory.getLogger(KaptchaTools.class);
    @Autowired
    DefaultKaptcha defaultKaptcha;
    @Autowired
    RedisTemplate<String,String> redisTemplate;

    private static final String ROOT = "/";

    public void create(HttpServletResponse httpServletResponse) throws IOException {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();

        //生产验证码字符串并保存到session中
        String createText = defaultKaptcha.createText();
        BufferedImage challenge = defaultKaptcha.createImage(createText);
        ImageIO.write(challenge, "jpg", jpegOutputStream);
        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        String string = UUID.randomUUID().toString();
//        Cookie cookie = new Cookie(KAPTCHA_TOKEN, string);
//        cookie.setMaxAge(Integer.MAX_VALUE);
//        cookie.setPath(ROOT);
//        httpServletResponse.addCookie(cookie);
        httpServletResponse.setHeader(KAPTCHA_TOKEN,string);

        redisTemplate.opsForValue().set(KAPTCHA_TOKEN+string,createText);
        redisTemplate.expire(KAPTCHA_TOKEN+string,5, TimeUnit.MINUTES);

        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream =
                httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    /**
     * 校验图形验证码
     * @param kaptchaCode 如果为空，从reques中取名称为kaptchaCode
     * @return
     */
    public boolean check(String kaptchaCodeKey,String kaptchaCode){
        if (kaptchaCode==null || kaptchaCode.length() == 0){
           return false;
        }
        if (kaptchaCodeKey==null || kaptchaCodeKey.length() == 0){
           return false;
        }

        String rightCode = redisTemplate.opsForValue().get(KAPTCHA_TOKEN + kaptchaCodeKey);
        if (rightCode!=null){
            redisTemplate.delete(KAPTCHA_TOKEN + kaptchaCodeKey);
        }

        if (kaptchaCode.equals(rightCode)){
            return true;
        }
        return false;
    }
}
