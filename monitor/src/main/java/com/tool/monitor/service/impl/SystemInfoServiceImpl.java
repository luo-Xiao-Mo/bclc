package com.tool.monitor.service.impl;

import com.tool.monitor.controller.param.SystemInfoParm;
import com.tool.monitor.core.result.Result;
import com.tool.monitor.core.result.ResultBuilder;
import com.tool.monitor.core.result.ResultCode;
import com.tool.monitor.entity.schedule.ScheduleRespond;
import com.tool.monitor.service.SystemInfoService;
import com.tool.monitor.util.JsonUtil;
import com.tool.monitor.util.RestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.IOException;

@Service
public class SystemInfoServiceImpl implements SystemInfoService {


    @Value(value = "${plmp.base.url}/devOpsSynchroSystemInfo.action")
    private String SystemInfoUrl;
    @Resource
    private RestUtil restUtil;
    private final Logger logger = LoggerFactory.getLogger(ScheduleServiceImpl.class);

    @Override
    public Result infoToTransfer(SystemInfoParm systemInfoParm) {
        String responseStr = restUtil.execute(HttpMethod.POST, SystemInfoUrl, systemInfoParm, null);
        if (!StringUtils.isEmpty(responseStr)) {
            try {
                ScheduleRespond result = JsonUtil.unmarshall(responseStr, ScheduleRespond.class);
                if (result != null && String.valueOf(ResultCode.SUCCESS.getCode()).equals(result.getReturnCode())) {
                    return ResultBuilder.genSuccessResult(result);
                }
            } catch (IOException e) {
                logger.error("响应字符串转对象异常,响应字符串为 = {}", responseStr);
            } catch (Exception e) {
                logger.error("系统信息同步接口失败,错误信息为= {}", e.toString());
            }
        }
        return ResultBuilder.genFailResult("系统信息同步接口查询失败");
    }
}
