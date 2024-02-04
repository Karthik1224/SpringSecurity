package com.example.springsecurity.service;


import com.example.springsecurity.modals.User;
import com.example.springsecurity.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    public void addUser(User user)
    {
             userRepo.save(user);
    }
    public List<User> fetchUsers()
    {
        return userRepo.findAll();
    }
}
