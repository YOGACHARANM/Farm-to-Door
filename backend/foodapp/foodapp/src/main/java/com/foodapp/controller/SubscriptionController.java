package com.foodapp.controller;

import com.foodapp.model.Subscription;
import com.foodapp.model.User;
import com.foodapp.repository.SubscriptionRepository;
import com.foodapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscription")
@CrossOrigin(origins = "*")
public class SubscriptionController {

    @Autowired
    private SubscriptionRepository subscriptionRepo;

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/subscribe/{email}")
    public String subscribe(@PathVariable String email, @RequestBody Subscription subscription) {
        User user = userRepo.findByEmail(email);
        if (user == null) {
            return "User not found";
        }
        subscription.setUser(user);
        subscriptionRepo.save(subscription);
        return "Subscription saved";
    }
}
