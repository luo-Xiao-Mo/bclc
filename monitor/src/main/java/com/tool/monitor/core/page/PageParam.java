package com.tool.monitor.core.page;

import com.google.common.base.MoreObjects;

public class PageParam {

    //页码，首页为1
    private Integer startPage;

    private static Integer FIRST_ONE = 1;

    private static Integer FIRST_NUM = 10;

    //多页查询标识
    private Integer isMutiPage;

    //每页条数
    private Integer mutiNum;

    public void setStartPage(Integer startPage) {
        this.startPage = startPage;
    }

    public Integer getStartPage() {
        return (startPage == null || startPage.compareTo(FIRST_ONE) < 0) ? FIRST_ONE : startPage;
    }

    public Integer getMutiNum() {
        return (mutiNum == null || mutiNum.compareTo(FIRST_ONE) < 0) ? FIRST_NUM : mutiNum;
    }

    public void setMutiNum(Integer mutiNum) {
        this.mutiNum = mutiNum;
    }

    public Integer getIsMutiPage() {
        return (isMutiPage == null) ? FIRST_ONE : isMutiPage;
    }

    public void setIsMutiPage(Integer isMutiPage) {
        this.isMutiPage = isMutiPage;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this.getClass())
                .add("startPage", startPage)
                .add("mutiNum", mutiNum)
                .add("isMutiPage", isMutiPage).toString();
    }
}
