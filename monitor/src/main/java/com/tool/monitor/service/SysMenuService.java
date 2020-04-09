package com.tool.monitor.service;

import com.tool.monitor.entity.generate.SysMenu;


import java.util.List;

public interface SysMenuService {

    List<SysMenu> getMenusByUserId(String userId);
}
