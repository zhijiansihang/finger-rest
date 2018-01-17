package com.zhijiansihang.gateway.security.remote;

import com.zhijiansihang.common.Response;
import com.zhijiansihang.gateway.security.remote.vo.Resource;

import java.util.List;

/**
 * 用户服务（认证）
 *
 * Created by Shawn on 2017/9/12.
 */

public class ResourceServiceHystrix implements ResourceService{


    @Override
    public Response<List<Resource>> findAll() {
        return null;
    }
}
