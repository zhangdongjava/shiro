package com.zzz.shiro.ctrl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dell_2 on 2016/10/9.
 */
@Controller

public class TestController {
    @ResponseBody
    @RequestMapping("test")
    @RequiresPermissions("test")
    public String test(){
        return "test页面";
    }
    @RequestMapping("login")
    public String login(){
        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan","123456");
        user.login(token);
        System.out.println("login123");
        return "login";
    }
    @ResponseBody
    @RequestMapping("admin/common/exceptionLog")
    public String exceptionLog(){
        return "not permission";
    }
}
