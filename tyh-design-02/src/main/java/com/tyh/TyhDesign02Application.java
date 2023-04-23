package com.tyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TyhDesign02Application {

    public static void main(String[] args) {
        SpringApplication.run (TyhDesign02Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate ();
    }

}
