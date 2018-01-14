package com.shawn.finger.vo;

import com.shawn.finger.dao.mysql.model.CmsDO;
import com.shawn.finger.tool.Page;

/**
 * Created by paul on 2018/1/14.
 */
public class CmsVO extends CmsDO{
    public int currentPage;
    private String startDate;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
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
