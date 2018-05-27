package com.zhijiansihang.finger.app.controller;


import com.zhijiansihang.common.ComParams;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.app.service.FingerUserService;
import com.zhijiansihang.finger.app.vo.UserVO;
import com.zhijiansihang.gateway.security.core.JwtUserDetails;
import com.zhijiansihang.sys.entity.User;
import com.zhijiansihang.sys.exception.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     *  登录用户
     * @return
     */
    @RequestMapping(value = "/loginuser")
    @ResponseBody
    public Response loginUser() {
        JwtUserDetails principal = (JwtUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return fingerUserService.getByUserId(principal.getId());
    }
    /**
     *  用户 根据Id获取
     * @return
     */
    @RequestMapping(value = "/reset")
    @ResponseBody
    public Response reset(@RequestBody UserVO userVO) throws ValidationException {
        JwtUserDetails principal = (JwtUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return fingerUserService.reset(userVO.getUserId(), principal.getId());
    }
    /**
     *  用户 分页
     * @return
     */
    @RequestMapping(value = "/page")
    @ResponseBody
    public Response page(@RequestBody UserVO userVO) {
        return Response.success(fingerUserService.findUserPage(userVO));
    }

    /**
     *  用户 根据Id获取
     * @return
     */
    @RequestMapping(value = "/get")
    @ResponseBody
    public Response get(@RequestBody UserVO userVO) {
        return fingerUserService.getByUserId(userVO.getUserId());
    }

    /**
     *  用户 根据Id获取
     * @return
     */
    @RequestMapping(value = "/get/mobile")
    @ResponseBody
    public Response getByMobile(@RequestBody UserVO userVO) {
        return fingerUserService.getByMobile(userVO.getMobile());
    }

    /**
     *  理财师 分页
     * @return
     */
    @RequestMapping(value = "/fb/page")
    @ResponseBody
    public Response fbPage(@RequestBody UserVO userVO) {
        JwtUserDetails principal = (JwtUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return Response.success(fingerUserService.findUserFbPage(userVO, principal.getUsername(), principal.getId()));
    }

    /**
     *  理财师 分页
     * @return
     */
    @RequestMapping(value = "/fb/list")
    @ResponseBody
    public Response fbList(@RequestBody UserVO userVO) {
        JwtUserDetails principal = (JwtUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return Response.success(fingerUserService.findUserFbList(userVO, principal.getUsername(), principal.getId()));
    }

    /**
     *  理财师 根据Id获取
     * @return
     */
    @RequestMapping(value = "/fb/get")
    @ResponseBody
    public Response fbGet(@RequestBody UserVO userVO) {
        return fingerUserService.getFbByUserId(userVO.getUserId());
    }

    /**
     *  理财师 根据Id获取
     * @return
     */
    @RequestMapping(value = "/fb/get/users")
    @ResponseBody
    public Response fbGetByUserIds(@RequestBody UserVO userVO) {
        return fingerUserService.getFbByUserIds(userVO.getUserIds());
    }

    /**
     *  理财师 添加
     * @return
     */
    @RequestMapping(value = "/fb/add")
    @ResponseBody
    public Response fbAdd(@RequestBody UserVO userVO) {
//        JwtUserDetails principal = (JwtUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        userVO.setInstitutionUserId(principal.getId());
//        userVO.setInstitutionName(principal.getUsername());
        return fingerUserService.addFb(userVO);
    }



    /**
     *  机构 分页
     * @return
     */
    @RequestMapping(value = "/institution/page")
    @ResponseBody
    public Response institutionPage(@RequestBody UserVO userVO) {
        return Response.success(fingerUserService.findUserInstitutionPage(userVO));
    }

    /**
     *  机构 根据Id获取
     * @return
     */
    @RequestMapping(value = "/institution/get")
    @ResponseBody
    public Response institutionGet(@RequestBody UserVO userVO) {
        return fingerUserService.getInstitutionByUserId(userVO.getUserId());
    }

    /**
     * 机构 添加
     * @param userId
     * @param userVO
     * @return
     * @throws ValidationException
     */
    @RequestMapping(value = "/institution/add", method = RequestMethod.POST)
    public Response institutionAdd(@Param(ComParams.X_USERID) String userId, @RequestBody UserVO userVO) throws ValidationException {
        return fingerUserService.institutionAdd(userVO,userId);
    }

    /**
     * 机构 添加
     * @param userVO
     * @return
     * @throws ValidationException
     */
    @RequestMapping(value = "/institution/delete", method = RequestMethod.POST)
    public Response institutionDelete(@RequestParam(ComParams.X_USERID)Long userId, @RequestBody UserVO userVO) throws ValidationException {
        fingerUserService.institutionDelete(userVO, userId);
        return Response.success("删除成功");
    }


    /**
     *  机构 所有机构
     * @return
     */
    @RequestMapping(value = "/institution/list")
    @ResponseBody
    public Response institutionList() {
        return fingerUserService.getInstitutionList();
    }


}
