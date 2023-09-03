package com.example.productmanagmentmodule.service;

import com.example.productmanagmentmodule.entity.Customer;
import com.example.productmanagmentmodule.model.request.JwtRequest;
import com.example.productmanagmentmodule.model.response.AppUserResponse;
import com.example.productmanagmentmodule.model.response.HttpResponse;
import com.example.productmanagmentmodule.model.response.JwtResponse;

public interface AuthService {

    HttpResponse<JwtResponse> authenticate(JwtRequest request);

    JwtResponse register(JwtRequest request);

    AppUserResponse getAppUser(String userId);

    String generateOtp(String phoneNumber);

    boolean verifyOTP(String otp);
}
