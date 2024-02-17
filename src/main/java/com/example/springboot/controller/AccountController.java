package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @GetMapping("/account_profile")
    public String showaccountprofile()
    {
        return "profile";
    }
    @GetMapping("/account_security")
    public String showaccountsecurity()
    {
        return "account_security";
    }



}
