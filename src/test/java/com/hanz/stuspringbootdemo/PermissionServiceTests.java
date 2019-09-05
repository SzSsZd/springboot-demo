package com.hanz.stuspringbootdemo;

import com.hanz.stuspringbootdemo.domain.Permission;
import com.hanz.stuspringbootdemo.domain.Role;
import com.hanz.stuspringbootdemo.service.PermissionService;
import com.hanz.stuspringbootdemo.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionServiceTests {

    @Autowired
    private PermissionService permissionService;

    @Test
    public void getPermissionsByRoleId() {
       List<Permission> permissions=  permissionService.getPermissionsByRoleId(1);
       System.out.println(permissions.get(0).getPermission());
    }
}
