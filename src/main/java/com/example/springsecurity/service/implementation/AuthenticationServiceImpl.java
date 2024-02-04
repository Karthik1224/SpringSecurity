package com.example.springsecurity.service.implementation;

import com.example.springsecurity.dto.JwtResponse;
import com.example.springsecurity.dto.SignInRequest;
import com.example.springsecurity.dto.SignUpDto;
import com.example.springsecurity.modals.User;
import com.example.springsecurity.repositories.UserRepo;
import com.example.springsecurity.service.AuthenticationService;
import com.example.springsecurity.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;
    public User signUp(SignUpDto signUpDto)
    {
        User user = new User();
        user.setEmail(signUpDto.getEmail());
        user.setName(signUpDto.getName());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        return userRepo.save(user);
    }

    public JwtResponse signIn(SignInRequest signInRequest)
    {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(),signInRequest.getPassword()));
               UserDetails userDetails = userRepo.findByEmail(signInRequest.getEmail()).orElseThrow(()-> new IllegalArgumentException(" Invalid Username or Password  !!"));
               String token = jwtService.generateToken(userDetails);
               JwtResponse response = new JwtResponse();
               response.setEmail(userDetails.getUsername());
               response.setJwtToken(token);
               return response;


    }

}
