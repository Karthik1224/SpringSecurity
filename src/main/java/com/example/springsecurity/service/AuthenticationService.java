package com.example.springsecurity.service;

import com.example.springsecurity.dto.JwtResponse;
import com.example.springsecurity.dto.SignInRequest;
import com.example.springsecurity.dto.SignUpDto;
import com.example.springsecurity.modals.User;

public interface AuthenticationService {
    User signUp(SignUpDto signUpDto);
    JwtResponse signIn(SignInRequest signInRequest);
}
