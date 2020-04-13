package com.tool.monitor.controller;

import com.tool.monitor.controller.param.ScheduleInfoDetailParm;
import com.tool.monitor.core.result.Result;
import com.tool.monitor.core.result.ResultBuilder;
import com.tool.monitor.service.ScheduleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@Validated
@RequestMapping("/schedule")
public class ScheduleInfoController {

    @Resource
    private ScheduleService scheduleService;

    /**
     * 查询排期下关联系统任务
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/task", method = RequestMethod.POST)
    @RequiresPermissions("schedule:task")

    public Result scheduleInfoList(@RequestBody String scheduleNo) {
        if (StringUtils.isEmpty(scheduleNo)) {
            return ResultBuilder.genFailResult("排期编号不能为空");
        }
        return scheduleService.taskByScheduleNo(scheduleNo);
    }

    /**
     * 排期信息的查询接口
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/message", method = RequestMethod.POST)
    @RequiresPermissions("schedule:message")

    public Result scheduleDetail(@RequestBody ScheduleInfoDetailParm scheduleInfoDetailParm) {
        if (StringUtils.isEmpty(scheduleInfoDetailParm.getScheduleNo())) {
            return ResultBuilder.genFailResult("排期编号不能为空");
        }
        if (StringUtils.isEmpty(scheduleInfoDetailParm.getScheduleOwnerNo())) {
            return ResultBuilder.genFailResult("排期负责人不能为空");
        }
        return scheduleService.MessageByScheduleNo(scheduleInfoDetailParm);
    }
}
