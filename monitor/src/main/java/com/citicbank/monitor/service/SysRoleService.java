package com.citicbank.monitor.service;

import com.citicbank.monitor.entity.generate.SysRole;

import java.util.List;

public interface SysRoleService {

    List<SysRole> getRolesByUserId(String userId);
}
