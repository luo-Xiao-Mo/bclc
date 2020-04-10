package com.tool.monitor.entity;

import java.util.List;

public class SysMenuTree {
    private String menuId;
    private String menuName;
    private String url;
    private List<SysMenuTree> sysMenuTreeList;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<SysMenuTree> getSysMenuTreeList() {
        return sysMenuTreeList;
    }

    public void setSysMenuTreeList(List<SysMenuTree> sysMenuTreeList) {
        this.sysMenuTreeList = sysMenuTreeList;
    }
}
