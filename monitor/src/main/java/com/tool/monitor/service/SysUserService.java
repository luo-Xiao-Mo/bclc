package com.tool.monitor.service;

import com.tool.monitor.entity.generate.SysUser;

public interface SysUserService {

    SysUser getUserByUsername(String username);
}
