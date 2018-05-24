package com.zhijiansihang.finger.app.constant;

public enum PlatfromType{
//    ALL(0, "全平台"),
//    PC(1, "PC端"),
//    APP(2, "APP端"),
//    WX(3, "WAP端"),
    ANDROID(1, "android端"),
    IOS(2, "ios端");
//    DREAM(6, "梦想计划-展示位置"),
//    ALLYEAR(7, "全年计划-展示位置"),
//    SOLDOUT(8, "已售罄的标"),
//    MGT(9, "MGT后台操作");

    private int code;
    private String name;

    PlatfromType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int intValue() {
        return this.code;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
