package com.example.onboarder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class OnboarderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OnboarderApplication.class, args);
    }
}

@RestController
class HelloController {
    @GetMapping("/")
    public String home() {
        return "🚀 Customer Onboarder API is running!";
    }
}
