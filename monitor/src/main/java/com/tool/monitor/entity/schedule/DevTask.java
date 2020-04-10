package com.tool.monitor.entity.schedule;

import java.util.Date;

;

public class DevTask {
    //开发任务号
    private String dvlpTaskNum;
    //计划开发开始时间
    private Date planStartTime;
    //计划开发完成时间
    private Date planFinishTime;
    //实际开始时间
    private Date startTime;
    //实际结束时间
    private Date finishTime;
    //开发任务状态Id
    private int devTaskStatusId;
    //开发任务状态名称
    private String devTaskStatusName;
    //开发任务负责人
    private String devTaskOwner;
    //系统名称
    private String devTaskName;

    public String getDvlpTaskNum() {
        return dvlpTaskNum;
    }

    public void setDvlpTaskNum(String dvlpTaskNum) {
        this.dvlpTaskNum = dvlpTaskNum;
    }

    public Date getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    public Date getPlanFinishTime() {
        return planFinishTime;
    }

    public void setPlanFinishTime(Date planFinishTime) {
        this.planFinishTime = planFinishTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public int getDevTaskStatusId() {
        return devTaskStatusId;
    }

    public void setDevTaskStatusId(int devTaskStatusId) {
        this.devTaskStatusId = devTaskStatusId;
    }

    public String getDevTaskStatusName() {
        return devTaskStatusName;
    }

    public void setDevTaskStatusName(String devTaskStatusName) {
        this.devTaskStatusName = devTaskStatusName;
    }

    public String getDevTaskOwner() {
        return devTaskOwner;
    }

    public void setDevTaskOwner(String devTaskOwner) {
        this.devTaskOwner = devTaskOwner;
    }

    public String getDevTaskName() {
        return devTaskName;
    }

    public void setDevTaskName(String devTaskName) {
        this.devTaskName = devTaskName;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
