package com.zhijiansihang.finger.app.dao.mysql.model;

import java.io.Serializable;
import java.util.Date;

public class UserFriendCountDO implements Serializable {
    /**
     * 我的用户id
     */
    private Long userId;

    /**
     * 好于数
     */
    private Long friendCounts;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * user_friend_count
     */
    private static final long serialVersionUID = 1L;

    /**
     * 我的用户id
     * @return user_id 我的用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 我的用户id
     * @param userId 我的用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 好于数
     * @return friend_counts 好于数
     */
    public Long getFriendCounts() {
        return friendCounts;
    }

    /**
     * 好于数
     * @param friendCounts 好于数
     */
    public void setFriendCounts(Long friendCounts) {
        this.friendCounts = friendCounts;
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
        sb.append(", friendCounts=").append(friendCounts);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}