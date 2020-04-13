package com.tool.monitor.controller.param;


import com.google.common.base.MoreObjects;
import com.tool.monitor.core.page.PageParam;

public class ScheduleInfoDetailParm extends PageParam {
    //排期编号
    private String scheduleNo;
    //排期负责人编号
    private String scheduleOwnerNo;

    public String getScheduleNo() {
        return scheduleNo;
    }

    public void setScheduleNo(String scheduleNo) {
        this.scheduleNo = scheduleNo;
    }

    public String getScheduleOwnerNo() {
        return scheduleOwnerNo;
    }

    public void setScheduleOwnerNo(String scheduleOwnerNo) {
        this.scheduleOwnerNo = scheduleOwnerNo;
    }


    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this.getClass())
                .add("scheduleNo", scheduleNo)
                .add("scheduleOwnerNo", scheduleOwnerNo)
                .toString();
    }
}
