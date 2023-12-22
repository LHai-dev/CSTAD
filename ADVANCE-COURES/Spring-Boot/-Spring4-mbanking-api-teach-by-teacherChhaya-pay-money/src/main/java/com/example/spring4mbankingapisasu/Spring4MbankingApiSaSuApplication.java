package com.example.spring4mbankingapisasu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class Spring4MbankingApiSaSuApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring4MbankingApiSaSuApplication.class, args);
    }
    @GetMapping("/test")
    public String testVerifyView(){
        return "verify";
    }
}
