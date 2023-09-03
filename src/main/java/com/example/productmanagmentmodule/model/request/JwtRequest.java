package com.example.productmanagmentmodule.model.request;

import com.example.productmanagmentmodule.enums.Roles;
import lombok.Data;

@Data
public class JwtRequest {
    private String email;
    private String name;
    private String password;
    private Roles role;
    private String phone;
}
