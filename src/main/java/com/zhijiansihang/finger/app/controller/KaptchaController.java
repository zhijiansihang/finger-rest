package com.zhijiansihang.finger.app.controller;


import com.zhijiansihang.finger.app.sharing.kaptcha.KaptchaTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author paul
 * @description
 * @date 2018/1/3
 */
@RestController
public class KaptchaController {
    @Autowired
    private KaptchaTools kaptchaTools;

    @RequestMapping("/kaptcha/create")
    public void createKaptcha(HttpServletResponse httpServletResponse) throws Exception {
        kaptchaTools.create(httpServletResponse);
    }

}
