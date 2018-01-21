package com.zhijiansihang.finger.gen.serviceImpl;


import com.zhijiansihang.common.ResponseHeader;
import com.zhijiansihang.finger.app.sharing.kaptcha.KaptchaTools;
import com.zhijiansihang.finger.app.sharing.message.VerificationCodeTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.GetSmsRequest;
import com.zhijiansihang.finger.gen.entity.GetSmsResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import static com.zhijiansihang.common.RetCode.VALIDATEERROR;

/**
 * 获取短信验证码
 */
@Component("getSmsService")
public class GetSmsService implements MessageService<GetSmsRequest, Response<GetSmsResponse>> {

    private static final Logger LOG = LoggerFactory.getLogger(GetSmsService.class);
    private static final String SERVICE_DESC = "获取短信验证码";

    @Autowired
    KaptchaTools kaptchaTools;
    @Autowired
    VerificationCodeTools verificationCodeTools;

    @Override
    public void execute(GetSmsRequest request, Response<GetSmsResponse> response) {
        LOG.info("[{}][request={}]", SERVICE_DESC, request);

        String mobile = request.getMobile();
        if (!StringUtils.hasLength(mobile)){
            ResponseHeader responseHeader = new
                    ResponseHeader();
            responseHeader.setCode(VALIDATEERROR.getCode());
            responseHeader.setMessage("手机号输入不能空");
            response.setHeader(responseHeader);
            return;
        }
        boolean check = kaptchaTools.check(request.getKaptchaToken(), request.getKaptchaCode());
        if (!check) {
            //图形验证码不正确
            ResponseHeader responseHeader = new
                    ResponseHeader();
            responseHeader.setCode(VALIDATEERROR.getCode());
            responseHeader.setMessage("图形验证码错误");
            response.setHeader(responseHeader);
            return;
        }
        verificationCodeTools.send(request.getMobile());

    }
}
