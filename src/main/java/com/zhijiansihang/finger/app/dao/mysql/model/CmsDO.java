package com.zhijiansihang.finger.app.dao.mysql.model;

import java.io.Serializable;
import java.util.Date;

public class CmsDO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * cms 描述:type_code:type_name = [banner:100:banner,[notice:200:公告,[information:300:资讯,[avatar:400:头像,[exam:500:考题 
     */
    private Short typeCode;

    /**
     * cms 描述:type_code:type_name = [banner:100:banner,[notice:200:公告,[information:300:资讯,[avatar:400:头像,[exam:500:考题 
     */
    private String typeName;

    /**
     * 文件系统图片路径
     */
    private String imagePath;

    /**
     * 前台图片的链接
     */
    private String imageAccessPath;

    /**
     * 标题
     */
    private String title;

    /**
     * 副标题
     */
    private String subTitle;

    /**
     * 内容
     */
    private String content;

    /**
     * 跳转链接
     */
    private String hrefLink;

    /**
     * 是否前端显示 1:为显示 0:不显示
     */
    private Byte isFrontDisplay;

    /**
     * 是否逻辑删除 1:删除 0:未删除
     */
    private Byte isDeleted;

    /**
     * 置顶功能,值越大，显示越靠前
     */
    private Integer locationSize;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人
     */
    private Long updateBy;

    /**
     * cms
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
     * cms 描述:type_code:type_name = [banner:100:banner,[notice:200:公告,[information:300:资讯,[avatar:400:头像,[exam:500:考题 
     * @return type_code cms 描述:type_code:type_name = [banner:100:banner,[notice:200:公告,[information:300:资讯,[avatar:400:头像,[exam:500:考题 
     */
    public Short getTypeCode() {
        return typeCode;
    }

    /**
     * cms 描述:type_code:type_name = [banner:100:banner,[notice:200:公告,[information:300:资讯,[avatar:400:头像,[exam:500:考题 
     * @param typeCode cms 描述:type_code:type_name = [banner:100:banner,[notice:200:公告,[information:300:资讯,[avatar:400:头像,[exam:500:考题 
     */
    public void setTypeCode(Short typeCode) {
        this.typeCode = typeCode;
    }

    /**
     * cms 描述:type_code:type_name = [banner:100:banner,[notice:200:公告,[information:300:资讯,[avatar:400:头像,[exam:500:考题 
     * @return type_name cms 描述:type_code:type_name = [banner:100:banner,[notice:200:公告,[information:300:资讯,[avatar:400:头像,[exam:500:考题 
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * cms 描述:type_code:type_name = [banner:100:banner,[notice:200:公告,[information:300:资讯,[avatar:400:头像,[exam:500:考题 
     * @param typeName cms 描述:type_code:type_name = [banner:100:banner,[notice:200:公告,[information:300:资讯,[avatar:400:头像,[exam:500:考题 
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * 文件系统图片路径
     * @return image_path 文件系统图片路径
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * 文件系统图片路径
     * @param imagePath 文件系统图片路径
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath == null ? null : imagePath.trim();
    }

    /**
     * 前台图片的链接
     * @return image_access_path 前台图片的链接
     */
    public String getImageAccessPath() {
        return imageAccessPath;
    }

    /**
     * 前台图片的链接
     * @param imageAccessPath 前台图片的链接
     */
    public void setImageAccessPath(String imageAccessPath) {
        this.imageAccessPath = imageAccessPath == null ? null : imageAccessPath.trim();
    }

    /**
     * 标题
     * @return title 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 标题
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 副标题
     * @return sub_title 副标题
     */
    public String getSubTitle() {
        return subTitle;
    }

    /**
     * 副标题
     * @param subTitle 副标题
     */
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle == null ? null : subTitle.trim();
    }

    /**
     * 内容
     * @return content 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 内容
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 跳转链接
     * @return href_link 跳转链接
     */
    public String getHrefLink() {
        return hrefLink;
    }

    /**
     * 跳转链接
     * @param hrefLink 跳转链接
     */
    public void setHrefLink(String hrefLink) {
        this.hrefLink = hrefLink == null ? null : hrefLink.trim();
    }

    /**
     * 是否前端显示 1:为显示 0:不显示
     * @return is_front_display 是否前端显示 1:为显示 0:不显示
     */
    public Byte getIsFrontDisplay() {
        return isFrontDisplay;
    }

    /**
     * 是否前端显示 1:为显示 0:不显示
     * @param isFrontDisplay 是否前端显示 1:为显示 0:不显示
     */
    public void setIsFrontDisplay(Byte isFrontDisplay) {
        this.isFrontDisplay = isFrontDisplay;
    }

    /**
     * 是否逻辑删除 1:删除 0:未删除
     * @return is_deleted 是否逻辑删除 1:删除 0:未删除
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * 是否逻辑删除 1:删除 0:未删除
     * @param isDeleted 是否逻辑删除 1:删除 0:未删除
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * 置顶功能,值越大，显示越靠前
     * @return location_size 置顶功能,值越大，显示越靠前
     */
    public Integer getLocationSize() {
        return locationSize;
    }

    /**
     * 置顶功能,值越大，显示越靠前
     * @param locationSize 置顶功能,值越大，显示越靠前
     */
    public void setLocationSize(Integer locationSize) {
        this.locationSize = locationSize;
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
     * 创建人
     * @return create_by 创建人
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * 创建人
     * @param createBy 创建人
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
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
     * 更新人
     * @return update_by 更新人
     */
    public Long getUpdateBy() {
        return updateBy;
    }

    /**
     * 更新人
     * @param updateBy 更新人
     */
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
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
        sb.append(", typeCode=").append(typeCode);
        sb.append(", typeName=").append(typeName);
        sb.append(", imagePath=").append(imagePath);
        sb.append(", imageAccessPath=").append(imageAccessPath);
        sb.append(", title=").append(title);
        sb.append(", subTitle=").append(subTitle);
        sb.append(", content=").append(content);
        sb.append(", hrefLink=").append(hrefLink);
        sb.append(", isFrontDisplay=").append(isFrontDisplay);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", locationSize=").append(locationSize);
        sb.append(", createTime=").append(createTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}