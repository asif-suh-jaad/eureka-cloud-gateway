package com.sample.eureka.eurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController()
public class EurekaClientApplication {

    @Value("${spring.application.name}")
    private String appName;

    @RequestMapping("/greeting")
    public String greeting() {
        System.out.println("Getting a new request call");
        return String.format(
                "Hello from '%s'!", appName);
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

}
