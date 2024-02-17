package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {
    @GetMapping("/index")
    public String showDashboard() {
        return "index";
    }
    @GetMapping("/welcome")
    public String showwelcomepage() {
        return "welcome";
    }
    @PostMapping("/uploadPhoto")
    public ModelAndView uploadProfilePhoto(@RequestParam("file") MultipartFile file) {


        return new ModelAndView("redirect:/dashboard");
    }
    @GetMapping("/charts")
    public String showcharts() {
        return "charts";
    }

    @GetMapping("/tables")
    public String showtables() {
        return "tables";
    }

    @GetMapping("/layout-sidenav-light")
    public String showlayout() {
        return "layout-sidenav-light";
    }

    @GetMapping("/layout-static")
    public String showstaticlayout() {
        return "layout-static";
    }

    @GetMapping("/application_gallery")
    public String showsapplication_gallery() {
        return "application_gallery";
    }
    @GetMapping("/checkin_checkout")
    public String showscheckin_checkout() {
        return "checkin_checkout";
    }
}