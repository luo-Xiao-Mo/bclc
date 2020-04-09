package com.tool.monitor.service;

import com.tool.monitor.entity.generate.SysRole;

import java.util.List;

public interface SysRoleService {

    List<SysRole> getRolesByUserId(String userId);
}
