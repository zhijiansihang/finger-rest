package com.zhijiansihang.finger.gen.tool;

import com.zhijiansihang.gateway.security.core.JwtUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by paul on 2018/1/22.
 */
public class UserTools {
    public static JwtUserDetails getLoginUser(){
        JwtUserDetails principal = (JwtUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal;
    }
}
