package com.tool.monitor.entity.schedule;

import java.util.Date;

public class ScheduleMessage {
    private String scheduleNo;
    private String scheduleName;
    private String scheduleOwnerNo;
    private String scheduleOwnerName;
    private String mainSystemNo;
    private String mainSystemName;
    private String systemCode;
    private Integer scheduleType;
    private Integer status;
    private String statusString;
    private Integer returnNum;
    private Date planOnlineTime;
    private Date realityOnlineTime;

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

    public String getScheduleOwnerNo() {
        return scheduleOwnerNo;
    }

    public void setScheduleOwnerNo(String scheduleOwnerNo) {
        this.scheduleOwnerNo = scheduleOwnerNo;
    }

    public String getScheduleOwnerName() {
        return scheduleOwnerName;
    }

    public void setScheduleOwnerName(String scheduleOwnerName) {
        this.scheduleOwnerName = scheduleOwnerName;
    }

    public String getMainSystemNo() {
        return mainSystemNo;
    }

    public void setMainSystemNo(String mainSystemNo) {
        this.mainSystemNo = mainSystemNo;
    }

    public String getMainSystemName() {
        return mainSystemName;
    }

    public void setMainSystemName(String mainSystemName) {
        this.mainSystemName = mainSystemName;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public Integer getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(Integer scheduleType) {
        this.scheduleType = scheduleType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getReturnNum() {
        return returnNum;
    }

    public void setReturnNum(Integer returnNum) {
        this.returnNum = returnNum;
    }

    public Date getPlanOnlineTime() {
        return planOnlineTime;
    }

    public void setPlanOnlineTime(Date planOnlineTime) {
        this.planOnlineTime = planOnlineTime;
    }

    public Date getRealityOnlineTime() {
        return realityOnlineTime;
    }

    public void setRealityOnlineTime(Date realityOnlineTime) {
        this.realityOnlineTime = realityOnlineTime;
    }

    public String getStatusString() {
        return statusString;
    }

    public void setStatusString(String statusString) {
        this.statusString = statusString;
    }
}
