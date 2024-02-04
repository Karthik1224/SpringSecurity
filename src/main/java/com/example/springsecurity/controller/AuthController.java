package com.example.springsecurity.controller;


import com.example.springsecurity.dto.JwtResponse;
import com.example.springsecurity.dto.SignInRequest;
import com.example.springsecurity.dto.SignUpDto;
import com.example.springsecurity.modals.User;
import com.example.springsecurity.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody SignUpDto request)
    {
        return ResponseEntity.ok(authenticationService.signUp(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> signIn(@RequestBody SignInRequest request)
    {
        return ResponseEntity.ok(authenticationService.signIn(request));
    }

}
