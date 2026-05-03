package com.foodapp.controller;

import com.foodapp.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import com.foodapp.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    
    @Autowired
    private org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        if (userRepo.findByEmail(user.getEmail()) != null) {
            return "Username already exists"; // Message matches frontend expectation
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return "Signup successful";
    }

    @PostMapping("/login")
    public String login(@RequestBody User loginData) {
        User user = userRepo.findByEmail(loginData.getEmail());
        if (user != null && passwordEncoder.matches(loginData.getPassword(), user.getPassword())) {
            return "Login successful";
        }
        return "Invalid credentials";
    }
}
