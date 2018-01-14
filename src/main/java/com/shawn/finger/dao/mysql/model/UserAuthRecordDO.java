package com.shawn.finger.dao.mysql.model;

import java.io.Serializable;
import java.util.Date;

public class UserAuthRecordDO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * userid
     */
    private Long userId;

    /**
     * 姓名
     */
    private String realName;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 第三方请求参数
     */
    private String reqMessage;

    /**
     * 第三方返回的消息
     */
    private String respMessage;

    /**
     * 请求流水号
     */
    private String requestId;

    /**
     * 第三方业务号
     */
    private String bizId;

    /**
     * 发送状态,0:平台已经发送至第三方,1:第三方返回成功,2:第三方返回失败
     */
    private Byte sendStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * user_auth_record
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
     * userid
     * @return user_id userid
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * userid
     * @param userId userid
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 姓名
     * @return real_name 姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 姓名
     * @param realName 姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 身份证
     * @return id_card 身份证
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 身份证
     * @param idCard 身份证
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     * 第三方请求参数
     * @return req_message 第三方请求参数
     */
    public String getReqMessage() {
        return reqMessage;
    }

    /**
     * 第三方请求参数
     * @param reqMessage 第三方请求参数
     */
    public void setReqMessage(String reqMessage) {
        this.reqMessage = reqMessage == null ? null : reqMessage.trim();
    }

    /**
     * 第三方返回的消息
     * @return resp_message 第三方返回的消息
     */
    public String getRespMessage() {
        return respMessage;
    }

    /**
     * 第三方返回的消息
     * @param respMessage 第三方返回的消息
     */
    public void setRespMessage(String respMessage) {
        this.respMessage = respMessage == null ? null : respMessage.trim();
    }

    /**
     * 请求流水号
     * @return request_id 请求流水号
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * 请求流水号
     * @param requestId 请求流水号
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId == null ? null : requestId.trim();
    }

    /**
     * 第三方业务号
     * @return biz_id 第三方业务号
     */
    public String getBizId() {
        return bizId;
    }

    /**
     * 第三方业务号
     * @param bizId 第三方业务号
     */
    public void setBizId(String bizId) {
        this.bizId = bizId == null ? null : bizId.trim();
    }

    /**
     * 发送状态,0:平台已经发送至第三方,1:第三方返回成功,2:第三方返回失败
     * @return send_status 发送状态,0:平台已经发送至第三方,1:第三方返回成功,2:第三方返回失败
     */
    public Byte getSendStatus() {
        return sendStatus;
    }

    /**
     * 发送状态,0:平台已经发送至第三方,1:第三方返回成功,2:第三方返回失败
     * @param sendStatus 发送状态,0:平台已经发送至第三方,1:第三方返回成功,2:第三方返回失败
     */
    public void setSendStatus(Byte sendStatus) {
        this.sendStatus = sendStatus;
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
        sb.append(", realName=").append(realName);
        sb.append(", idCard=").append(idCard);
        sb.append(", reqMessage=").append(reqMessage);
        sb.append(", respMessage=").append(respMessage);
        sb.append(", requestId=").append(requestId);
        sb.append(", bizId=").append(bizId);
        sb.append(", sendStatus=").append(sendStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}