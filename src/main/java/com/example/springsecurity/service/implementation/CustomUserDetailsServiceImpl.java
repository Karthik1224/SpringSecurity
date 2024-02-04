package com.example.springsecurity.service.implementation;


import com.example.springsecurity.repositories.UserRepo;
import com.example.springsecurity.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
     public UserDetailsService userDetailsService()
     {
         return new UserDetailsService() {
             @Override
             public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                 return userRepo.findByEmail(username)
                         .orElseThrow(()->new UsernameNotFoundException("User not found"));
             }
         };
     }
}
