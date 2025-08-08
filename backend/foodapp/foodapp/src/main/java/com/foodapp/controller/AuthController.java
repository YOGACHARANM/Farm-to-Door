package com.foodapp.controller;

import com.foodapp.model.User;
import com.foodapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        if (userRepo.findByEmail(user.getEmail()) != null) {
            return "Username already exists";
        }
        userRepo.save(user);
        return "Signup successful";
    }

    @PostMapping("/login")
    public String login(@RequestBody User loginData) {
        User user = userRepo.findByEmail(loginData.getEmail());
        if (user != null && user.getPassword().equals(loginData.getPassword())) {
            return "Login successful";
        }
        return "Invalid credentials";
    }
}
