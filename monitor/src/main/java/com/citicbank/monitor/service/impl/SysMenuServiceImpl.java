package com.citicbank.monitor.service.impl;

import com.citicbank.monitor.entity.generate.SysMenu;
import com.citicbank.monitor.entity.generate.SysRole;
import com.citicbank.monitor.mapper.SysMenuMapper;
import com.citicbank.monitor.mapper.SysRoleMapper;
import com.citicbank.monitor.service.SysMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Resource
    private SysMenuMapper mapper;

    @Override
    public List<SysMenu> getMenusByUserId(String userId) {
        return mapper.getMenusByUserId(userId);
    }
}
