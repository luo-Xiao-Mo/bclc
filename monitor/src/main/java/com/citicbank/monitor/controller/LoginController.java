package com.citicbank.monitor.controller;

import com.citicbank.monitor.core.result.Result;
import com.citicbank.monitor.core.result.ResultBuilder;
import com.citicbank.monitor.entity.generate.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody SysUser user) {
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            return ResultBuilder.genFailResult("用户名或密码不能为空");
        }
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        if (subject == null) {
            return ResultBuilder.genFailResult("登录失败");
        }
        try {
            subject.login(token);
        } catch (Exception e) {
            return ResultBuilder.genFailResult("登录异常");
        }
        return ResultBuilder.genSuccessResult("登录成功");
    }

    @RequestMapping(value = "/logout", method = {RequestMethod.POST, RequestMethod.GET})
    public Result logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
        }
        return ResultBuilder.genSuccessResult();
    }

    //成功登录验证
    @RequestMapping(value = "/success", method = RequestMethod.POST)
    public Result success() {
        return ResultBuilder.genSuccessResult();
    }

    //未授权登录验证
    @RequestMapping(value = "/403", method = RequestMethod.POST)
    public Result unauthorize() {
        return ResultBuilder.genUnauthorizedResult("未授权");
    }
}
