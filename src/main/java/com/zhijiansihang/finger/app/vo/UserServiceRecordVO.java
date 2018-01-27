package com.zhijiansihang.finger.app.vo;

import java.util.Date;

/**
 * Created by paul on 2018/1/27.
 */
public class UserServiceRecordVO {
    private String logo;
    private String realName;
    /**
     * 1:为咨询2:预约
     */
    private Byte serviceType;

    public Byte getServiceType() {
        return serviceType;
    }

    public void setServiceType(Byte serviceType) {
        this.serviceType = serviceType;
    }

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private Date createTime;

    @Override
    public String toString() {
        return "UserServiceRecordVO{" +
                "logo='" + logo + '\'' +
                ", realName='" + realName + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
