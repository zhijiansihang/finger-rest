package com.zhijiansihang.finger.app.service;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.app.constant.LoanConsts;
import com.zhijiansihang.finger.app.constant.UserConsts;
import com.zhijiansihang.finger.app.dao.mysql.mapper.*;
import com.zhijiansihang.finger.app.dao.mysql.model.*;
import com.zhijiansihang.finger.app.tool.Page;
import com.zhijiansihang.finger.app.vo.UserVO;
import com.zhijiansihang.sys.entity.Role;
import com.zhijiansihang.sys.exception.EditDomainException;
import com.zhijiansihang.sys.exception.ValidationException;
import com.zhijiansihang.sys.service.UserAuthService;
import com.zhijiansihang.sys.service.UserService;
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
import java.util.Map;

@Service
public class FingerUserService {
    private static Logger logger = LoggerFactory.getLogger(FingerUserService.class);

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserFinanceDetailDAO userFinanceDetailDAO;

    @Autowired
    private UserInstitutionDetailDAO userInstitutionDetailDAO;

    @Autowired
    private UserAuthService userAuthService; // 若拆分系统改为远程调用

    @Autowired
    private UserService userService; // 若拆分系统改为远程调用
    @Autowired
    LoanInvestorFinanceDAO loanInvestorFinanceDAO;

    @Autowired
    LoanFinanceDAO loanFinanceDAO;

    @Autowired
    UserFriendDAO userFriendDAO;
    @Autowired
    LoanDAO loanDAO;
    /**
     * 用户 分页列表
     *
     * @param userVO
     * @return
     */
    public Page findUserPage(UserVO userVO) {
        logger.info("分页用户 列表");

        Page<UserVO,UserVO> page = Page.create();
        page.setCurrentPage(userVO.getCurrentPage());
        page.setPageSize(userVO.getPageSize());
        page.setSelect(userVO);
        // 条件
        UserDOExample example = new UserDOExample();
        UserDOExample.Criteria criteria = example.createCriteria();
        if(userVO.getUserId() != null){
            criteria.andUserIdEqualTo(userVO.getUserId());
        }
        if(StringUtils.isNotEmpty(userVO.getMobile())){
            criteria.andMobileEqualTo(userVO.getMobile());
        }

        if(userVO.getRolesList().size() > 0 && userVO.getRolesList().get(0) != null){
            criteria.andRolesIn(userVO.getRolesList());
        } else {
            // 默认显示 投资人 个人理财师 机构理财师
            userVO.getRolesList().add((short) 3);
            userVO.getRolesList().add((short) 4);
            criteria.andRolesIn(userVO.getRolesList());
        }
        example.setOrderByClause("create_time desc");
        // 条数
        int countByUserVO = userDAO.countByExample(example);
        page.setRecordCount(countByUserVO);
        if (countByUserVO > 0 ){
//            example.setOrderByClause("user_id desc");
            // 结果
            List<UserDO> userDOs = userDAO.selectByExampleWithRowbounds(example, page.getRowBounds());
            List<UserVO> userVOs = Lists.newArrayList();
            userDOs.forEach(userDO -> {
                UserVO newUserVO = new UserVO();
                BeanUtils.copyProperties(userDO, newUserVO);
                newUserVO.setInvestTime(loanInvestorFinanceDAO.countInvestTime(userDO.getUserId()));
                newUserVO.setTotalAmount(loanInvestorFinanceDAO.countTotalAmount(userDO.getUserId()));
                if (newUserVO.getInstitutionUserId() != null){
                    UserDO institutionUser = userDAO.selectByPrimaryKey(newUserVO.getInstitutionUserId());
                    if (institutionUser != null){
                        newUserVO.setInstitutionName(institutionUser.getNickName());
                    }
                }
                userVOs.add(newUserVO);
            });

            page.setResults(userVOs);
        }
        return page;
    }


    /**
     * 用户 通过id获取
     * @param userId
     * @return
     */
    public Response getByUserId(Long userId) {
        return Response.success(userDAO.selectByPrimaryKey(userId));
    }


    /**
     * 用户 通过手机获取
     * @param mobile
     * @return
     */
    public Response getByMobile(String mobile) {

        UserDOExample example = new UserDOExample();
        example.createCriteria().andMobileEqualTo(mobile);
        List<UserDO> userDOS = userDAO.selectByExample(example);

        if (userDOS.size() > 0) {
            return Response.success(userDOS.get(0));
        }

        return Response.success("");
    }

