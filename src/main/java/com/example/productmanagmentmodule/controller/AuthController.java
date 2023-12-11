package com.example.productmanagmentmodule.controller;

import com.example.productmanagmentmodule.entity.Customer;
import com.example.productmanagmentmodule.exception.CommonException;
import com.example.productmanagmentmodule.model.request.JwtRequest;
import com.example.productmanagmentmodule.model.request.OtpRequest;
import com.example.productmanagmentmodule.model.response.AppUserResponse;
import com.example.productmanagmentmodule.model.response.HttpResponse;
import com.example.productmanagmentmodule.model.response.JwtResponse;
import com.example.productmanagmentmodule.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticate")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("")
    public ResponseEntity<HttpResponse<JwtResponse>> authenticate(@RequestBody JwtRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @GetMapping("/get-user")
    public ResponseEntity<AppUserResponse> authenticate(@RequestParam String userId) {
        if (userId == null || userId.equals("null"))
            return ResponseEntity.ok(null);
        return ResponseEntity.ok(authService.getAppUser(userId));
    }

    @GetMapping("/secured-api")
    public String home() {
        return "Your jwt token works";
    }

    @PostMapping("/register")
    public ResponseEntity<JwtResponse> register(
            @RequestBody JwtRequest request
    ) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/create-otp")
    public ResponseEntity<String> generateOtp(@RequestBody OtpRequest otpRequest) throws CommonException {
        String phoneNumber = otpRequest.getPhoneNumber();
        String email = otpRequest.getEmail();
        return ResponseEntity.ok(authService.generateOtp(phoneNumber, email));
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<Boolean> verifyOtp(@RequestBody String otpNumber) {
        return ResponseEntity.ok(authService.verifyOTP(otpNumber));
    }
}

