package com.example.springsecurity.controller;


import com.example.springsecurity.modals.User;
import com.example.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/getUsers")
    public List<User> fetchUsers()
    {
        return userService.fetchUsers();
    }
}
