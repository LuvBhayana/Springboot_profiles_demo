package com.dailycodebuffer.Springboot.tutorial.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${w.message}")
    private String welcomeMessage;
   @GetMapping("/")
    public String helloWorld(){
        return "Welcome to buffer ye hai website";
    }
}
