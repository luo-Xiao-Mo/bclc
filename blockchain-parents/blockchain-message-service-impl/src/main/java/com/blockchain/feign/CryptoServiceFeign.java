package com.blockchain.feign;

import com.blockchain.api.service.CryptoService;
import com.blockchain.fallback.CryptoFallBack;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "app-encyption", fallback = CryptoFallBack.class)
public interface CryptoServiceFeign extends CryptoService {

}
