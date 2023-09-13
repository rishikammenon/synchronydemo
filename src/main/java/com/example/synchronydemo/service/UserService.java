package com.example.synchronydemo.service;

import com.example.synchronydemo.entities.User;
import com.example.synchronydemo.model.UserRegistration;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {

    void saveUser(UserRegistration userRegistration);
    List<User> getAll();
    User findUserByEmail(String email);
}
