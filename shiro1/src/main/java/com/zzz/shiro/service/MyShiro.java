package com.zzz.shiro.service;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

@Service
public class MyShiro extends AuthorizingRealm {


    /**
     * 权限认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录时输入的用户名  
        String loginName = (String) principalCollection.fromRealm(getName()).iterator().next();
        //到数据库查是否有此对象  
        //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //用户的角色集合
        //用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要
        System.out.println("查询权限");
        System.out.println("查询权限");
        System.out.println("查询权限");
        System.out.println("查询权限");
        return info;

    }

    /**
     * 登录认证;
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authenticationToken) throws AuthenticationException {
        //UsernamePasswordToken对象用来存放提交的登录信息  
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //查出是否有此用户  
        if ("zhangsan".equals(token.getUsername())) {
            //若存在，将此用户存放到登录认证info中  
            return new SimpleAuthenticationInfo("zhangsan", "123456", getName());
        }
        return null;
    }

}  