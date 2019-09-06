package com.sph.stuspringbootdemo.controller;


import com.sph.stuspringbootdemo.domain.User;
import com.sph.stuspringbootdemo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShiroController {

    @Autowired
    private UserService userService;

    @RequestMapping("/loginShiro/{username}/{password}")
    public Object loginShiro(@PathVariable String username
            , @PathVariable String password) {
        if (username != null) {
            User user = userService.selectByName(username);
            if (user != null && user.getPassword().equals(password)) {
                //添加用户认证信息
                Subject subject = SecurityUtils.getSubject();
                UsernamePasswordToken usernamePasswordToken
                        = new UsernamePasswordToken(username, password);
                //进行验证，这里可以捕获异常，然后返回对应信息
                subject.login(usernamePasswordToken);
                System.out.println("loginShiro:" + usernamePasswordToken);
                return "loginShiro!";
            }
        }
        //调用过logout后通过setLoginUrl重新进入该方法
        return "it is logout!";
    }

    @RequestMapping("/logout")
    public Object logout() {
        return "logout!";
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "index!";
    }

    @RequestMapping(value = "/errorpage")
    public String error() {
        return "error!";
    }

    @RequestMapping("/testShiro/{test}")
    public Object testShiro(@PathVariable String test) {
        //业务省略。。。
        return "testShiro:success!";
    }

    //认证角色
    @RequestMapping("/testAuthorityRole")
    //,logical = Logical.AND ：两个选一个
    // logical = Logical.OR  ：必须都满足
    @RequiresRoles(value={"学生"},logical = Logical.AND)
    public String testAuthorityRole(){
        System.out.print("testAuthorityRole");
        return "testAuthorityRole:success";
    }
    //认证权限
    @RequestMapping("/testAuthorityPermission")
    @RequiresPermissions(value={"一级","二级"},logical = Logical.AND)
    public String testAuthorityPermission(){
        System.out.print("testAuthorityPermission");
        return "testAuthorityPermission:success";
    }
}