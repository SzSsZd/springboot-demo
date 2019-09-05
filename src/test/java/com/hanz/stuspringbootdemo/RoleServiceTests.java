package com.hanz.stuspringbootdemo;

import com.hanz.stuspringbootdemo.domain.Role;
import com.hanz.stuspringbootdemo.domain.User;
import com.hanz.stuspringbootdemo.service.RoleService;
import com.hanz.stuspringbootdemo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTests {

    @Autowired
    private RoleService roleService;

    @Test
    public void getRolesByUserName() {
        List<Role> roles = roleService.getRolesByUserName("shiroTest");
        System.out.println(roles.get(0).getRoleName());
    }
}
