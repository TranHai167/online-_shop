package com.example.productmanagmentmodule.exception;

public class CommonException extends RuntimeException{
    private static final long serialVersionUID = 6553216978015134922L;
    private static final String DEFAULT_ERR_CODE = "999";
    private final String errorCode;

    public CommonException() {
        this.errorCode = "999";
    }

    public CommonException(Throwable ex) {
        super(ex);
        this.errorCode = "999";
    }

    public CommonException(String msg) {
        this("999", msg);
    }

    public CommonException(String msg, Throwable thr) {
        this("999", msg, thr);
    }

    public CommonException(String errCode, String msg) {
        super(msg);
        this.errorCode = errCode;
    }

    public CommonException(String errCode, String msg, Throwable thr) {
        super(msg, thr);
        this.errorCode = errCode;
    }

    public String getErrorCode() {
        return this.errorCode;
    }
}
