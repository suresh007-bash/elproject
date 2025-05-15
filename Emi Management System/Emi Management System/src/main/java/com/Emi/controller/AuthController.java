package com.Emi.controller;

import com.Emi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService service;

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, Model model) {
        if (service.usernameExists(username)) {
            model.addAttribute("error", "Username already exists");
            return "register";
        }
        service.register(username, password);
        model.addAttribute("message", "Registered successfully");
        return "login";
    }
}