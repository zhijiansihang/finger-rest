package com.zhijiansihang.finger.app.controller;

import com.zhijiansihang.common.ComParams;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.app.service.LoanService;
import com.zhijiansihang.finger.app.vo.CmsVO;
import com.zhijiansihang.finger.app.vo.LoanVO;
import com.zhijiansihang.sys.exception.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description
 * @date 2018/1/3
 */
@RestController
@RequestMapping("/loan")
public class LoanController {
    private static final Logger logger = LoggerFactory.getLogger(LoanController.class);


    @Autowired
    private LoanService loanService;

    /**
     *  标的 分页
     * @return
     */
    @RequestMapping(value = "/page")
    @ResponseBody
    public Response page(@RequestBody LoanVO loanVO) {
        return Response.success(loanService.findLoanPage(loanVO));
    }

    /**
     *  标的 根据Id获取
     * @return
     */
    @RequestMapping(value = "/public/get")
    @ResponseBody
    public Response publicGet(@RequestBody LoanVO loanVO) {
        return loanService.getByLoanId(loanVO.getLoanId());
    }
//
//    /**
//     *  标的 根据Id获取
//     * @return
//     */
//    @RequestMapping(value = "/private/get")
//    @ResponseBody
//    public Response privateGet(@RequestBody LoanVO loanVO) {
//        return loanService.getByUserId(loanVO.getLoanId());
//    }
//
     /**
     *  标的 审核
     * @return
     */
    @RequestMapping(value = "/review")
    @ResponseBody
    public Response review(@RequestParam(ComParams.X_USERID)Long userId, @RequestBody LoanVO loanVO) {
        return loanService.review(loanVO, userId);
    }
//
//    /**
//     *  标的 发布
//     * @return
//     */
//    @RequestMapping(value = "/publish")
//    @ResponseBody
//    public Response publish(@RequestParam(ComParams.X_USERID)Long userId, @RequestBody CmsVO cmsVO) {
//        return loanService.updateByPrimaryKeySelective(cmsVO, userId);
//    }
//
//
//
//    /**
//     *  标的 公募添加
//     * @return
//     */
//    @RequestMapping(value = "/public/add")
//    @ResponseBody
//    public Response publicAdd(@RequestBody LoanVO loanVO) {
//        return loanService.getByUserId(loanVO.getLoanId());
//    }
//
//    /**
//     *  标的 私募添加
//     * @return
//     */
//    @RequestMapping(value = "/private/add")
//    @ResponseBody
//    public Response privateAdd(@RequestBody LoanVO loanVO) {
//        return loanService.getByUserId(loanVO.getLoanId());
//    }
//
//    /**
//     * 标的 添加
//     * @param loanVO
//     * @return
//     * @throws ValidationException
//     */
//    @RequestMapping(value = "/delete", method = RequestMethod.POST)
//    public Response institutionDelete(@RequestBody LoanVO loanVO) throws ValidationException {
//        loanService.institutionDelete(loanVO);
//        return Response.success("删除成功");
//    }


}
