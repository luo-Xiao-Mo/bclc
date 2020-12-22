package com.blockchain.feign;

import com.blockchain.api.service.EncryptionService;
import com.blockchain.fallback.EncryptionFallBack;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "app-encyption", fallback = EncryptionFallBack.class)
public interface EncryptionServiceFeign extends EncryptionService {

}