    /**
     * 理财师 分页列表
     *
     * @param userVO
     * @return
     */
    public Page findUserFbPage(UserVO userVO, String loginName, Long loginUserId) {
        logger.info("分页用户 列表");
        Page<UserVO,UserVO> page = Page.create();
        page.setCurrentPage(userVO.getCurrentPage());
        page.setPageSize(userVO.getPageSize());
        page.setSelect(userVO);
        // 条件
        UserDOExample example = new UserDOExample();
        UserDOExample.Criteria criteria = example.createCriteria();

        userVO.getRolesList().add((short) 4);
//        userVO.getRolesList().add((short) 5);
        criteria.andRolesIn(userVO.getRolesList());
        if(userVO.getUserId() != null){
            criteria.andUserIdEqualTo(userVO.getUserId());
        }
        if(StringUtils.isNotEmpty(userVO.getMobile())){
            criteria.andMobileEqualTo(userVO.getMobile());
        }

        if(userVO.getInstitutionUserId() != null){
            criteria.andInstitutionUserIdEqualTo(userVO.getInstitutionUserId());
        }

        if (!loginName.equals("admin")){
            criteria.andInstitutionUserIdEqualTo(loginUserId);
        }
        example.setOrderByClause("create_time desc");
        // 条数
        int countByUserVO = userDAO.countByExample(example);
        page.setRecordCount(countByUserVO);
        if (countByUserVO > 0 ){
            // 排序
//            example.setOrderByClause("user_id desc");
            // 结果
            List<UserDO> userDOs = userDAO.selectByExampleWithRowbounds(example, page.getRowBounds());
            List<UserVO> userVOs = Lists.newArrayList();
            userDOs.forEach(userDO -> {
                UserVO newUserVO = new UserVO();
                BeanUtils.copyProperties(userDO, newUserVO);
                newUserVO.setInvestTime(loanInvestorFinanceDAO.countByFinanceUserid(userDO.getUserId()));
                newUserVO.setTotalAmount(loanInvestorFinanceDAO.countTotalAmountByFinanceUserid(userDO.getUserId()));
//                if (newUserVO.getInstitutionUserId() != null){
//                    newUserVO.setInstitutionName(userDAO.selectByPrimaryKey(newUserVO.getInstitutionUserId()).getNickName());
//                }
                if (newUserVO.getInstitutionUserId() != null){
                    UserDO institutionUser = userDAO.selectByPrimaryKey(newUserVO.getInstitutionUserId());
                    if (institutionUser != null){
                        newUserVO.setInstitutionName(institutionUser.getNickName());
                    }
                }
                userVOs.add(newUserVO);
            });

            page.setResults(userVOs);
        }
        return page;
    }

    public List<UserVO> findUserFbList(UserVO userVO, String loginName, Long loginUserId) {
        UserDOExample example = new UserDOExample();
        UserDOExample.Criteria criteria = example.createCriteria();
        if (!loginName.equals("admin")){
            criteria.andInstitutionUserIdEqualTo(loginUserId);
        } else if (userVO.getInstitutionUserId() != null){
            criteria.andInstitutionUserIdEqualTo(userVO.getInstitutionUserId());
        }
        example.setOrderByClause("create_time desc");
        userVO.getRolesList().add((short) 4);
//        userVO.getRolesList().add((short) 5);
        criteria.andRolesIn(userVO.getRolesList());
        List<UserVO> userVOs = Lists.newArrayList();

        List<UserDO> userDOs =  userDAO.selectByExample(example);
        userDOs.forEach(userDO -> {
            UserVO newUserVO = new UserVO();
            BeanUtils.copyProperties(userDO, newUserVO);
            newUserVO.setInvestTime(loanInvestorFinanceDAO.countByFinanceUserid(userDO.getUserId()));
            userVOs.add(newUserVO);
        });

        return userVOs;
    }

    /**
     * 理财师 根据Id获取
     *
     * @param userId
     * @return
     */
    public Response getFbByUserId(Long userId) {
        Map<String,Object> root = Maps.newHashMap();
        root.put("user",userDAO.selectByPrimaryKey(userId));
        root.put("fb",userFinanceDetailDAO.selectByPrimaryKey(userId));

        root.put("userFriend", userFriendDAO.countByUserid(userId));
        root.put("fbSelling",loanFinanceDAO.countSellingLoanByFinanceUser(userId));
        root.put("fbSelled",loanFinanceDAO.countSelledLoanByFinanceUser(userId));
        root.put("fbService",loanInvestorFinanceDAO.countUserByFinanceUserid(userId));
        root.put("appointment",loanInvestorFinanceDAO.countByFinanceUserid(userId));
        return Response.success(root);
    }

