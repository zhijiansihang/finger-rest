package com.zhijiansihang.finger.app.event.demo;

import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import org.springframework.context.ApplicationEvent;

/**
 *
 * @author: Paul Zhang
 * @date: 16:21 2017/12/27
 */
public class UserRegisterEvent extends ApplicationEvent {

    public UserDO getUserDO() {
        return userDO;
    }

    public void setUserDO(UserDO userDO) {
        this.userDO = userDO;
    }

    private UserDO userDO;
    public UserRegisterEvent(Object source) {
        super(source);
    }
}
