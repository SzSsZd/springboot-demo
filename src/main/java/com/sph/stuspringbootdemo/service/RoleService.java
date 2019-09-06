package com.sph.stuspringbootdemo.service;

import com.sph.stuspringbootdemo.domain.Permission;

import java.util.List;

public interface RoleService {
    List<Permission> getPermissionByRoleId(Integer role_id);

    int deleteByPrimaryKey(Integer role_id);

    int insert(Permission record);

    Permission selectByPrimaryKey(Integer role_id);

    int updateByPrimaryKey(Permission record);
}