    /**
     * 理财师 添加
     *
     * @param userVO
     * @return
     */
    @Transactional
    public Response addFb(UserVO userVO) {
        if (userFinanceDetailDAO.selectByPrimaryKey(userVO.getUserId()) == null){
            UserFinanceDetailDO userFinanceDetailDO = new UserFinanceDetailDO();
            userFinanceDetailDO.setCreateTime(new Date());
            userFinanceDetailDO.setUserId(userVO.getUserId());
            userFinanceDetailDAO.insertSelective(userFinanceDetailDO);
        }
        UserDO institution =  userDAO.selectByPrimaryKey(userVO.getInstitutionUserId());
        userVO.setRoles(UserConsts.UserRolesEnum.FINANCE.getRole().shortValue());
        userVO.setInstitutionName(institution.getNickName());
        if (userDAO.updateByPrimaryKeySelective(userVO) > 0)
            return Response.success("添加成功");
        return Response.error("添加理财师失败");

    }


    /**
     * 机构 分页列表
     *
     * @param userVO
     * @return
     */
    public Page findUserInstitutionPage(UserVO userVO) {
        logger.info("机构 分页列表");
        Page<UserVO,UserVO> page = Page.create();
        page.setCurrentPage(userVO.getCurrentPage());
        page.setPageSize(userVO.getPageSize());
        page.setSelect(userVO);
        // 条件
        UserDOExample example = new UserDOExample();
        UserDOExample.Criteria criteria = example.createCriteria();
        // 机构角色
        userVO.getRolesList().add((short) 2);
        criteria.andRolesIn(userVO.getRolesList());

        if(userVO.getUserId() != null){
            criteria.andUserIdEqualTo(userVO.getUserId());
        }
        if(StringUtils.isNotEmpty(userVO.getNickName())){
            criteria.andNickNameLike(userVO.getNickName());
        }
        if(userVO.getInstitutionName() != null){
            criteria.andInstitutionNameLike(userVO.getInstitutionName());
        }
        example.setOrderByClause("create_time desc");
        // 条数
        int countByUserVO = userDAO.countByExample(example);
        page.setRecordCount(countByUserVO);
        if (countByUserVO > 0 ){
            // 排序
//            example.setOrderByClause("user_id desc");
            // 结果
            List<UserDO> userDOs = userDAO.selectByExampleWithRowbounds(example, page.getRowBounds());

            List<UserVO> userVOs = Lists.newArrayList();
            userDOs.forEach(userDO -> {
                UserVO newUserVO = new UserVO();
                BeanUtils.copyProperties(userDO, newUserVO);
                newUserVO.setInvestTime(userDAO.countFinanceUserByInstitutionUserId(userDO.getUserId())); // 理财师 不想加字段了
                newUserVO.setTotalAmount(loanFinanceDAO.countLoanByInstitutionUserId(userDO.getUserId())); // 产品数量
                userVOs.add(newUserVO);
            });

            page.setResults(userVOs);
        }
        return page;
    }

    /**
     * 机构 根据Id获取
     *
     * @param userId
     * @return
     */
    public Response getInstitutionByUserId(Long userId) {

        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userDAO.selectByPrimaryKey(userId), userVO);

        try {
            userService.findById(userId).getUserAuths().forEach(userAuth -> {

                userVO.setAuthId(userAuth.getAuthId());
                userVO.setAuthPass(userAuth.getAuthPass());

            });
        } catch (EditDomainException e) {
            e.printStackTrace();
            return Response.error("查询异常");
        }

