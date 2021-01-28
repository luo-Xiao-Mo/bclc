package com.blockchain.service.impl;

import com.blockchain.api.service.entity.EncryptEntity;
import com.blockchain.fallback.BlockFallBack;
import com.blockchain.feign.CryptoServiceFeign;
import com.blockchain.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.json.JsonToXmlUtil;
import util.result.Result;
import util.result.ResultBuilder;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private CryptoServiceFeign encryptionServiceFeign;
    @Autowired
    private BlockFallBack blockFallBack;


    public Result info() {
        return ResultBuilder.genSuccessResult("这是报文转换服务");
    }

    public Result xmlToJsonMessage(String message) {
        EncryptEntity encryptEntity = new EncryptEntity();
        encryptEntity.setName(message);
        System.out.println("调用了报文转换服务");
        //调用加密服务
        String result = encryptionServiceFeign.addEncryption(encryptEntity);
        //调用写链服务
        blockFallBack.downblockchain(message);
        return ResultBuilder.genSuccessResult(result);
    }

    public Result jsonToXmlMessage(String message) {
        EncryptEntity encryptEntity = new EncryptEntity();
        //调用了解密服务
        encryptionServiceFeign.Decrypt(encryptEntity);
        //返回xml格式
        return ResultBuilder.genSuccessResult(JsonToXmlUtil.jsonToXml(message));
    }
}
