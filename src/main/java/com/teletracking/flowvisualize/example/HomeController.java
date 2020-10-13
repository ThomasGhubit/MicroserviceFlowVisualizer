package com.teletracking.flowvisualize.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HomeController {
    
    @GetMapping("/ping")
    public HelloMessage home() {
        return new HelloMessage("Hello, World!");
    }

}
