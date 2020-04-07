package com.citicbank.monitor.entity;

import java.util.Date;
import java.util.zip.DataFormatException;

public class SystemMember {
    private String systemCode;
    private String memberAccountCbsp;
    private String memberAccountPlmp;
    private String membeNamePlmp;
    private Date addTime;
    private String memberRole;
    private String operateStatus;

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getMemberAccountCbsp() {
        return memberAccountCbsp;
    }

    public void setMemberAccountCbsp(String memberAccountCbsp) {
        this.memberAccountCbsp = memberAccountCbsp;
    }

    public String getMemberAccountPlmp() {
        return memberAccountPlmp;
    }

    public void setMemberAccountPlmp(String memberAccountPlmp) {
        this.memberAccountPlmp = memberAccountPlmp;
    }

    public String getMembeNamePlmp() {
        return membeNamePlmp;
    }

    public void setMembeNamePlmp(String membeNamePlmp) {
        this.membeNamePlmp = membeNamePlmp;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole;
    }

    public String getOperateStatus() {
        return operateStatus;
    }

    public void setOperateStatus(String operateStatus) {
        this.operateStatus = operateStatus;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
