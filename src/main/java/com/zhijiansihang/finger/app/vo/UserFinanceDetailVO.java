package com.zhijiansihang.finger.app.vo;

import com.zhijiansihang.finger.app.dao.mysql.model.UserFinanceDetailDO;

/**
 * Created by paul on 2018/1/27.
 */
public class UserFinanceDetailVO extends UserFinanceDetailDO {
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    private String logo;

    private String realName;
    /**
     * 机构名称
     */
    private String institutionName;


}
