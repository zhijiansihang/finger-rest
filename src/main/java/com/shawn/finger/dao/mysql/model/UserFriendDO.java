package com.shawn.finger.dao.mysql.model;

import java.io.Serializable;
import java.util.Date;

public class UserFriendDO implements Serializable {
    /**
     * 好友关系表id
     */
    private Long id;

    /**
     * 我的用户id
     */
    private Long myUserId;

    /**
     * 用户id
     */
    private Long friendUserId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * user_friend
     */
    private static final long serialVersionUID = 1L;

    /**
     * 好友关系表id
     * @return id 好友关系表id
     */
    public Long getId() {
        return id;
    }

    /**
     * 好友关系表id
     * @param id 好友关系表id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 我的用户id
     * @return my_user_id 我的用户id
     */
    public Long getMyUserId() {
        return myUserId;
    }

    /**
     * 我的用户id
     * @param myUserId 我的用户id
     */
    public void setMyUserId(Long myUserId) {
        this.myUserId = myUserId;
    }

    /**
     * 用户id
     * @return friend_user_id 用户id
     */
    public Long getFriendUserId() {
        return friendUserId;
    }

    /**
     * 用户id
     * @param friendUserId 用户id
     */
    public void setFriendUserId(Long friendUserId) {
        this.friendUserId = friendUserId;
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

    /**
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", myUserId=").append(myUserId);
        sb.append(", friendUserId=").append(friendUserId);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}