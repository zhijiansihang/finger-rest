package com.zhijiansihang.finger.app.vo;
import com.zhijiansihang.finger.app.dao.mysql.model.LoanDO;

import java.util.List;

/**
 *
 */
public class LoanVO extends LoanDO{

    private static final long serialVersionUID = -5228484640414835579L;

    public int currentPage;

    public int pageSize;

    public List<Short> status;


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

    public List<Short> getStatus() {
        return status;
    }

    public void setStatus(List<Short> status) {
        this.status = status;
    }
}
