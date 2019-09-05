package com.hanz.stuspringbootdemo.service.impl;

import com.hanz.stuspringbootdemo.dao.PermissionMapper;
import com.hanz.stuspringbootdemo.dao.RoleMapper;
import com.hanz.stuspringbootdemo.dao.UserMapper;
import com.hanz.stuspringbootdemo.domain.Permission;
import com.hanz.stuspringbootdemo.domain.Role;
import com.hanz.stuspringbootdemo.domain.User;
import com.hanz.stuspringbootdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Primary
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }


    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public Map<String, Object> getAllQXByUserName(String username) {
        List<Role> roles = roleMapper.getRolesByUserName(username);
        Map<String, Object> role_map = new HashMap<>();
        for (Role r : roles) {
            role_map.put(r.getRoleName(),permissionMapper.getPermissionsByRoleId(r.getId()));
        }
        return role_map;
    }


}
