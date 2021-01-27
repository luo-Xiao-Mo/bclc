package com.blockchain.fallback;

import com.blockchain.feign.BlockServiceFeign;
import org.springframework.stereotype.Component;

@Component
public class BlockFallBack implements BlockServiceFeign {
    @Override
    public String upblockchain(String message) {
        return "调用写链失败";
    }

    @Override
    public String downblockchain(String messageg) {
        return "调用下链失败";
    }
}
