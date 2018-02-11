package com.zhijiansihang.finger.app.service;


import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDAO;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserFinanceDetailDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDOExample;
import com.zhijiansihang.finger.app.tool.Page;
import com.zhijiansihang.finger.app.vo.UserVO;
import com.zhijiansihang.sys.entity.Role;
import com.zhijiansihang.sys.entity.UserAuth;
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
    private UserAuthService userAuthService; // 若拆分系统改为远程调用

    @Autowired
    private UserService userService; // 若拆分系统改为远程调用

    /**
     * 用户 分页列表
     *
     * @param userVO
     * @return
     */
    public Page findUserPage(UserVO userVO) {
        logger.info("分页用户 列表");

        Page<UserVO,UserDO> page = Page.create();
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

        if(userVO.getRolesList().size() > 0){
            criteria.andRolesIn(userVO.getRolesList());
        } else {
            // 默认显示 投资人 个人理财师 机构理财师
            userVO.getRolesList().add((short) 1);
            userVO.getRolesList().add((short) 4);
            userVO.getRolesList().add((short) 5);
            criteria.andRolesIn(userVO.getRolesList());
        }

        // 条数
        int countByUserVO = userDAO.countByExample(example);
        page.setRecordCount(countByUserVO);
        if (countByUserVO > 0 ){
//            example.setOrderByClause("user_id desc");
            // 结果
            List<UserDO> userDOs = userDAO.selectByExampleWithRowbounds(example, page.getRowBounds());
            page.setResults(userDOs);
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
    public Page findUserFbPage(UserVO userVO) {
        logger.info("分页用户 列表");
        Page<UserVO,UserDO> page = Page.create();
        page.setCurrentPage(userVO.getCurrentPage());
        page.setPageSize(userVO.getPageSize());
        page.setSelect(userVO);
        // 条件
        UserDOExample example = new UserDOExample();
        UserDOExample.Criteria criteria = example.createCriteria();

        userVO.getRolesList().add((short) 4);
        userVO.getRolesList().add((short) 5);
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

        // 条数
        int countByUserVO = userDAO.countByExample(example);
        page.setRecordCount(countByUserVO);
        if (countByUserVO > 0 ){
            // 排序
//            example.setOrderByClause("user_id desc");
            // 结果
            List<UserDO> userDOs = userDAO.selectByExampleWithRowbounds(example, page.getRowBounds());
            page.setResults(userDOs);
        }
        return page;
    }

    public List<UserDO> findUserFbList(UserVO userVO) {
        UserDOExample example = new UserDOExample();
        return userDAO.selectByExample(example);
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
        return Response.success(root);
    }

    /**
     * 理财师 添加
     *
     * @param userVO
     * @return
     */
    public Response addFb(UserVO userVO) {
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
        Page<UserVO,UserDO> page = Page.create();
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

        if(userVO.getInstitutionName() != null){
            criteria.andInstitutionNameLike(userVO.getInstitutionName());
        }

        // 条数
        int countByUserVO = userDAO.countByExample(example);
        page.setRecordCount(countByUserVO);
        if (countByUserVO > 0 ){
            // 排序
//            example.setOrderByClause("user_id desc");
            // 结果
            List<UserDO> userDOs = userDAO.selectByExampleWithRowbounds(example, page.getRowBounds());
            page.setResults(userDOs);
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
    public void institutionAdd(UserVO userVO, String admUserId) throws ValidationException {
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
        admUserVo.setAuthPass(enPass);
        admUserVo.setId(userVO.getUserId());
        admUserVo.setPhone(userVO.getMobile());
        // 机构角色
        Role role = new Role();
        role.setId(2l);
        admUserVo.setRoleSet(Sets.newHashSet(role));

        userService.saveUser(admUserVo, admUserId);
    }

    @Transactional
    public void institutionDelete(UserVO userVO) {
        userDAO.deleteByPrimaryKey(userVO.getUserId());
//        userService.delete(userVO.getUserId());
        // 理财师转变为投资人

        // 结标
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
}
