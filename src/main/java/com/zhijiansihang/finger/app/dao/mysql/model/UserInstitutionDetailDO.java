package com.zhijiansihang.finger.app.dao.mysql.model;

import java.io.Serializable;
import java.util.Date;

public class UserInstitutionDetailDO implements Serializable {
    /**
     * user表主键id
     */
    private Long userId;

    /**
     * 机构名称
     */
    private String name;

    /**
     * 机构联系人
     */
    private String contactName;

    /**
     * 机构联系人电话
     */
    private String contactMobile;

    /**
     * 是否个人机构 1:为个人机构 2:企业机构
     */
    private Byte isPersonal;

    /**
     * 是否删除 1:为删除 0:未删除
     */
    private Byte isDeleted;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * user_institution_detail
     */
    private static final long serialVersionUID = 1L;

    /**
     * user表主键id
     * @return user_id user表主键id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * user表主键id
     * @param userId user表主键id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 机构名称
     * @return name 机构名称
     */
    public String getName() {
        return name;
    }

    /**
     * 机构名称
     * @param name 机构名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 机构联系人
     * @return contact_name 机构联系人
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * 机构联系人
     * @param contactName 机构联系人
     */
    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    /**
     * 机构联系人电话
     * @return contact_mobile 机构联系人电话
     */
    public String getContactMobile() {
        return contactMobile;
    }

    /**
     * 机构联系人电话
     * @param contactMobile 机构联系人电话
     */
    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile == null ? null : contactMobile.trim();
    }

    /**
     * 是否个人机构 1:为个人机构 2:企业机构
     * @return is_personal 是否个人机构 1:为个人机构 2:企业机构
     */
    public Byte getIsPersonal() {
        return isPersonal;
    }

    /**
     * 是否个人机构 1:为个人机构 2:企业机构
     * @param isPersonal 是否个人机构 1:为个人机构 2:企业机构
     */
    public void setIsPersonal(Byte isPersonal) {
        this.isPersonal = isPersonal;
    }

    /**
     * 是否删除 1:为删除 0:未删除
     * @return is_deleted 是否删除 1:为删除 0:未删除
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * 是否删除 1:为删除 0:未删除
     * @param isDeleted 是否删除 1:为删除 0:未删除
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
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
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", name=").append(name);
        sb.append(", contactName=").append(contactName);
        sb.append(", contactMobile=").append(contactMobile);
        sb.append(", isPersonal=").append(isPersonal);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}