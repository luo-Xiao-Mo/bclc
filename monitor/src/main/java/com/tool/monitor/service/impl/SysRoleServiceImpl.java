package com.tool.monitor.service.impl;

import com.tool.monitor.entity.generate.SysRole;
import com.tool.monitor.mapper.SysRoleMapper;
import com.tool.monitor.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    private SysRoleMapper mapper;

    @Override
    public List<SysRole> getRolesByUserId(String userId) {
        return mapper.getRolesByUserId(userId);
    }
}
