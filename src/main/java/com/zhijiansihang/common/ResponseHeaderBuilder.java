package com.zhijiansihang.common;

public class ResponseHeaderBuilder {

    public static ResponseHeader buildValidateError(String message){
        ResponseHeader responseHeader = new ResponseHeader();
        responseHeader.setCode(RetCode.VALIDATEERROR.getCode());
        responseHeader.setMessage(message);
        return responseHeader;
    }
    public static ResponseHeader build(RetCode retCode, String message){
        ResponseHeader responseHeader = new ResponseHeader();
        responseHeader.setCode(retCode.getCode());
        responseHeader.setMessage(message);
        return responseHeader;
    }

    public static ResponseHeader buildTimeout(){
        ResponseHeader responseHeader = new ResponseHeader();
        responseHeader.setCode(RetCode.TIMEOUT.getCode());
        responseHeader.setMessage(RetCode.TIMEOUT.getMessage());
        return responseHeader;
    }
}
