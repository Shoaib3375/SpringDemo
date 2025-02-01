package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("/hello") // maps to https://
    public String sayHello(@RequestParam String name, Model model) {

        model.addAttribute("user", name);
        return "welcome";
    }
}