        return Response.success(userVO);
    }

    /**
     * 机构 添加
     *
     * @param userVO
     * @param admUserId
     * @throws ValidationException
     */
    @Transactional
    public Response institutionAdd(UserVO userVO, String admUserId) throws ValidationException {

        UserDOExample example = new UserDOExample();
        UserDOExample.Criteria criteria = example.createCriteria();
        criteria.andNickNameEqualTo(userVO.getNickName());
        List<UserDO> userDOS = userDAO.selectByExample(example);
        if(userDOS.size() > 0){
            return Response.error("机构名称已存在！");
        }

        UserDOExample example2 = new UserDOExample();
        UserDOExample.Criteria criteria2 = example2.createCriteria();
        criteria2.andMobileEqualTo(userVO.getMobile());
        List<UserDO> userDOS2 = userDAO.selectByExample(example2);
        if(userDOS2.size() > 0){
            return Response.error("联系方式已存在！");
        }

        // 验证用户账号已存在
        if(userAuthService.findByAuthId(userVO.getAuthId()) != null){
            return Response.error("后台账号已存在！");
        }

        String enPass = MD5.encodeByMd5AndSalt(userVO.getAuthPass());

        userVO.setIsNameAuth((byte)1);
        userVO.setPasswd(enPass);
        userVO.setIsFrozen((byte)0);
        userVO.setCreateTime(new Date());
        userVO.setIsRegisterJg((byte)0);
        userDAO.insert(userVO);

//        UserDO userDO = userDAO.selectByPrimaryKey(userVO.getUserId());
        com.zhijiansihang.sys.vo.UserVO admUserVo = new com.zhijiansihang.sys.vo.UserVO();
        admUserVo.setAuthId(userVO.getAuthId());
        admUserVo.setAuthPass(userVO.getAuthPass());
        admUserVo.setId(userVO.getUserId());
        admUserVo.setPhone(userVO.getMobile());
        // 机构角色
        Role role = new Role();
        role.setId(2l);
        admUserVo.setRoleSet(Sets.newHashSet(role));

        userService.saveUser(admUserVo, admUserId);

        if (userInstitutionDetailDAO.selectByPrimaryKey(userVO.getUserId()) == null){
            UserInstitutionDetailDO userInstitutionDetailDO = new UserInstitutionDetailDO();
            userInstitutionDetailDO.setCreateTime(new Date());
            userInstitutionDetailDO.setName(userVO.getNickName());
            userInstitutionDetailDO.setUserId(userVO.getUserId());
            userInstitutionDetailDO.setContactName(userVO.getRealName());
            userInstitutionDetailDO.setContactMobile(userVO.getMobile());
            userInstitutionDetailDO.setIsPersonal((byte)2);
            userInstitutionDetailDO.setIsDeleted((byte)0);
            userInstitutionDetailDAO.insertSelective(userInstitutionDetailDO);
        }

        return Response.success("添加成功");
    }

    @Transactional
    public void institutionDelete(UserVO userVO, Long loginUserId) throws ValidationException {
        userDAO.deleteByPrimaryKey(userVO.getUserId());

        userService.lockUser(loginUserId + "", userVO.getUserId());
//        userService.delete(userVO.getUserId());
        // 理财师转变为投资人
        UserDOExample example = new UserDOExample();
        UserDOExample.Criteria criteria = example.createCriteria();
        criteria.andInstitutionUserIdEqualTo(userVO.getUserId());
        userDAO.selectByExample(example).forEach( userDO -> {
            userDO.setRoles(UserConsts.UserRolesEnum.INVESTOR.getRole().shortValue());
            userDAO.updateByPrimaryKeySelective(userDO);
        });
        // 结标
        LoanDOExample loanDOExample = new LoanDOExample();
        LoanDOExample.Criteria loanDOCriterial = loanDOExample.createCriteria();
        loanDOCriterial.andInstitutionUserIdEqualTo(userVO.getUserId());
        loanDAO.selectByExample(loanDOExample).forEach(loanDO -> {
            loanDO.setLoanStatus(LoanConsts.LoanStatusEnum.LOAN_STATUS_END.getType());
            loanDAO.updateByPrimaryKeySelective(loanDO);
        });
    }


    public Response getFbByUserIds(List<Long> userIds) {
        UserDOExample example = new UserDOExample();
        UserDOExample.Criteria criteria = example.createCriteria();
        if (userIds != null && userIds.size()>0){
            criteria.andUserIdIn(userIds);
        } else {
            return Response.success(null);
        }
        return Response.success(userDAO.selectByExample(example));
    }

    public Response getInstitutionList() {
        UserDOExample example = new UserDOExample();
        UserDOExample.Criteria criteria = example.createCriteria();
        criteria.andRolesEqualTo((short)2);
        return Response.success(userDAO.selectByExample(example));
    }

    public Response reset(Long userId, Long loginUserId) throws ValidationException {
        UserDO user =  userDAO.selectByPrimaryKey(userId);
       String newPass =  user.getMobile().substring(7, 11) + "111111";
        userService.resetPwd(userId, newPass, loginUserId);
        return Response.success("修改成功！");
    }
}
