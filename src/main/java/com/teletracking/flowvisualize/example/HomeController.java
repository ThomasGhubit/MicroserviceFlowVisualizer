package com.teletracking.flowvisualize.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ping")
public class HomeController {
    
    private static final String ROOT = "/";
    
    @GetMapping(ROOT)
    public HelloMessage home() {
        return new HelloMessage("Hello, World!");
    }

}
