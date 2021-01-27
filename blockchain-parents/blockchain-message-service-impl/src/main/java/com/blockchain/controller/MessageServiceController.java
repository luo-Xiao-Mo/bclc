package com.blockchain.controller;

import com.blockchain.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import util.result.Result;
import util.result.ResultBuilder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Slf4j
@RestController
public class MessageServiceController {

    @Resource
    private MessageService messageService;


    @GetMapping("/")
    public Result info() {
        return ResultBuilder.genSuccessResult("这是报文转换服务");
    }

    @GetMapping("/xmlToJson")
    public Result xmlToJsonMessage(@RequestParam String message) {
        return messageService.xmlToJsonMessage(message);
    }

    @PostMapping("/jsonToXml")
    public Result jsonToXmlMessage(HttpServletRequest request) {
        StringBuffer xml = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    request.getInputStream(), "UTF-8"));
            String buffer;
            while ((buffer = br.readLine()) != null) {
                xml.append(buffer);
            }
        } catch (Exception e) {
            log.error("request请求对象里面获取数据失败");
        }
        String requestMessage = xml.toString();
        return messageService.jsonToXmlMessage(requestMessage);
    }
}
