package com.example.springboot.service;

import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// UserService.java
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByEmail(String email) {
        return userRepository.findByEmailAddress(email);
    }

    public void updateProfile(User updatedUser) {
        // Update other profile-related fields as needed
        userRepository.save(updatedUser);
    }
}

