package com.example.springboot.controller;

import com.example.springboot.model.Student;
import com.example.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/addstudent")
    public String showaddstudent(Model model) {
        model.addAttribute("student",new Student());
        return "addstudent";
    }
    @PostMapping("/addstudent")
    public String processaddstudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/list_of_students";
    }}