package com.example.springsecurity.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface CustomUserDetailsService {

    UserDetailsService userDetailsService();
}
