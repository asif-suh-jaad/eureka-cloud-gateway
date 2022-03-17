package com.sample.eureka.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController()
public class EurekaClientConsumer {

    @RequestMapping(value = "/greetings", method = RequestMethod.GET)
    public String getGreetings()
    {
        String response = restTemplate().exchange("http://service/greeting", HttpMethod.GET, null, String.class).getBody();
        System.out.println("Response From Service " + response);
        return  response;
    }
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientConsumer.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
