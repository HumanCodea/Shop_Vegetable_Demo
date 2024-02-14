package com.than.Shop_Vegetable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.than.Shop_Vegetable.model.Users;
import com.than.Shop_Vegetable.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/login")
    public String LoginPage(){
        return "loginUser";
    }

    @GetMapping("/register")
    public String RegisterUser(){
        return "registerUser";
    }

    @PostMapping("/saveUser")
    public String SaveUser(@ModelAttribute Users users){
        userService.SaveUser(users);
        return "redirect:/register?successfully";
    }

    @GetMapping("/logout")
    public String LogoutPage(){
        return "loginUser";
    }
    
}
