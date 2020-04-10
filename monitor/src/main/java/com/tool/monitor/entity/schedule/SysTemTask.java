package com.tool.monitor.entity.schedule;

import java.util.List;

public class SysTemTask {
    private String systemTaskName;
    private String systemTaskNo;
    private String systemTaskOwner;
    private String systemName;
    private List<DevTask> devTaskList;

    public String getSystemTaskName() {
        return systemTaskName;
    }

    public void setSystemTaskName(String systemTaskName) {
        this.systemTaskName = systemTaskName;
    }

    public String getSystemTaskNo() {
        return systemTaskNo;
    }

    public void setSystemTaskNo(String systemTaskNo) {
        this.systemTaskNo = systemTaskNo;
    }

    public String getSystemTaskOwner() {
        return systemTaskOwner;
    }

    public void setSystemTaskOwner(String systemTaskOwner) {
        this.systemTaskOwner = systemTaskOwner;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public List<DevTask> getDevTaskList() {
        return devTaskList;
    }

    public void setDevTaskList(List<DevTask> devTaskList) {
        this.devTaskList = devTaskList;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
