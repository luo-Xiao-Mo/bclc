package com.tool.monitor.entity.schedule;

import java.util.List;

public class ScheduleRespond {
    private String scheduleNo;
    private String scheduleName;
    private String scheduleOwner;
    private String scheduleType;
    private String returnCode;
    private String returnMsg;
    private String returnNum;
    private List<SysTemTask> sysTemTaskList;

    public String getScheduleNo() {
        return scheduleNo;
    }

    public void setScheduleNo(String scheduleNo) {
        this.scheduleNo = scheduleNo;
    }

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public String getScheduleOwner() {
        return scheduleOwner;
    }

    public void setScheduleOwner(String scheduleOwner) {
        this.scheduleOwner = scheduleOwner;
    }

    public String getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(String scheduleType) {
        this.scheduleType = scheduleType;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getReturnNum() {
        return returnNum;
    }

    public void setReturnNum(String returnNum) {
        this.returnNum = returnNum;
    }

    public List<SysTemTask> getSysTemTaskList() {
        return sysTemTaskList;
    }

    public void setSysTemTaskList(List<SysTemTask> sysTemTaskList) {
        this.sysTemTaskList = sysTemTaskList;
    }
}
