package com.zhijiansihang.finger.app.dao.mysql.model;

import java.io.Serializable;
import java.util.Date;

public class SmsDO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 发送的模板id,发送的模板参数或者内容
     */
    private String reqMessage;

    /**
     * 第三方返回的消息(主要为失败原因)
     */
    private String respMessage;

    /**
     * 渠道名称
     */
    private String channelName;

    /**
     * 发送的类型:0001:注册验证码,或者为模板id
     */
    private String templateCode;

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
     * sms
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
     * 手机号
     * @return mobile 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 手机号
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 发送的模板id,发送的模板参数或者内容
     * @return req_message 发送的模板id,发送的模板参数或者内容
     */
    public String getReqMessage() {
        return reqMessage;
    }

    /**
     * 发送的模板id,发送的模板参数或者内容
     * @param reqMessage 发送的模板id,发送的模板参数或者内容
     */
    public void setReqMessage(String reqMessage) {
        this.reqMessage = reqMessage == null ? null : reqMessage.trim();
    }

    /**
     * 第三方返回的消息(主要为失败原因)
     * @return resp_message 第三方返回的消息(主要为失败原因)
     */
    public String getRespMessage() {
        return respMessage;
    }

    /**
     * 第三方返回的消息(主要为失败原因)
     * @param respMessage 第三方返回的消息(主要为失败原因)
     */
    public void setRespMessage(String respMessage) {
        this.respMessage = respMessage == null ? null : respMessage.trim();
    }

    /**
     * 渠道名称
     * @return channel_name 渠道名称
     */
    public String getChannelName() {
        return channelName;
    }

    /**
     * 渠道名称
     * @param channelName 渠道名称
     */
    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    /**
     * 发送的类型:0001:注册验证码,或者为模板id
     * @return template_code 发送的类型:0001:注册验证码,或者为模板id
     */
    public String getTemplateCode() {
        return templateCode;
    }

    /**
     * 发送的类型:0001:注册验证码,或者为模板id
     * @param templateCode 发送的类型:0001:注册验证码,或者为模板id
     */
    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode == null ? null : templateCode.trim();
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
        sb.append(", mobile=").append(mobile);
        sb.append(", reqMessage=").append(reqMessage);
        sb.append(", respMessage=").append(respMessage);
        sb.append(", channelName=").append(channelName);
        sb.append(", templateCode=").append(templateCode);
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