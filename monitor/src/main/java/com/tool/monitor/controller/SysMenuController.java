package com.tool.monitor.controller;

import com.tool.monitor.core.result.Result;
import com.tool.monitor.core.result.ResultBuilder;
import com.tool.monitor.entity.generate.SysMenu;
import com.tool.monitor.entity.generate.SysUser;
import com.tool.monitor.service.SysMenuService;
import com.tool.monitor.util.TreeUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@Validated
@RequestMapping("/sysMenu")
public class SysMenuController {
    @Resource
    private SysMenuService sysMenuService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @RequiresPermissions("sysMenu:list")
    public Result sysMenuList() {
        Session session = SecurityUtils.getSubject().getSession();
        SysUser user = (SysUser) session.getAttribute("user");
        List<SysMenu> menus;
        if (user != null) {
            menus = sysMenuService.getMenusByUserId(user.getUserId());
            TreeUtil treeUtil = new TreeUtil(menus);
            return ResultBuilder.genSuccessResult(treeUtil.builTree());
        }
        return ResultBuilder.genSuccessResult("查询菜单失败");
    }
}
