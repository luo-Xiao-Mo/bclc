package com.blockchain.api.service;

import com.blockchain.api.service.entity.DecryptEntity;
import com.blockchain.api.service.entity.EncryptEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public interface CryptoService {

    /*
     *
     * 字符串加密-user对象为例子
     * */
    @GetMapping("/encrypt")
    String Encrypt(@RequestBody EncryptEntity encryptEntity);

    /*
     *
     * 字符串解密-user对象为例子
     * */
    @PostMapping("/decrypt")
    String Decrypt(@RequestBody DecryptEntity decryptEntity);
}
