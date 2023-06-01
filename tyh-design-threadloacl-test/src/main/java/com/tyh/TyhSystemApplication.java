package com.tyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Description: TyhDesignTestApplication
 * @Author: 青衣醉
 * @Date: 2023/4/28 4:40 下午
 */
@SpringBootApplication
@ServletComponentScan
public class TyhSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(TyhSystemApplication.class, args);
    }
}
