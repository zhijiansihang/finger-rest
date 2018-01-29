package com.zhijiansihang.finger.app.service;


import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDOExample;
import com.zhijiansihang.finger.app.tool.Page;
import com.zhijiansihang.finger.app.vo.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FingerUserService {
    private static Logger logger = LoggerFactory.getLogger(FingerUserService.class);

    @Autowired
    private UserDAO userDAO;

    public Page findUserPage(UserVO userVO) {
        logger.info("分页取cms 列表");

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

        if(userVO.getRoles() != null){
            criteria.andRolesEqualTo(userVO.getRoles());
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


    public Response getByUserId(Long userId) {
        return Response.success(userDAO.selectByPrimaryKey(userId));
    }
}
