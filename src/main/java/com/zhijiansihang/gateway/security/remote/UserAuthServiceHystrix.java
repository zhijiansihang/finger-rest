package com.zhijiansihang.gateway.security.remote;

import com.zhijiansihang.common.Response;
import com.zhijiansihang.gateway.security.remote.vo.UserAuth;

/**
 * 用户服务（认证）
 *
 * Created by Shawn on 2017/9/12.
 */

public class UserAuthServiceHystrix implements UserAuthService{

    @Override
    public Response<UserAuth> findByAuthId(String authId) {
        return null;
    }
}
