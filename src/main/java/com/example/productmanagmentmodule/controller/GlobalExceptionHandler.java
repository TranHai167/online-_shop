package com.example.productmanagmentmodule.controller;

import com.example.productmanagmentmodule.exception.CommonException;
import com.example.productmanagmentmodule.model.response.ExceptionFormatResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CommonException.class)
    public ResponseEntity<ExceptionFormatResponse> handleException(CommonException e) {
        // Log the exception
        e.printStackTrace();

        ExceptionFormatResponse errorResponse = new ExceptionFormatResponse(e.getMessage(), HttpStatus.PAYMENT_REQUIRED.value());
        // Return a meaningful error response
        return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body(errorResponse);
    }
}
