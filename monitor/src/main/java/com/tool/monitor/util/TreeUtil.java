package com.tool.monitor.util;

import com.tool.monitor.entity.SysMenuTree;
import com.tool.monitor.entity.generate.SysMenu;
import com.tool.monitor.exception.ServiceException;


import java.util.ArrayList;
import java.util.List;


public class TreeUtil {

    //定义根菜单的父id为0
    private final static String rootParentId = "0";
    private List<SysMenu> menuList;


    public TreeUtil(List<SysMenu> menuList) {
        this.menuList = menuList;
    }

    //建立树形结构
    public List<SysMenuTree> builTree() {
        List<SysMenuTree> treeMenus = new ArrayList<>();
        List<SysMenuTree> rootMenuLists = getRootNode();
        for (SysMenuTree menuNode : rootMenuLists) {
            menuNode = buildChilTree(menuNode);
            treeMenus.add(menuNode);
        }
        return treeMenus;
    }

    //递归，建立子树形结构
    private SysMenuTree buildChilTree(SysMenuTree node) {
        List<SysMenuTree> chilMenus = new ArrayList<>();
        for (SysMenu menuNode : menuList) {
            if (menuNode.getParentId().equals(node.getMenuId())) {
                SysMenuTree sysMenuTree = new SysMenuTree();
                sysMenuTree.setMenuName(menuNode.getMenuName());
                sysMenuTree.setMenuId(menuNode.getMenuId());
                sysMenuTree.setUrl(menuNode.getUrl());
                sysMenuTree.setParentId(node.getMenuId());
                chilMenus.add(buildChilTree(sysMenuTree));
            }
        }
        if (chilMenus.isEmpty()) {
            node.setChildNode(null);
        } else {
            node.setChildNode(chilMenus);
        }
        return node;
    }

    //获取根节点
    private List<SysMenuTree> getRootNode() {
        List<SysMenuTree> rootMenuLists = new ArrayList<>();
        if (menuList.isEmpty()) {
            throw new ServiceException("菜单查询为空");
        }
        for (SysMenu sysMenu : menuList) {
            if (sysMenu.getParentId().equals(rootParentId)) {
                SysMenuTree sysMenuTree = new SysMenuTree();
                sysMenuTree.setMenuName(sysMenu.getMenuName());
                sysMenuTree.setMenuId(sysMenu.getMenuId());
                sysMenuTree.setParentId(rootParentId);
                rootMenuLists.add(sysMenuTree);
            }
        }
        return rootMenuLists;
    }
}
