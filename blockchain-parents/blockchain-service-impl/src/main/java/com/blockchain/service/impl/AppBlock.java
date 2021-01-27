package com.blockchain.service.impl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class AppBlock {
    public static void main(String[] args) {
        SpringApplication.run(AppBlock.class, args);
    }
}
