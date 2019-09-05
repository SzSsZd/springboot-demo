package com.hanz.stuspringbootdemo;

import com.hanz.stuspringbootdemo.domain.Permission;
import com.hanz.stuspringbootdemo.domain.Role;
import com.hanz.stuspringbootdemo.domain.User;
import com.hanz.stuspringbootdemo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    public void getAllQXByUserName() {
        Map<String, Object> all = userService.getAllQXByUserName("shiroTest");
        for (String key : all.keySet()) {
            String row = "role_name：" + key;
            List<Permission> obj = (List) all.get(key);
            row += ",permisson:";
            for (Permission p : obj) {
                row += p.getPermission() + ",";
            }
            System.out.println(row);
        }
    }

}
