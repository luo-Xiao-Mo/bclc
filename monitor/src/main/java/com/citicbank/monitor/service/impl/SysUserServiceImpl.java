package com.citicbank.monitor.service.impl;

import com.citicbank.monitor.entity.generate.SysUser;
import com.citicbank.monitor.mapper.SysUserMapper;
import com.citicbank.monitor.service.SysUserService;
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