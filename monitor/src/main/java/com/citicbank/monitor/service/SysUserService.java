package com.citicbank.monitor.service;

import com.citicbank.monitor.entity.generate.SysUser;

public interface SysUserService {

    SysUser getUserByUsername(String username);
}
