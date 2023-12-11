package com.example.productmanagmentmodule.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionFormatResponse {
    private String message;
    private int errorCode;
}
