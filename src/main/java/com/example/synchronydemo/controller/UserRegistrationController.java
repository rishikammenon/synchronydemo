package com.example.synchronydemo.controller;

import com.example.synchronydemo.entities.User;
import com.example.synchronydemo.model.UserRegistration;
import com.example.synchronydemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/java/app/user")
public class UserRegistrationController {

    private UserService userService;

    public UserRegistrationController(UserService userService) {

        this.userService = userService;
    }

    // handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String registration(@Validated @ModelAttribute("user") UserRegistration userRegistration,
                               BindingResult result,
                               Model model){
        User existingUser = userService.findUserByEmail(userRegistration.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userRegistration);
            return "/register";
        }

        userService.saveUser(userRegistration);
        return "redirect:/register?success";
    }
}
