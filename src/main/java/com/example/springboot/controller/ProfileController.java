package com.example.springboot.controller;

import com.example.springboot.model.User;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String showProfilePage(Model model, Principal principal) {
        if (principal != null) {
            String email = principal.getName();
            User user = userService.getUserByEmail(email);
            model.addAttribute("user", user);
            return "profile";
        } else {

            // Handle the case where the user is not authenticated
            return "redirect:/login";
        }
    }

    @PostMapping("/profile/update")
    public String updateProfile(@ModelAttribute User updatedUser, @RequestParam("profilePicture") MultipartFile profilePicture) {
        // Handle profile picture upload
        if (!profilePicture.isEmpty()) {
            String profilePictureUrl = saveProfilePicture(profilePicture);
            updatedUser.setProfilePictureUrl(profilePictureUrl);
        }

        userService.updateProfile(updatedUser);

        // Redirect to the profile page after updating
        return "redirect:/profile";
    }



    private String saveProfilePicture(MultipartFile profilePicture) {

        return "/path/to/profile/pictures/filename.jpg"; // Replace with the actual URL or file path
    }
}
