package com.tool.monitor.controller;

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
@RequestMapping("/taskSchedule")
public class ScheduleInfoController {

    @Resource
    private ScheduleService scheduleService;

    /**
     * 查询排期下关联系统任务
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @RequiresPermissions("taskSchedule:list")

    public Result infoList(@RequestBody String scheduleNo) {
        if (StringUtils.isEmpty(scheduleNo)) {
            return ResultBuilder.genFailResult("排期编号不能为空");
        }
        return scheduleService.taskByScheduleNo(scheduleNo);
    }
}
