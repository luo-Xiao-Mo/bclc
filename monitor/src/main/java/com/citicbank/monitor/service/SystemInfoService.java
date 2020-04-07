package com.citicbank.monitor.service;

import com.citicbank.monitor.controller.param.SystemInfoParm;
import com.citicbank.monitor.core.result.Result;

public interface SystemInfoService {

    Result infoToTransfer(SystemInfoParm systemInfoParm);
}
