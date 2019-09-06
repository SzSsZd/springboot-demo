package com.sph.stuspringbootdemo.dao;

import com.sph.stuspringbootdemo.domain.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    List<Permission> getPermissionByRoleId(Integer role_id);

    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Permission record);
}
