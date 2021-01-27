package com.blockchain.service.impl;

import com.blockchain.api.service.BlockChainService;

public class BlockChainServiceImpl implements BlockChainService {
    @Override
    public String upblockchain(String message) {
        System.out.println("调用了加密服务");
        return null;
    }

    @Override
    public String downblockchain(String messageg) {
        System.out.println("调用了解密服务");
        return null;
    }
}
