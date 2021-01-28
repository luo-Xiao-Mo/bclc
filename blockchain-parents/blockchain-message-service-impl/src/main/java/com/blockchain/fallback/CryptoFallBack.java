package com.blockchain.fallback;

import com.blockchain.api.service.entity.EncryptEntity;
import com.blockchain.feign.CryptoServiceFeign;
import org.springframework.stereotype.Component;


@Component
public class CryptoFallBack implements CryptoServiceFeign {
    @Override
    public String addEncryption(EncryptEntity encryptEntity) {
        return "调用加密服务失败";
    }

    @Override
    public String Decrypt(EncryptEntity encryptEntity) {
        return "调用解密服务失败";
    }
}
