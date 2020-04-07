package com.citicbank.monitor.util;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import com.citicbank.monitor.core.result.Result;
import com.citicbank.monitor.core.result.ResultBuilder;
import com.citicbank.monitor.core.result.ResultCode;
import com.citicbank.monitor.entity.generate.RespondResult;
import com.citicbank.monitor.exception.ServiceException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

@Service
public class RestUtil {
    private final Logger logger = LoggerFactory.getLogger(RestUtil.class);
    @Autowired
    private RestTemplate restTemplate;

    public Result packExecute(HttpMethod httpMethod, String tranUrl, Object
            tranRequest, Object... uriVariables) throws Exception {
        String responseStr = this.execute(httpMethod, tranUrl, tranRequest, uriVariables);
        RespondResult result = this.resolveResponse(responseStr);
        if (result != null && String.valueOf(ResultCode.SUCCESS.getCode()).equals(result.getReturnCode())) {
            return ResultBuilder.genSuccessResult(result);
        } else {
            return ResultBuilder.genFailResult("查询失败");
        }
    }

    private String execute(HttpMethod httpMethod, String tranUrl, Object
            tranRequest, Object... uriVariables) {
        // 校验
        if (httpMethod == null) {
            logger.error("httpMethod is null when executeFftTran");
            throw new ServiceException("交易请求方式不能为空");
        }
        if (StringUtils.isEmpty(tranUrl)) {
            logger.error("tranUrl is empty when executeFftTran");
            throw new ServiceException("交易请求地址不能为空");
        }

        logger.info("request params = [ tranRequest ： {}  ]", tranRequest);

        // 设置头信息
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        List<MediaType> acceptableMediaTypes = new ArrayList<>();
        acceptableMediaTypes.add(MediaType.TEXT_PLAIN);
        headers.setAccept(acceptableMediaTypes);
        // 实例化请求实体
        HttpEntity<Object> requestEntity;
        if (tranRequest != null) {
            requestEntity = new HttpEntity<>(tranRequest, headers);
        } else {
            requestEntity = new HttpEntity<>(headers);
        }

        String requestStr = null;
        try {
            requestStr = JsonUtil.marshall(requestEntity);
        } catch (Exception e) {
            logger.error("marshall tranRequest fail", e);
        }
        logger.info("send request = {}", requestStr);

        // 发送交易请求
        ResponseEntity<String> response = restTemplate.exchange(tranUrl, httpMethod, requestEntity, String.class, uriVariables);

        HttpStatus statusCode = response.getStatusCode();
        String responseStr = response.getBody();
        logger.info("receive response = [ statusCode : {}, tranResponse ： {} ]", statusCode.name(), responseStr);

        // 判断响应状态
        if (!statusCode.is2xxSuccessful()) {
            logger.error("fail [ statusCode : {}, tranRequest ： {} ]", statusCode.name(), tranRequest);

        }
        return responseStr;
    }

    private RespondResult resolveResponse(String responseStr) throws JsonParseException, JsonMappingException, IOException {
        if (StringUtils.isEmpty(responseStr)) {
            return null;
        }
        return JsonUtil.unmarshall(responseStr, RespondResult.class);
    }
}
