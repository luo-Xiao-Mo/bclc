package com.citicbank.monitor.service.impl;

import com.citicbank.monitor.entity.generate.SysRole;
import com.citicbank.monitor.entity.generate.SysRoleMenuExample;
import com.citicbank.monitor.mapper.SysRoleMapper;
import com.citicbank.monitor.service.SysRoleService;
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
