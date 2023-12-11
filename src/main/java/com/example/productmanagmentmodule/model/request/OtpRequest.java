package com.example.productmanagmentmodule.model.request;

import lombok.Data;

@Data
public class OtpRequest {
    private String email;
    private String phoneNumber;
}
