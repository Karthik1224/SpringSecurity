package com.example.springsecurity.dto;

import lombok.Data;

@Data
public class JwtResponse {

    private String jwtToken;
    private String email;
}
