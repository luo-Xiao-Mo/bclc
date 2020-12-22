package com.blockchain.service.impl;

import com.blockchain.api.service.EncryptionService;
import com.blockchain.api.service.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncryptionServiceImpl implements EncryptionService {

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/add")
    public String addEncryption(@RequestBody User user) {
        User u = new User();
        u.setAge("123");
        u.setName("这是加密服务");
        System.out.println("端口号为" + serverPort);
        return u.toString();
    }

    @PostMapping("/reduce")
    public String reduceEncryption(@RequestBody User user) {
        User u = new User();
        u.setAge("123");
        u.setName("这是减密服务");
        System.out.println("端口号为" + serverPort);
        return u.toString();
    }
}
