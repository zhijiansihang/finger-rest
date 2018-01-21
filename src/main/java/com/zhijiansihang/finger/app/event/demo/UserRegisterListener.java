package com.zhijiansihang.finger.app.event.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import static com.zhijiansihang.finger.app.sharing.SharingSpringConfig.ASYNC_LISTENER;


/**
 *
 * @author: Paul Zhang
 * @date: 16:21 2017/12/27
 */
@Component
@Async(ASYNC_LISTENER)
public class UserRegisterListener implements ApplicationListener<UserRegisterEvent> {
    private static final Logger logger = LoggerFactory.getLogger(UserRegisterListener.class);
    @Override
    public void onApplicationEvent(UserRegisterEvent demoEvent) {
        logger.info("接收注册到消息:{}",demoEvent.getUserDO());
    }
}
