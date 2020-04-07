package com.citicbank.monitor.service;

import com.citicbank.monitor.entity.generate.SysMenu;


import java.util.List;

public interface SysMenuService {

    List<SysMenu> getMenusByUserId(String userId);
}
