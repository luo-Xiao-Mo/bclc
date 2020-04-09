package com.tool.monitor.entity;

public class RequestHead {
    //系统标识
    private String sysTag;
    //发起方流水号
    private String sysWorkOrd;
    //多页查询标识 0为不多页 1为多页
    private String isMutiPage;
    //多页查询起始记录号
    private String mutiStart;
    //多页查询每页个数
    private String mutiNum;

    public String getSysTag() {
        return sysTag;
    }

    public void setSysTag(String sysTag) {
        this.sysTag = sysTag;
    }

    public String getSysWorkOrd() {
        return sysWorkOrd;
    }

    public void setSysWorkOrd(String sysWorkOrd) {
        this.sysWorkOrd = sysWorkOrd;
    }

    public String getIsMutiPage() {
        return isMutiPage;
    }

    public void setIsMutiPage(String isMutiPage) {
        this.isMutiPage = isMutiPage;
    }

    public String getMutiStart() {
        return mutiStart;
    }

    public void setMutiStart(String mutiStart) {
        this.mutiStart = mutiStart;
    }

    public String getMutiNum() {
        return mutiNum;
    }

    public void setMutiNum(String mutiNum) {
        this.mutiNum = mutiNum;
    }
}
