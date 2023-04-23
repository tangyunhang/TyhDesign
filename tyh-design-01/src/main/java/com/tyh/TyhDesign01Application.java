package com.tyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TyhDesign01Application {

    public static void main(String[] args) {
        SpringApplication.run (TyhDesign01Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate ();
    }

}
