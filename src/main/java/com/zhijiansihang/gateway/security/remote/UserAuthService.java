package com.zhijiansihang.gateway.security.remote;

import com.zhijiansihang.common.Response;
import com.zhijiansihang.gateway.security.remote.vo.UserAuth;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户服务（认证）
 *
 * Created by Shawn on 2017/9/12.
 */
//@FeignClient(name = "platform-sys"/*,fallback = UserAuthServiceHystrix.class*/)
public interface UserAuthService {

    @RequestMapping(value = "/auth/get/{authId}")
    Response<UserAuth> findByAuthId(@PathVariable("authId") String authId);

}
