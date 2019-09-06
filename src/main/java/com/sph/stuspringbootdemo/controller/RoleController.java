package com.sph.stuspringbootdemo.controller;

import com.sph.stuspringbootdemo.domain.Permission;
import com.sph.stuspringbootdemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService rs;

    @GetMapping("/getPermissionByRoleId/{id}")
    public Object getPermissionByRoleId(@PathVariable Integer id){

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        result.put("payload",rs.getPermissionByRoleId(id));
        return result;
    }

    @GetMapping("/addPermission/{permission}/{role_id}")
    public Object addPermission(@PathVariable String permission, @PathVariable Integer role_id) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        Permission p = new Permission();
        p.setPermission(permission);
        p.setRole_id(role_id);
        int count = rs.insert(p);
        if (count > 0)
            result.put("code", 0);
        return result;
    }

    @GetMapping("/updPermission/{permission}/{role_id}/{id}")
    public Object updPermission(@PathVariable String permission, @PathVariable Integer role_id, @PathVariable Integer id) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        Permission p = new Permission();
        p.setRole_id(role_id);
        p.setPermission(permission);
        p.setId(id);
        int count = rs.updateByPrimaryKey(p);
        if (count > 0)
            result.put("code", 0);
        return result;
    }

    @GetMapping("/delPermissionById/{id}")
    public Object delPermissionById(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        int count = rs.deleteByPrimaryKey(id);
        if (count > 0)
            result.put("code", 0);
        return result;
    }

    @GetMapping("/getPermissionById/{id}")
    public Object getPermissionById(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        result.put("payload", rs.selectByPrimaryKey(id));
        return result;
    }
}
