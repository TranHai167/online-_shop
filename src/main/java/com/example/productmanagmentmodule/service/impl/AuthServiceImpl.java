package com.example.productmanagmentmodule.service.impl;

import com.example.productmanagmentmodule.entity.UserEntity;
import com.example.productmanagmentmodule.model.request.JwtRequest;
import com.example.productmanagmentmodule.model.response.JwtResponse;
import com.example.productmanagmentmodule.repository.UserRepository;
import com.example.productmanagmentmodule.service.AuthService;
import com.example.productmanagmentmodule.service.ShoppingCartService;
import com.example.productmanagmentmodule.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;

    private final UserRepository repository;

    private final JwtUtil jwtUtil;

    private final PasswordEncoder passwordEncoder;

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public AuthServiceImpl(AuthenticationManager authenticationManager, UserRepository repository, JwtUtil jwtUtil, PasswordEncoder passwordEncoder, ShoppingCartService shoppingCartService) {
        this.authenticationManager = authenticationManager;
        this.repository = repository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
        this.shoppingCartService = shoppingCartService;
    }

    public JwtResponse authenticate(JwtRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = repository.findFirstByEmail(request.getEmail());
        var jwtToken = jwtUtil.generateToken(user);
        return JwtResponse.builder()
                .accessToken(jwtToken)
                .cartId(user.getId())
                .currentUser(user.getUsername())
                .build();
    }

    public JwtResponse register(JwtRequest request) {
        var user = UserEntity.builder()
                .id(UUID.randomUUID().toString())
                .firstName(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        var savedUser = repository.save(user);
        var jwtToken = jwtUtil.generateToken(user);
        shoppingCartService.createDefaultShoppingCart(user.getId());
        return JwtResponse.builder()
                .accessToken(jwtToken)
                .cartId(user.getId())
                .currentUser(user.getUsername())
                .build();
    }
}
