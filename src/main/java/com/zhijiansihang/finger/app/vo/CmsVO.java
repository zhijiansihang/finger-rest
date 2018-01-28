package com.zhijiansihang.finger.app.vo;

import com.zhijiansihang.finger.app.dao.mysql.model.CmsDO;

/**
 * Created by paul on 2018/1/14.
 */
public class CmsVO extends CmsDO{

    public int currentPage;

    public int pageSize;

    private String startDate;

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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    private String endDate;
}
