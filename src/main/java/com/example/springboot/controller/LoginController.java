package com.example.springboot.controller;

import com.example.springboot.model.Library;
import com.example.springboot.service.LibraryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class LoginController {
    @Autowired
    private LibraryService libraryService;
    public LoginController(LibraryService libraryService){
        this.libraryService=libraryService;
    }



    @GetMapping("/register")
    public String showSignupForm(Model model)
    {
        model.addAttribute("library", new Library());
        return "register";
    }
    @PostMapping("/register")
    public String processSignupForm(@ModelAttribute("library") Library library)
    {
      libraryService.saveLibrary(library);
        return "login";
    }
    @GetMapping("/login")
    public String showLoginForm(Model model)
    {
        model.addAttribute("library", new Library());
        return "login";
    }
    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute("library") Library library) {
        libraryService.saveLibrary(library);
        return "index";
    }
    @GetMapping("/password")
    public String showPasswordPage() {
        return "password";
    }

}