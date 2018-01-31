package com.zhijiansihang.finger.app.controller;


import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.app.service.DemandService;
import com.zhijiansihang.finger.app.service.FingerUserService;
import com.zhijiansihang.finger.app.vo.UserVO;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description
 * @date 2018/1/3
 */
@RestController
@RequestMapping("/demand")
public class DemandController {
    private static final Logger logger = LoggerFactory.getLogger(DemandController.class);


    @Autowired
    private DemandService demandService;

    /**
     *  用户需求列表
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Response page(@Param("userId") Long userId) {
        return Response.success(demandService.findByUserId(userId));
    }

}
