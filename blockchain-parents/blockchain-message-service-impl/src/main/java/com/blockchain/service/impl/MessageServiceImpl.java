package com.blockchain.service.impl;

import com.blockchain.api.service.entity.User;
import com.blockchain.feign.EncryptionServiceFeign;
import com.blockchain.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.result.Result;
import util.result.ResultBuilder;


@RestController
public class MessageServiceImpl implements MessageService {

    @Autowired
    private EncryptionServiceFeign encryptionServiceFeign;


    @GetMapping("/")
    public Result info() {
        return ResultBuilder.genSuccessResult("这是报文转换服务");
    }

    @GetMapping("/m1")
    public Result xmlToJsonMessage(@RequestParam String message) {
        User user = new User();
        user.setName(message);
        System.out.println("调用了报文转换服务");
        String result = encryptionServiceFeign.addEncryption(user);
        return ResultBuilder.genSuccessResult(result);
    }

    @GetMapping("/m2")
    public Result jsonToXmlMessage(@RequestParam String message) {
        User user = new User();
        String result = encryptionServiceFeign.reduceEncryption(user);
        return ResultBuilder.genSuccessResult(result);
    }
}
