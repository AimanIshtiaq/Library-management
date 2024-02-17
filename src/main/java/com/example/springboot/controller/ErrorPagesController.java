package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ErrorPagesController {

    @GetMapping("/401")
    public String show401() {
        return "401";
    }
    @GetMapping("/404")
    public String show404() {
        return "404";
    }

}
