package com.example.productmanagmentmodule.model.request;

import com.example.productmanagmentmodule.enums.Roles;
import lombok.Data;

@Data
public class JwtRequest {
    private String email;
    private String username;
    private String password;
    private Roles role;
}
