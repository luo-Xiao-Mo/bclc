package com.blockchain.feign;

import com.blockchain.api.service.BlockChainService;
import com.blockchain.fallback.BlockFallBack;
import com.blockchain.fallback.EncryptionFallBack;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "app-block", fallback = BlockFallBack.class)
public interface BlockServiceFeign extends BlockChainService {
}
