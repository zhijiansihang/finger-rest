package com.zhijiansihang.gateway.filter;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.zhijiansihang.common.ComParams;
import com.zhijiansihang.gateway.security.core.JwtUserDetails;
import com.zhijiansihang.gateway.util.HttpHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ParamSetFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(ParamSetFilter.class);

    @Value("${name.token:xToken}")
    private String token;

    @Autowired
    private RedisTemplate<Serializable, Serializable> redisTemplate;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return -3;
    }

    @Override
    public boolean shouldFilter() {
        JwtUserDetails userDetails = (JwtUserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        if (userDetails == null) {
            return false;
        }
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();

        JwtUserDetails userDetails = (JwtUserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        Map<String, List<String>> params = ctx.getRequestQueryParams();
        if (params == null) {
            params = Maps.newHashMap();
        }

        HttpHelper.setRequestParams(params, ctx.getRequest().getQueryString());

        List<String> roles = Lists.newArrayList();
        userDetails.getAuthorities().forEach( authority ->{
            roles.add(authority.getAuthority());
        });
        // 设置用户id及用户角色参数
        params.put(ComParams.X_USERID, Lists.newArrayList(userDetails.getId().toString()));
        params.put(ComParams.X_LOGINNAME, Lists.newArrayList(userDetails.getUsername()));
        params.put(ComParams.X_ROLECODE, roles);
        params.put(ComParams.X_MOBILE, Lists.newArrayList(userDetails.getMobile()));

        ctx.setRequestQueryParams(params);

        return null;
    }

}
