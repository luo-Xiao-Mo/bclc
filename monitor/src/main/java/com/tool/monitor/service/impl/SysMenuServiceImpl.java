package com.tool.monitor.service.impl;

import com.tool.monitor.entity.generate.SysMenu;
import com.tool.monitor.mapper.SysMenuMapper;
import com.tool.monitor.service.SysMenuService;
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
