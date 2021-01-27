package com.blockchain.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.blockchain.api.service.entity.User;
import com.blockchain.fallback.BlockFallBack;
import com.blockchain.feign.EncryptionServiceFeign;
import com.blockchain.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import util.json.JsonToXmlUtil;
import util.result.Result;
import util.result.ResultBuilder;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private EncryptionServiceFeign encryptionServiceFeign;
    @Autowired
    private BlockFallBack blockFallBack;


    public Result info() {
        return ResultBuilder.genSuccessResult("这是报文转换服务");
    }

    public Result xmlToJsonMessage(String message) {
        User user = new User();
        user.setName(message);
        System.out.println("调用了报文转换服务");
        //调用加密服务
        String result = encryptionServiceFeign.addEncryption(user);
        //调用写链服务
        blockFallBack.downblockchain(message);
        return ResultBuilder.genSuccessResult(result);
    }

    public Result jsonToXmlMessage(String message) {
        User user = new User();
        //调用了解密服务
        encryptionServiceFeign.reduceEncryption(user);
        //返回xml格式
        return ResultBuilder.genSuccessResult(JsonToXmlUtil.jsonToXml(message));
    }
}
