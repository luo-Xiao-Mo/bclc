package com.tool.monitor.core;

import com.tool.monitor.entity.generate.SysMenu;
import com.tool.monitor.entity.generate.SysRole;
import com.tool.monitor.entity.generate.SysUser;
import com.tool.monitor.service.SysMenuService;
import com.tool.monitor.service.SysRoleService;
import com.tool.monitor.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysRoleService sysRoleService;
    @Resource
    private SysMenuService sysMenuService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        SysUser user = (SysUser) principalCollection.getPrimaryPrincipal();
        List<SysRole> roles = sysRoleService.getRolesByUserId(user.getUserId());
        List<SysMenu> menus = sysMenuService.getMenusByUserId(user.getUserId());
        simpleAuthorizationInfo.addRoles(roles.stream().map(SysRole::getRoleName).collect(Collectors.toSet()));
        simpleAuthorizationInfo.addStringPermissions(menus.stream().map(SysMenu::getPerms).collect(Collectors.toSet()));
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        String username = token.getUsername();
        String username = (String) authenticationToken.getPrincipal();
        SysUser user = sysUserService.getUserByUsername(username);
        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误");
        }
//        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
//                user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName()
//        );
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("user", user);
        return simpleAuthenticationInfo;
    }

    /**
     * 清理缓存权限
     */
    public void clearCachedAuthorizationInfo() {
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }
}
