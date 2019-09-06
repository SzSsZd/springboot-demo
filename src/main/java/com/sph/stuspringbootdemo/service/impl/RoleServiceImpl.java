package com.sph.stuspringbootdemo.service.impl;

import com.sph.stuspringbootdemo.dao.RoleMapper;
import com.sph.stuspringbootdemo.domain.Permission;
import com.sph.stuspringbootdemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Permission> getPermissionByRoleId(Integer role_id) {
        return roleMapper.getPermissionByRoleId(role_id);
    }

    @Override
    public int deleteByPrimaryKey(Integer role_id) {
        return roleMapper.deleteByPrimaryKey(role_id);
    }

    @Override
    public int insert(Permission record) {
        return roleMapper.insert(record);
    }

    @Override
    public Permission selectByPrimaryKey(Integer role_id) {
        return roleMapper.selectByPrimaryKey(role_id);
    }

    @Override
    public int updateByPrimaryKey(Permission record) {
        return roleMapper.updateByPrimaryKey(record);
    }
}
