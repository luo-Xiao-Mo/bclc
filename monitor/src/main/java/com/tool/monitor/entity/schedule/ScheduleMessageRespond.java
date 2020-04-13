package com.tool.monitor.entity.schedule;

import com.tool.monitor.entity.RespondResult;

import java.util.List;

public class ScheduleMessageRespond extends RespondResult {
    private List<ScheduleMessage> data;

    public List<ScheduleMessage> getData() {
        return data;
    }

    public void setData(List<ScheduleMessage> data) {
        this.data = data;
    }
}
