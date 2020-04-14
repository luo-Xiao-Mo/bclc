package com.tool.monitor.entity;

import java.util.List;

public class SysMenuTree {
    private String menuId;
    private String menuName;
    private String url;
    private String parentId;
    private List<SysMenuTree> childNode;

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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<SysMenuTree> getChildNode() {
        return childNode;
    }

    public void setChildNode(List<SysMenuTree> childNode) {
        this.childNode = childNode;
    }
}
