package com.zhijiansihang.finger.app.event.demo;

import org.springframework.context.ApplicationEvent;

/**
 * @author paul
 * @description
 * @date 2018/2/11
 */
public class RiskAssessmentModifyEvent extends ApplicationEvent {
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public Long userId;

    public RiskAssessmentModifyEvent(Object source) {
        super(source);
    }
}
