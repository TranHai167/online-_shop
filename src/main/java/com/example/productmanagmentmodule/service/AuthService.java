package com.example.productmanagmentmodule.service;

import com.example.productmanagmentmodule.model.request.JwtRequest;
import com.example.productmanagmentmodule.model.response.JwtResponse;

public interface AuthService {

    JwtResponse authenticate(JwtRequest request);

    JwtResponse register(JwtRequest request);
}
