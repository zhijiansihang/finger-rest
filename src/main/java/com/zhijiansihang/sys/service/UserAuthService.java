package com.zhijiansihang.sys.service;

import com.zhijiansihang.sys.entity.User;
import com.zhijiansihang.sys.entity.UserAuth;
import com.zhijiansihang.sys.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

/**
 * Created by wanglu-jf on 17/9/7.
 */
@Service
public class UserAuthService {

    @Autowired
    private UserAuthRepository userAuthRepository;

    /**
     * 根据用户登陆账号查询认证账户
     * @param authId 账号
     * @return
     */
    public UserAuth findByAuthId(String authId){
        UserAuth userAuth = this.userAuthRepository.findByAuthId(authId);
        return userAuth;
    }

    /**
     * 根据用户Id查询认证账户
     * @param userId 用户Id
     * @return
     */
    public UserAuth findByUserId(Long userId){
        User user = new User();
        user.setId(userId);
        UserAuth userAuth = new UserAuth();
        userAuth.setUser(user);
        Example<UserAuth> example = Example.of(userAuth);
        return userAuthRepository.findOne(example);
    }


}
