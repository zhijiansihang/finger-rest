package com.zhijiansihang.finger.mmc;

import com.zhijiansihang.common.Response;
import com.zhijiansihang.common.RetCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class MobileService {

    private static final Logger LOG = LoggerFactory.getLogger(MobileService.class);

    /**
     * 响应数据
     *
     * @param request
     * @param service
     * @param requestType
     * @param responseType
     * @param <REQUEST>
     * @param <RESPONSE>
     * @return
     */
    public <REQUEST extends MobileMessage, RESPONSE extends MobileMessage> Response<RESPONSE> service(REQUEST request,
                                                                                                      MessageService<REQUEST,  Response<RESPONSE>> service, Class<REQUEST> requestType, Class<RESPONSE> responseType) {
        try {
            Response<RESPONSE> response = createResponse(responseType);
            service.execute(request, response);
            return response;
        } catch (Throwable e) {
            LOG.error("[{}][异常={}]", responseType, e.getMessage());
            e.printStackTrace();
            return createResponse(RetCode.INTERNALEXCEP.getCode(), "服务器错误", responseType);
        }
    }

    private <T extends MobileMessage> Response<T> createResponse(String statusCode, String statusMessage, Class<T> responseType) {
        Response<T>  response = createResponse(responseType);
        response.getHeader().setCode(statusCode);
        response.getHeader().setMessage(statusMessage);
        return response;
    }

    private <T extends MobileMessage> Response<T> createResponse(Class<T> responseType) {
        try {
            T body = responseType.newInstance();
            return Response.success(body);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}
