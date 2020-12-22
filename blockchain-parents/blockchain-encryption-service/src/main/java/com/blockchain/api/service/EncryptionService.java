package com.blockchain.api.service;

import com.blockchain.api.service.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public interface EncryptionService {

    /*
     *
     * 字符串加密-user对象为例子
     * */
    @GetMapping("/add")
    String addEncryption(@RequestBody User user);

    /*
     *
     * 字符串解密-user对象为例子
     * */
    @PostMapping("/reduce")
    String reduceEncryption(@RequestBody User user);
}
