package com.zhijiansihang.finger.app.controller;


import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.app.service.CmsService;
import com.zhijiansihang.finger.app.service.FingerUserService;
import com.zhijiansihang.finger.app.vo.CmsVO;
import com.zhijiansihang.finger.app.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description
 * @date 2018/1/3
 */
@RestController
@RequestMapping("/user")
public class FingerUserController {
    private static final Logger logger = LoggerFactory.getLogger(FingerUserController.class);


    @Autowired
    private FingerUserService fingerUserService;

    /**
     *  cms分页
     * @return
     */
    @RequestMapping(value = "/page")
    @ResponseBody
    public Response page(@RequestBody UserVO userVO) {
        return Response.success(fingerUserService.findUserPage(userVO));
    }

    /**
     *  根据Id获取
     * @return
     */
    @RequestMapping(value = "/get")
    @ResponseBody
    public Response save(@RequestBody UserVO userVO) {
        return fingerUserService.getByUserId(userVO.getUserId());
    }


}
