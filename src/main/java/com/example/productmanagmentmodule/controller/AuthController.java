package com.example.productmanagmentmodule.controller;

import com.example.productmanagmentmodule.model.request.JwtRequest;
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
    public ResponseEntity<JwtResponse> authenticate(@RequestBody JwtRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
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
}

