package com.zhijiansihang.finger.app.service;


import com.google.common.collect.Sets;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.app.dao.mysql.mapper.LoanDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.LoanDO;
import com.zhijiansihang.finger.app.dao.mysql.model.LoanDOExample;
import com.zhijiansihang.finger.app.tool.Page;
import com.zhijiansihang.finger.app.vo.LoanVO;
import com.zhijiansihang.sys.entity.Role;
import com.zhijiansihang.sys.exception.EditDomainException;
import com.zhijiansihang.sys.exception.ValidationException;
import com.zhijiansihang.sys.util.MD5;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class LoanService {
    private static Logger logger = LoggerFactory.getLogger(LoanService.class);

    @Autowired
    private LoanDAO loanDAO;

    /**
     * 标的 分页列表
     *
     * @param loanVO
     * @return
     */
    public Page findLoanPage(LoanVO loanVO) {
        logger.info("分页标的 列表");

        Page<LoanVO,LoanDO> page = Page.create();
        page.setCurrentPage(loanVO.getCurrentPage());
        page.setPageSize(loanVO.getPageSize());
        page.setSelect(loanVO);
        // 条件
        LoanDOExample example = new LoanDOExample();
        LoanDOExample.Criteria criteria = example.createCriteria();
        if(loanVO.getLoanId() != null){
            criteria.andLoanIdEqualTo(loanVO.getLoanId());
        }
        if(StringUtils.isNotEmpty(loanVO.getTitle())){
            criteria.andTitleLike(loanVO.getTitle());
        }
        if(loanVO.getProductType() != null){
            criteria.andProductTypeEqualTo(loanVO.getProductType());
        }
        if(loanVO.getLoanStatus() != null){
            criteria.andLoanStatusEqualTo(loanVO.getLoanStatus());
        }
//
//        if(loanVO.getRolesList().size() > 0){
//            criteria.andRolesIn(loanVO.getRolesList());
//        } else {
//            // 默认显示 投资人 个人理财师 机构理财师
//            loanVO.getRolesList().add((short) 1);
//            loanVO.getRolesList().add((short) 4);
//            loanVO.getRolesList().add((short) 5);
//            criteria.andRolesIn(loanVO.getRolesList());
//        }

        // 条数
        int countByLoanVO = loanDAO.countByExample(example);
        page.setRecordCount(countByLoanVO);
        if (countByLoanVO > 0 ){
//            example.setOrderByClause("loan_id desc");
            // 结果
            List<LoanDO> loanDOs = loanDAO.selectByExampleWithRowbounds(example, page.getRowBounds());
            page.setResults(loanDOs);
        }
        return page;
    }

    public Response getByLoanId(Long loanId) {
        return Response.success(loanDAO.selectByPrimaryKey(loanId));
    }

    public Response review(LoanVO loanVO, Long userId) {
        if(loanDAO.updateByPrimaryKeySelective(loanVO) <= 0)
            return Response.error("审核失败");
        return Response.success("审核成功");
    }


//    /**
//     * 标的 通过id获取
//     * @param loanId
//     * @return
//     */
//    public Response getByLoanId(Long loanId) {
//        return Response.success(loanDAO.selectByPrimaryKey(loanId));
//    }
//
//
//    /**
//     * 标的 通过手机获取
//     * @param mobile
//     * @return
//     */
//    public Response getByMobile(String mobile) {
//
//        LoanDOExample example = new LoanDOExample();
//        example.createCriteria().andMobileEqualTo(mobile);
//        List<LoanDO> loanDOS = loanDAO.selectByExample(example);
//
//        if (loanDOS.size() > 0) {
//            return Response.success(loanDOS.get(0));
//        }
//
//        return Response.success("");
//    }
//
//    /**
//     * 机构 根据Id获取
//     *
//     * @param loanId
//     * @return
//     */
//    public Response getInstitutionByLoanId(Long loanId) {
//
//        LoanVO loanVO = new LoanVO();
//        BeanUtils.copyProperties(loanDAO.selectByPrimaryKey(loanId), loanVO);
//        try {
//            loanService.findById(loanId).getLoanAuths().forEach(loanAuth -> {
//                loanVO.setAuthId(loanAuth.getAuthId());
//                loanVO.setAuthPass(loanAuth.getAuthPass());
//            });
//        } catch (EditDomainException e) {
//            e.printStackTrace();
//            return Response.error("查询异常");
//        }
//
//        return Response.success(loanVO);
//    }
//
//    /**
//     * 机构 添加
//     *
//     * @param loanVO
//     * @param admLoanId
//     * @throws ValidationException
//     */
//    @Transactional
//    public void institutionAdd(LoanVO loanVO, String admLoanId) throws ValidationException {
//        String enPass = MD5.encodeByMd5AndSalt(loanVO.getAuthPass());
//
//        loanVO.setPasswd(enPass);
//        loanVO.setCreateTime(new Date());
//        loanDAO.insert(loanVO);
//
////        LoanDO loanDO = loanDAO.selectByPrimaryKey(loanVO.getLoanId());
//        com.zhijiansihang.sys.vo.LoanVO admLoanVo = new com.zhijiansihang.sys.vo.LoanVO();
//        admLoanVo.setAuthId(loanVO.getAuthId());
//        admLoanVo.setAuthPass(enPass);
//        admLoanVo.setId(loanVO.getLoanId());
//        admLoanVo.setPhone(loanVO.getMobile());
//        // 机构角色
//        Role role = new Role();
//        role.setId(2l);
//        admLoanVo.setRoleSet(Sets.newHashSet(role));
//
//        loanService.saveLoan(admLoanVo, admLoanId);
//    }
//
//    @Transactional
//    public void institutionDelete(LoanVO loanVO) {
//        loanDAO.deleteByPrimaryKey(loanVO.getLoanId());
////        loanService.delete(loanVO.getLoanId());
//        // 理财师转变为投资人
//
//        // 结标
//    }
}
