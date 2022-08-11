package com.ff.blog.vo;

public enum ErrorCode {

    PARAMS_ERROR(10001,"wrong params"),
    ACCOUNT_PWD_NOT_EXIST(10002,"user or password doesn't exist"),
    NO_PERMISSION(70001,"no permission"),
    SESSION_TIME_OUT(90001,"session timeout"),
    NO_LOGIN(90002,"no login"),
    ACCOUNT_EXIST(10004,"account exist");

    private int code;
    private String msg;

    ErrorCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}