package com.tool.monitor.controller;


import com.tool.monitor.controller.param.SystemInfoParm;
import com.tool.monitor.core.result.Result;
import com.tool.monitor.core.result.ResultBuilder;
import com.tool.monitor.entity.RespondResult;
import com.tool.monitor.entity.SystemInfo;
import com.tool.monitor.service.SystemInfoService;
import com.tool.monitor.util.JsonUtil;
import com.tool.monitor.util.RedisUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Validated
@RequestMapping("/systemInfo")
public class SystemInfoController {

    @Resource
    private SystemInfoService systemInfoService;

    @Value(value = "${systemInfo.info.key}")
    private String systemInfoId;

    @Autowired
    private RedisUtil redisUtils;

    /**
     * 系统信息同步接口
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @RequiresPermissions("systemInfo:list")
    public Result infoList(@RequestBody SystemInfoParm systemInfoParm) {
        boolean hasKey = redisUtils.exists(systemInfoId);
        Result result;
        if (hasKey) {
            Object object = redisUtils.get(systemInfoId);
            return ResultBuilder.genSuccessResult(object.toString());
        } else {
            result = systemInfoService.infoToTransfer(systemInfoParm);
            //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
            redisUtils.set(systemInfoId, result, 10L, TimeUnit.MINUTES);
        }
        return result;
    }

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    @RequiresPermissions("systemInfo:detail")
    public Result infoDetail(@RequestBody SystemInfoParm systemInfoParm) {
        boolean hasKey = redisUtils.exists(systemInfoId);
        if (hasKey) {
            Object object = redisUtils.get(systemInfoId);
            SystemInfo systemInfo = new SystemInfo();
            try {
                RespondResult respondResult = JsonUtil.unmarshall(object.toString(), RespondResult.class);
//                List<Object> list = respondResult.getData();
//                for (Object obj : list) {
//                    systemInfo = (SystemInfo) obj;
//                    //temp写法 需要看每条数据是否存在主键;
//                    if (systemInfoParm.getStsTag().equals(systemInfo.getSameBuild())) {
//                        break;
//                    }
//                }
            } catch (Exception e) {
                return ResultBuilder.genFailResult("查询详情失败");
            }
            return ResultBuilder.genSuccessResult(systemInfo);
        } else {
            return ResultBuilder.genFailResult("查询详情失败");
        }
    }
}
