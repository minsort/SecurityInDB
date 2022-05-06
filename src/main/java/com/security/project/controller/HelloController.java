package com.security.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Hello";
    }

    @GetMapping("/users")
    public String user() {
        return "UserRoles";
    }

    @GetMapping("/admins")
    public String admin() {
        return "Admin";
    }

}