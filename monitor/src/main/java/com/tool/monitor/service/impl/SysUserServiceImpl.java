package com.tool.monitor.service.impl;

import com.tool.monitor.entity.generate.SysUser;
import com.tool.monitor.mapper.SysUserMapper;
import com.tool.monitor.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getUserByUsername(String username) {
        return sysUserMapper.selectByUserName(username);
    }
}
