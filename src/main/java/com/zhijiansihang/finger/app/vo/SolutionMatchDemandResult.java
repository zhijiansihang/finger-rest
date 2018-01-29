package com.zhijiansihang.finger.app.vo;

import org.apache.ibatis.annotations.Result;

/**
 * Created by paul on 2018/1/28.
 */
public class SolutionMatchDemandResult {
    private Long demandId;
    private Long demandUserId;
    private Long id;

    public Byte getIsReadDemand() {
        return isReadDemand;
    }

    public void setIsReadDemand(Byte isReadDemand) {
        this.isReadDemand = isReadDemand;
    }

    private Byte isReadDemand;
    private String logo;
    private String realName;
    private Long serialNumber;

    public Long getDemandId() {
        return demandId;
    }

    public void setDemandId(Long demandId) {
        this.demandId = demandId;
    }

    public Long getDemandUserId() {
        return demandUserId;
    }

    public void setDemandUserId(Long demandUserId) {
        this.demandUserId = demandUserId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }


}
