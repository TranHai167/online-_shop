package com.example.productmanagmentmodule.service;

import com.example.productmanagmentmodule.entity.Customer;
import com.example.productmanagmentmodule.exception.CommonException;
import com.example.productmanagmentmodule.model.request.JwtRequest;
import com.example.productmanagmentmodule.model.response.AppUserResponse;
import com.example.productmanagmentmodule.model.response.HttpResponse;
import com.example.productmanagmentmodule.model.response.JwtResponse;
import com.example.productmanagmentmodule.model.response.UserDto;

import java.util.List;

public interface AuthService {

    HttpResponse<JwtResponse> authenticate(JwtRequest request);

    JwtResponse register(JwtRequest request);

    AppUserResponse getAppUser(String userId);

    String generateOtp(String phoneNumber, String email) throws CommonException;

    boolean verifyOTP(String otp);

    List<UserDto> getAllUsers();

    String deleteUser(String email);
}
