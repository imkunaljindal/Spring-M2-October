package com.example.securityTutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SchoolController {

    @GetMapping("/home")
    public String home() {
        return "Welcome HOME";
    }

    @GetMapping("/student")
    public String student() {
        return "Welcome STUDENT";
    }

    @GetMapping("/admin")
    public String admin() {
        return "welcome ADMIN";
    }
}
