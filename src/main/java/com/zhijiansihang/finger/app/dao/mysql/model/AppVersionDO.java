package com.zhijiansihang.finger.app.dao.mysql.model;

import java.io.Serializable;
import java.util.Date;

public class AppVersionDO implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * app名称
     */
    private String appName;

    /**
     * 系统平台,ios,android
     */
    private String platform;

    /**
     * 版本编码，整数
     */
    private Integer versionCode;

    /**
     * 版本号，如1.0.1
     */
    private String versionName;

    /**
     * 最低兼容版本编码，整数
     */
    private Integer minVersionCode;

    /**
     * 更新提示标题
     */
    private String updateTitle;

    /**
     * 更新提示内容
     */
    private String updateContent;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新状态，1可用，-1表示不可用版本，审核中，不提示更新
     */
    private String updateStatus;

    /**
     * 更新包下载地址
     */
    private String updateUrl;

    /**
     * app_version
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * app名称
     * @return app_name app名称
     */
    public String getAppName() {
        return appName;
    }

    /**
     * app名称
     * @param appName app名称
     */
    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    /**
     * 系统平台,ios,android
     * @return platform 系统平台,ios,android
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * 系统平台,ios,android
     * @param platform 系统平台,ios,android
     */
    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    /**
     * 版本编码，整数
     * @return version_code 版本编码，整数
     */
    public Integer getVersionCode() {
        return versionCode;
    }

    /**
     * 版本编码，整数
     * @param versionCode 版本编码，整数
     */
    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

    /**
     * 版本号，如1.0.1
     * @return version_name 版本号，如1.0.1
     */
    public String getVersionName() {
        return versionName;
    }

    /**
     * 版本号，如1.0.1
     * @param versionName 版本号，如1.0.1
     */
    public void setVersionName(String versionName) {
        this.versionName = versionName == null ? null : versionName.trim();
    }

    /**
     * 最低兼容版本编码，整数
     * @return min_version_code 最低兼容版本编码，整数
     */
    public Integer getMinVersionCode() {
        return minVersionCode;
    }

    /**
     * 最低兼容版本编码，整数
     * @param minVersionCode 最低兼容版本编码，整数
     */
    public void setMinVersionCode(Integer minVersionCode) {
        this.minVersionCode = minVersionCode;
    }

    /**
     * 更新提示标题
     * @return update_title 更新提示标题
     */
    public String getUpdateTitle() {
        return updateTitle;
    }

    /**
     * 更新提示标题
     * @param updateTitle 更新提示标题
     */
    public void setUpdateTitle(String updateTitle) {
        this.updateTitle = updateTitle == null ? null : updateTitle.trim();
    }

    /**
     * 更新提示内容
     * @return update_content 更新提示内容
     */
    public String getUpdateContent() {
        return updateContent;
    }

    /**
     * 更新提示内容
     * @param updateContent 更新提示内容
     */
    public void setUpdateContent(String updateContent) {
        this.updateContent = updateContent == null ? null : updateContent.trim();
    }

    /**
     * 更新时间
     * @return update_time 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 更新状态，1可用，-1表示不可用版本，审核中，不提示更新
     * @return update_status 更新状态，1可用，-1表示不可用版本，审核中，不提示更新
     */
    public String getUpdateStatus() {
        return updateStatus;
    }

    /**
     * 更新状态，1可用，-1表示不可用版本，审核中，不提示更新
     * @param updateStatus 更新状态，1可用，-1表示不可用版本，审核中，不提示更新
     */
    public void setUpdateStatus(String updateStatus) {
        this.updateStatus = updateStatus == null ? null : updateStatus.trim();
    }

    /**
     * 更新包下载地址
     * @return update_url 更新包下载地址
     */
    public String getUpdateUrl() {
        return updateUrl;
    }

    /**
     * 更新包下载地址
     * @param updateUrl 更新包下载地址
     */
    public void setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl == null ? null : updateUrl.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appName=").append(appName);
        sb.append(", platform=").append(platform);
        sb.append(", versionCode=").append(versionCode);
        sb.append(", versionName=").append(versionName);
        sb.append(", minVersionCode=").append(minVersionCode);
        sb.append(", updateTitle=").append(updateTitle);
        sb.append(", updateContent=").append(updateContent);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateStatus=").append(updateStatus);
        sb.append(", updateUrl=").append(updateUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}