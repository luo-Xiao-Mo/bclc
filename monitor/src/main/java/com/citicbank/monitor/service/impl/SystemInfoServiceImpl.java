package com.citicbank.monitor.service.impl;

import com.citicbank.monitor.controller.param.SystemInfoParm;
import com.citicbank.monitor.core.result.Result;
import com.citicbank.monitor.core.result.ResultBuilder;
import com.citicbank.monitor.service.SystemInfoService;
import com.citicbank.monitor.util.RestUtil;
import com.citicbank.monitor.util.Singleton;
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
