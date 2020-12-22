package com.blockchain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.blockchain.feign")
public class AppMessage {
    public static void main(String[] args) {
        SpringApplication.run(AppMessage.class, args);
    }
}
