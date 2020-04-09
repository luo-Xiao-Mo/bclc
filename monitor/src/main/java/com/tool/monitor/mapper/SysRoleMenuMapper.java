package com.tool.monitor.mapper;

import com.tool.monitor.entity.generate.SysRoleMenuExample;
import com.tool.monitor.entity.generate.SysRoleMenuKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleMenuMapper {
    long countByExample(SysRoleMenuExample example);

    int deleteByExample(SysRoleMenuExample example);

    int deleteByPrimaryKey(SysRoleMenuKey key);

    int insert(SysRoleMenuKey record);

    int insertSelective(SysRoleMenuKey record);

    List<SysRoleMenuKey> selectByExample(SysRoleMenuExample example);

    int updateByExampleSelective(@Param("record") SysRoleMenuKey record, @Param("example") SysRoleMenuExample example);

    int updateByExample(@Param("record") SysRoleMenuKey record, @Param("example") SysRoleMenuExample example);
}