package com.example.synchronydemo.controller;

import com.example.synchronydemo.model.UserLogin;
import com.example.synchronydemo.model.UserRegistration;
import com.example.synchronydemo.repositories.UserRepository;
import com.example.synchronydemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/java/app")
public class DemoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public DemoController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value="/login")
    public ResponseEntity<String> loginToSynchrony(@RequestBody UserLogin userLogin) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(userLogin.getEmail(), userLogin.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User login successfully!...", HttpStatus.OK);
    }

    @PostMapping(value="/register")
    public String registerUserAccount(@ModelAttribute("user")
                                      UserRegistration userRegistration) {

        userService.saveUser(userRegistration);
        return "redirect:/registration?success";
    }
}
