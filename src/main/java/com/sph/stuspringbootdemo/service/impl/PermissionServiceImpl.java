package com.sph.stuspringbootdemo.service.impl;

import com.sph.stuspringbootdemo.dao.PermissionDao;
import com.sph.stuspringbootdemo.domain.Permission;
import com.sph.stuspringbootdemo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionDao permissionDao;

    @Override
    public boolean insert(Permission permission) {
        return permissionDao.insert(permission);
    }

    @Override
    public boolean delete(int id) {
        return permissionDao.delete(id);
    }

    @Override
    public boolean update(Permission user) {
        return permissionDao.update(user);
    }

    @Override
    public Permission select(int id) {
        return permissionDao.select(id);
    }
}
