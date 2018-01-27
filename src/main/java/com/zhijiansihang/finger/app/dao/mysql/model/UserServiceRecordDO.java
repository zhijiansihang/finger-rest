package com.zhijiansihang.finger.app.dao.mysql.model;

import java.io.Serializable;
import java.util.Date;

public class UserServiceRecordDO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 用户id谁服务
     */
    private Long userId;

    /**
     * 被服务用户id
     */
    private Long personUserId;

    /**
     * 1:为咨询2:预约
     */
    private Byte serviceType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * user_service_record
     */
    private static final long serialVersionUID = 1L;

    /**
     * id
     * @return id id
     */
    public Long getId() {
        return id;
    }

    /**
     * id
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 用户id谁服务
     * @return user_id 用户id谁服务
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户id谁服务
     * @param userId 用户id谁服务
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 被服务用户id
     * @return person_user_id 被服务用户id
     */
    public Long getPersonUserId() {
        return personUserId;
    }

    /**
     * 被服务用户id
     * @param personUserId 被服务用户id
     */
    public void setPersonUserId(Long personUserId) {
        this.personUserId = personUserId;
    }

    /**
     * 1:为咨询0:预约
     * @return service_type 1:为咨询0:预约
     */
    public Byte getServiceType() {
        return serviceType;
    }

    /**
     * 1:为咨询0:预约
     * @param serviceType 1:为咨询0:预约
     */
    public void setServiceType(Byte serviceType) {
        this.serviceType = serviceType;
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
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", personUserId=").append(personUserId);
        sb.append(", serviceType=").append(serviceType);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}