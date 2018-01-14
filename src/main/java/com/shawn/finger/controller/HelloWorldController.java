package com.shawn.finger.controller;

import com.shawn.common.Response;
import com.shawn.finger.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    private static Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @Autowired
    UserService userService;
    /**
     * hello world
     *
     * @return
     */
    @RequestMapping("/world")
    @ResponseBody
    public Response world() {
        logger.info("hello world");
        return Response.success("aaa");
    }


}
