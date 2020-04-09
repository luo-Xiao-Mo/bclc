package com.tool.monitor.service;

import com.tool.monitor.controller.param.SystemInfoParm;
import com.tool.monitor.core.result.Result;

public interface SystemInfoService {

    Result infoToTransfer(SystemInfoParm systemInfoParm);
}
