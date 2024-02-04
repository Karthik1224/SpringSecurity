package com.example.springsecurity.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

    String getUsernameFromToken(String token);
    String generateToken(UserDetails userDetails);
    Boolean validateToken(String token, UserDetails userDetails);
}
