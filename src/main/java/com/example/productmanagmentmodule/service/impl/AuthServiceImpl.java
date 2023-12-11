package com.example.productmanagmentmodule.service.impl;

import com.example.productmanagmentmodule.entity.Customer;
import com.example.productmanagmentmodule.entity.UserEntity;
import com.example.productmanagmentmodule.enums.Roles;
import com.example.productmanagmentmodule.exception.CommonException;
import com.example.productmanagmentmodule.model.request.JwtRequest;
import com.example.productmanagmentmodule.model.response.AppUserResponse;
import com.example.productmanagmentmodule.model.response.HttpResponse;
import com.example.productmanagmentmodule.model.response.JwtResponse;
import com.example.productmanagmentmodule.repository.UserRepository;
import com.example.productmanagmentmodule.service.AuthService;
import com.example.productmanagmentmodule.service.ShoppingCartService;
import com.example.productmanagmentmodule.utility.JwtUtil;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;

    private final UserRepository repository;

    private final JwtUtil jwtUtil;

    private final PasswordEncoder passwordEncoder;

    private final ShoppingCartService shoppingCartService;
    private String otpSent;

    public final String ACCOUNT_SID = "AC56db3ce71a30f8ab114f94b8ae92d07d";
    public final String AUTH_TOKEN = "b640a8920b17aeaf046aea3e3fb8bab8";

    @Autowired
    public AuthServiceImpl(AuthenticationManager authenticationManager, UserRepository repository, JwtUtil jwtUtil, PasswordEncoder passwordEncoder, ShoppingCartService shoppingCartService) {
        this.authenticationManager = authenticationManager;
        this.repository = repository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public AppUserResponse getAppUser(String userId) {
        UserEntity user = this.repository.findFirstById(userId);
        return new AppUserResponse(user.getFirstName(), user.getRole().equals(Roles.ADMIN));
    }

    public HttpResponse<JwtResponse> authenticate(JwtRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = repository.findFirstByEmail(request.getEmail());
        var jwtToken = jwtUtil.generateToken(user);
        JwtResponse jwtResponse = JwtResponse.builder()
                .accessToken(jwtToken)
                .cartId(user.getId())
                .currentUser(user.getUsername())
                .build();

        return (HttpResponse<JwtResponse>) new HttpResponse(200, jwtResponse);
    }

    public JwtResponse register(JwtRequest request) {
        var user = UserEntity.builder()
                .id(UUID.randomUUID().toString())
                .firstName(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Roles.USER)
                .phoneNumber(request.getPhone())
                .build();
        var savedUser = repository.save(user);
        var jwtToken = jwtUtil.generateToken(user);
        shoppingCartService.createDefaultShoppingCart(user.getId());
        return JwtResponse.builder()
                .accessToken(jwtToken)
                .cartId(user.getId())
                .currentUser(user.getFirstName())
                .build();
    }

    @Override
    public String generateOtp(String phoneNumber, String email) throws CommonException {
        if (!notExistedEmail(email)) {
            throw new CommonException("402", "Email already existed");
        }

        Random random = new Random();
        int[] numbers = new int[6];
        StringBuffer otpSent = new StringBuffer();

        for (int i = 0; i < 6; i++) {
            int randomNumber = random.nextInt(10);
            numbers[i] = randomNumber;
            otpSent.append(numbers[i]);
        }
        this.otpSent = String.valueOf(otpSent);
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        phoneNumber = "+84" + phoneNumber.substring(1);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(phoneNumber),  // thay đổi số ở chỗ này này
                        new com.twilio.type.PhoneNumber("+14086769902"),
                        String.valueOf(otpSent))
                .create();
        return phoneNumber;
    }

    private boolean notExistedEmail(String email) {
        return this.repository.findFirstByEmail(email) == null;
    }

    @Override
    public boolean verifyOTP(String otpCheck) {
        return otpCheck.equals(this.otpSent);
    }
}
