package com.zhijiansihang.finger.app.vo;
import com.google.common.collect.Lists;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;

import java.util.List;

/**
 *
 */
public class UserVO extends UserDO{

    private static final long serialVersionUID = -5228484640414835579L;

    public int currentPage;

    public int pageSize;

    public String authId;

    public String authPass;

    public List<Short> rolesList = Lists.newArrayList();

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<Short> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Short> rolesList) {
        this.rolesList = rolesList;
    }


    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getAuthPass() {
        return authPass;
    }

    public void setAuthPass(String authPass) {
        this.authPass = authPass;
    }
}
