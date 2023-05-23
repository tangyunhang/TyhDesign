package com.tyh.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Description: TyhDesignTestApplication
 * @Author: 青衣醉
 * @Date: 2023/4/28 4:40 下午
 */
@SpringBootApplication
@EnableAsync(proxyTargetClass=true)
public class TyhDesignTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TyhDesignTestApplication.class, args);
    }
}
