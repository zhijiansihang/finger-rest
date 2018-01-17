package com.zhijiansihang.finger.app.dao.mysql.model;

import java.io.Serializable;
import java.util.Date;

public class UserCollectionDO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * user_id
     */
    private Long userId;

    /**
     * 内容id:理财师就是userid，产品就是loanid
     */
    private Long contentId;

    /**
     * 收藏的类型 1:理财师(店铺) 2:产品
     */
    private Byte contentType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * user_collection
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
     * user_id
     * @return user_id user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * user_id
     * @param userId user_id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 内容id:理财师就是userid，产品就是loanid
     * @return content_id 内容id:理财师就是userid，产品就是loanid
     */
    public Long getContentId() {
        return contentId;
    }

    /**
     * 内容id:理财师就是userid，产品就是loanid
     * @param contentId 内容id:理财师就是userid，产品就是loanid
     */
    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    /**
     * 收藏的类型 1:理财师(店铺) 2:产品
     * @return content_type 收藏的类型 1:理财师(店铺) 2:产品
     */
    public Byte getContentType() {
        return contentType;
    }

    /**
     * 收藏的类型 1:理财师(店铺) 2:产品
     * @param contentType 收藏的类型 1:理财师(店铺) 2:产品
     */
    public void setContentType(Byte contentType) {
        this.contentType = contentType;
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
        sb.append(", userId=").append(userId);
        sb.append(", contentId=").append(contentId);
        sb.append(", contentType=").append(contentType);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}