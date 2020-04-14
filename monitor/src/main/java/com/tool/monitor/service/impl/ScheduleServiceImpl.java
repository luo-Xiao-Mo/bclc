package com.tool.monitor.service.impl;

import com.tool.monitor.controller.param.ScheduleInfoDetailParm;
import com.tool.monitor.core.result.Result;
import com.tool.monitor.core.result.ResultBuilder;
import com.tool.monitor.core.result.ResultCode;
import com.tool.monitor.entity.RespondResult;
import com.tool.monitor.entity.schedule.ScheduleMessage;
import com.tool.monitor.entity.schedule.ScheduleMessageRespond;
import com.tool.monitor.entity.schedule.ScheduleRespond;
import com.tool.monitor.entity.schedule.SysTemTask;
import com.tool.monitor.enums.SystemTaskStatus;
import com.tool.monitor.service.ScheduleService;
import com.tool.monitor.util.JsonUtil;
import com.tool.monitor.util.RestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;


@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Value(value = "${plmp.base.url}/getDevTaskInfoByScheduleNo.action")
    private String scheduleTaskUrl;
    @Value(value = "${plmp.base.url}/getScheduleInfoList.action")
    private String scheduleMessageUrl;
    @Resource
    private RestUtil restUtil;
    private final Logger logger = LoggerFactory.getLogger(ScheduleServiceImpl.class);

    @Override
    public Result taskByScheduleNo(String scheduleNo) {
        String responseStr = restUtil.execute(HttpMethod.POST, scheduleTaskUrl, scheduleNo, null);
        if (!StringUtils.isEmpty(responseStr)) {
            try {
                ScheduleRespond result = JsonUtil.unmarshall(responseStr, ScheduleRespond.class);
                if (result != null && String.valueOf(ResultCode.SUCCESS.getCode()).equals(result.getReturnCode())) {
                    return ResultBuilder.genSuccessResult(result.getSysTemTaskList());
                }
            } catch (IOException e) {
                logger.error("响应字符串转对象异常,响应字符串为 = {}", responseStr);
            } catch (Exception e) {
                logger.error("查询排期关联系统的开发任务失败,排期编号 = {},错误信息为= {}", scheduleNo, e.toString());
            }
        }
        return ResultBuilder.genFailResult("查询排期关联系统的开发任务失败");
    }

    @Override
    public Result MessageByScheduleNo(ScheduleInfoDetailParm scheduleInfoDetailParm) {
        String responseStr = restUtil.execute(HttpMethod.POST, scheduleMessageUrl, scheduleInfoDetailParm, null);
        if (!StringUtils.isEmpty(responseStr)) {
            try {
                ScheduleMessageRespond result = JsonUtil.unmarshall(responseStr, ScheduleMessageRespond.class);
                if (result != null && String.valueOf(ResultCode.SUCCESS.getCode()).equals(result.getReturnCode())) {
                    List<ScheduleMessage> list = result.getData();
                    if (!list.isEmpty()) {
                        for (ScheduleMessage scheduleMessage : list) {
                            scheduleMessage.setStatusString(SystemTaskStatus.getEnumType(scheduleMessage.getStatus()));
                        }
                    }
                    return ResultBuilder.genSuccessResult(list);
                }
            } catch (IOException e) {
                logger.error("响应字符串转对象异常,响应字符串为 = {}", responseStr);
            } catch (Exception e) {
                logger.error("排期信息查询接口查询失败,错误信息为= {}", e.toString());
            }
        }
        return ResultBuilder.genFailResult("排期信息查询接口查询失败");
    }
}
