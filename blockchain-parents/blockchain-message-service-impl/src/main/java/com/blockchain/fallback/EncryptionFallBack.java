package com.blockchain.fallback;

import com.blockchain.api.service.entity.User;
import com.blockchain.feign.EncryptionServiceFeign;
import org.springframework.stereotype.Component;


@Component
public class EncryptionFallBack implements EncryptionServiceFeign {
    @Override
    public String addEncryption(User user) {
        return "调用加密服务失败";
    }

    @Override
    public String reduceEncryption(User user) {
        return "调用解密服务失败";
    }
}
