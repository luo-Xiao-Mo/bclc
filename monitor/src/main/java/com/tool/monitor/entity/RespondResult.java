package com.tool.monitor.entity;

import com.google.common.base.MoreObjects;

import java.util.List;

public class RespondResult {
    private String returnCode;
    private String returnMsg;
    //多页查询总数
    private String totalNum;
    //多余查询返回记录数
    private String returnNum;

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

    public String getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(String totalNum) {
        this.totalNum = totalNum;
    }

    public String getReturnNum() {
        return returnNum;
    }

    public void setReturnNum(String returnNum) {
        this.returnNum = returnNum;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this.getClass())
                .add("returnCode", returnCode)
                .add("returnMsg", returnMsg)
                .add("totalNum", totalNum)
                .add("returnNum", returnNum).toString();
    }
}
