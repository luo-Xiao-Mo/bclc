package com.tool.monitor.mapper;

import com.tool.monitor.entity.generate.SysUserRoleExample;
import com.tool.monitor.entity.generate.SysUserRoleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserRoleMapper {
    long countByExample(SysUserRoleExample example);

    int deleteByExample(SysUserRoleExample example);

    int deleteByPrimaryKey(SysUserRoleKey key);

    int insert(SysUserRoleKey record);

    int insertSelective(SysUserRoleKey record);

    List<SysUserRoleKey> selectByExample(SysUserRoleExample example);

    int updateByExampleSelective(@Param("record") SysUserRoleKey record, @Param("example") SysUserRoleExample example);

    int updateByExample(@Param("record") SysUserRoleKey record, @Param("example") SysUserRoleExample example);
}