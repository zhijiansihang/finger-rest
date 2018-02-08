package com.zhijiansihang.finger.app.vo;
import com.zhijiansihang.finger.app.dao.mysql.model.LoanDO;

/**
 *
 */
public class LoanVO extends LoanDO{

    private static final long serialVersionUID = -5228484640414835579L;

    public int currentPage;

    public int pageSize;



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

}
