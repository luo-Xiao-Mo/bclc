package com.tool.monitor.service.impl;

import com.tool.monitor.controller.param.SystemInfoParm;
import com.tool.monitor.core.result.Result;
import com.tool.monitor.core.result.ResultBuilder;
import com.tool.monitor.service.SystemInfoService;
import com.tool.monitor.util.RestUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SystemInfoServiceImpl implements SystemInfoService {


    @Value(value = "${plmp.base.url}/devOpsSynchroSystemInfo.action")
    private String SystemInfoUrl;
    @Resource
    private RestUtil restUtil;

    @Override
    public Result infoToTransfer(SystemInfoParm systemInfoParm) {
        try {
            return restUtil.packExecute(HttpMethod.POST, SystemInfoUrl, systemInfoParm, null);
        } catch (Exception e) {
            return ResultBuilder.genFailResult("服务出现异常");
        }
    }
}
