package com.zhijiansihang.finger.app.service;


import com.google.common.collect.Lists;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.app.constant.LoanConsts;
import com.zhijiansihang.finger.app.dao.mysql.mapper.LoanDAO;
import com.zhijiansihang.finger.app.dao.mysql.mapper.LoanFinanceDAO;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.*;
import com.zhijiansihang.finger.app.tool.Page;
import com.zhijiansihang.finger.app.vo.LoanVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class LoanService {
    private static Logger logger = LoggerFactory.getLogger(LoanService.class);

    @Autowired
    private LoanDAO loanDAO;

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private LoanFinanceDAO loanFinanceDAO;

    private static final BigDecimal TEN_THOUSAND = new BigDecimal("10000");
    /**
     * 标的 分页列表
     *
     * @param loanVO
     * @param id
     * @return
     */
    public Page findLoanPage(LoanVO loanVO, Long id) {
        logger.info("分页标的 列表");

        Page<LoanVO,LoanVO> page = Page.create();
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
        if(loanVO.getStatus() != null && loanVO.getStatus().size() > 0){
            criteria.andLoanStatusIn(loanVO.getStatus());
        }
        if (id == (long)1){ //用户是admin
            if (loanVO.getInstitutionUserId() != null){
                criteria.andInstitutionUserIdEqualTo(loanVO.getInstitutionUserId());
            }
        } else {
            criteria.andInstitutionUserIdEqualTo(id);
        }
        example.setOrderByClause("create_time desc");
        // 条数
        int countByLoanVO = loanDAO.countByExample(example);
        page.setRecordCount(countByLoanVO);
        if (countByLoanVO > 0 ){
            // 结果
            List<LoanDO> loanDOS = loanDAO.selectByExampleWithRowbounds(example, page.getRowBounds());
            List<LoanVO> loanVOS = Lists.newArrayList();
            loanDOS.forEach(loanDO -> {
                LoanVO newLoanVO = new LoanVO();
                BeanUtils.copyProperties(loanDO, newLoanVO);
                newLoanVO.setCountFinanceUser(loanFinanceDAO.countFinanceUserByLoanId(loanDO.getLoanId()));
                if (newLoanVO.getInstitutionUserId() != null){
                    UserDO institutionUser = userDAO.selectByPrimaryKey(newLoanVO.getInstitutionUserId());
                    if (institutionUser != null){
                        newLoanVO.setInstitutionName(institutionUser.getNickName());
                    }
                }
                loanVOS.add(newLoanVO);
            });

            page.setResults(loanVOS);
        }
        return page;
    }


    public Response getByLoanId(Long loanId) {
        LoanFinanceDOExample example = new LoanFinanceDOExample();
        LoanFinanceDOExample.Criteria criteria = example.createCriteria();
        criteria.andLoanIdEqualTo(loanId);
        List<Long> financeUserIds = Lists.newArrayList();
        loanFinanceDAO.selectByExample(example).forEach(financeUser -> {
            financeUserIds.add(financeUser.getFinanceUserId());
        });
        LoanDO loanDo = loanDAO.selectByPrimaryKey(loanId);
        LoanVO loanVO = new LoanVO();
        BeanUtils.copyProperties(loanDo, loanVO);
        loanVO.setUserIds(financeUserIds);
        return Response.success(loanVO);
    }

    public Response review(LoanVO loanVO, Long userId) {
        loanVO.setUpdateTime(new Date());
        if(loanDAO.updateByPrimaryKeySelective(loanVO) <= 0)
            return Response.error("审核失败");
        return Response.success("审核成功");
    }

    public Response publish(LoanVO loanVO, Long userId) {
        loanVO.setReleaseTime(new Date());
        if(loanDAO.updateByPrimaryKeySelective(loanVO) <= 0)
            return Response.error("发布失败");
        return Response.success("发布成功");
    }

    @Transactional
    public Response publicAdd(LoanVO loanVO) {
        loanVO.setAmount(loanVO.getAmount().multiply(TEN_THOUSAND));
        loanVO.setCreateTime(new Date());
        loanVO.setManageRate(new BigDecimal("0.1"));
        loanVO.setIsDisplay((byte)0);
        loanVO.setLoanStatus(LoanConsts.LoanStatusEnum.LOAN_STATUS_REVIEW.getType());
        loanVO.setReserveAmount(new BigDecimal("0"));
        loanVO.setLoanType(LoanConsts.LoanTypeEnum.LOAN_TYPE_PUBLIC.getType());
        if(loanDAO.insert(loanVO) <= 0)
            return Response.error("添加失败");


        insertFinanceUser(loanVO.getUserIds(), loanVO.getLoanId());

        return Response.success("添加成功");
    }

    @Transactional
    public Response privateAdd(LoanVO loanVO) {
        loanVO.setBeginAmount(loanVO.getBeginAmount().multiply(TEN_THOUSAND));
        loanVO.setAmount(loanVO.getAmount().multiply(TEN_THOUSAND));
        loanVO.setCreateTime(new Date());
        loanVO.setIsDisplay((byte)0);
        loanVO.setLoanStatus(LoanConsts.LoanStatusEnum.LOAN_STATUS_REVIEW.getType());
        loanVO.setReserveAmount(new BigDecimal("0"));
        loanVO.setIsRateFloating((byte) 1);
        loanVO.setInterestRate(new BigDecimal("0"));
        loanVO.setLoanType(LoanConsts.LoanTypeEnum.LOAN_TYPE_PRIVATE.getType());
        loanVO.setProductType((short)4);
//        loanVO.setBrightSpot(loanVO.getSafeguardWay());
        if(loanDAO.insert(loanVO) <= 0)
            return Response.error("添加失败");
        insertFinanceUser(loanVO.getUserIds(), loanVO.getLoanId());

        return Response.success("添加成功");
    }


    @Transactional
    public Response publicEdit(Long userId, LoanVO loanVO) {
        loanVO.setAmount(loanVO.getAmount().multiply(TEN_THOUSAND));
        if(loanDAO.updateByPrimaryKeySelective(loanVO) <= 0)
            return Response.error("修改失败");


        insertFinanceUser(loanVO.getUserIds(), loanVO.getLoanId());

        return Response.success("修改成功");
    }
    @Transactional
    public Response privateEdit(Long userId, LoanVO loanVO) {
        loanVO.setAmount(loanVO.getAmount().multiply(TEN_THOUSAND));
        loanVO.setBeginAmount(loanVO.getBeginAmount().multiply(TEN_THOUSAND));
        if(loanDAO.updateByPrimaryKeySelective(loanVO) <= 0)
            return Response.error("修改失败");

        insertFinanceUser(loanVO.getUserIds(), loanVO.getLoanId());

        return Response.success("修改成功");
    }


    private void insertFinanceUser(List<Long> userIds, Long loanId){
        loanFinanceDAO.deleteByLoanId(loanId);
        userIds.forEach( financeUserId -> {
            LoanFinanceDO loanFinanceDO = new LoanFinanceDO();
            loanFinanceDO.setLoanId(loanId);
            loanFinanceDO.setFinanceUserId(financeUserId);
            loanFinanceDO.setIsDeleted((byte)0);
            loanFinanceDO.setCreateTime(new Date());
            loanFinanceDAO.insert(loanFinanceDO);
        });
    }

    public Response delete(LoanVO loanVO) {
        loanVO.setLoanStatus((short)400);
        if(loanDAO.updateByPrimaryKeySelective(loanVO) <= 0)
            return Response.error("删除失败");
        return Response.success("删除成功");
    }

}
