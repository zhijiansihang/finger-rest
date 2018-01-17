package com.zhijiansihang.sys.util;

import com.zhijiansihang.common.RetCode;
import com.zhijiansihang.common.Response;

/**
 * Created by wanglu-jf on 17/9/8.
 */
public class CustromResponse<T> extends Response<T> {

    public static <T> Response<T> error(T t) {
        Response response = new Response();
        response.getHeader().setCode(RetCode.VALIDATEERROR.getCode());
        response.setBody(t);
        return response;
    }


}
