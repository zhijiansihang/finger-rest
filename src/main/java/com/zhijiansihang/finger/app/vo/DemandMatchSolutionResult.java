package com.zhijiansihang.finger.app.vo;

import org.apache.ibatis.annotations.Result;

/**
 * Created by paul on 2018/1/28.
 */
public class DemandMatchSolutionResult {
    private Long adoptCount;
    private Long friendCounts;
    private Long id;
    private String institutionName;
    private Byte isOperateSolution;
    private String logo;
    private String realName;
    private Long serialNumber;
    private Long solutionId;
    private Long solutionUserId;
    private String serviceDirection;

    public Long getDemandId() {
        return demandId;
    }

    public void setDemandId(Long demandId) {
        this.demandId = demandId;
    }

    public Long getSerialNumberDemand() {
        return serialNumberDemand;
    }

    public void setSerialNumberDemand(Long serialNumberDemand) {
        this.serialNumberDemand = serialNumberDemand;
    }

    private Long demandId;
    private Long serialNumberDemand;


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    private String nickName;

    public Long getAdoptCount() {
        return adoptCount;
    }

    public void setAdoptCount(Long adoptCount) {
        this.adoptCount = adoptCount;
    }

    public Long getFriendCounts() {
        return friendCounts;
    }

    public void setFriendCounts(Long friendCounts) {
        this.friendCounts = friendCounts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public Byte getIsOperateSolution() {
        return isOperateSolution;
    }

    public void setIsOperateSolution(Byte isOperateSolution) {
        this.isOperateSolution = isOperateSolution;
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

    public Long getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(Long solutionId) {
        this.solutionId = solutionId;
    }

    public Long getSolutionUserId() {
        return solutionUserId;
    }

    public void setSolutionUserId(Long solutionUserId) {
        this.solutionUserId = solutionUserId;
    }

    public String getServiceDirection() {
        return serviceDirection;
    }

    public void setServiceDirection(String serviceDirection) {
        this.serviceDirection = serviceDirection;
    }
}
