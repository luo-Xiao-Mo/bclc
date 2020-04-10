package com.tool.monitor.service;

import com.tool.monitor.core.result.Result;

public interface ScheduleService {

    //查排期下关联系统的开发任务
    Result taskByScheduleNo(String scheduleNo);
}
