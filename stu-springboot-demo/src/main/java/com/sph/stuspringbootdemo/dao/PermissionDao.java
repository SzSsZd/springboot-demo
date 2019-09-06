package com.sph.stuspringbootdemo.dao;

import com.sph.stuspringbootdemo.domain.Permission;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionDao {
    boolean insert(Permission permission);
    boolean delete(int id);
    boolean update(Permission user);
    Permission    select(int id);
}
