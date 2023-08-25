package com.example.productmanagmentmodule.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponseNw<T>{
    private int code;
    private String message;
    private int status;
    private T data;

    public static BaseResponseNw createErrorResponse(int code, String message){
        BaseResponseNw responseNw = new BaseResponseNw();
        responseNw.setCode(code);
        responseNw.setMessage(message);
        return responseNw;
    }
}
