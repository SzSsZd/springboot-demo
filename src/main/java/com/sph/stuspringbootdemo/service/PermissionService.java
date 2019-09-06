package com.sph.stuspringbootdemo.service;


import com.sph.stuspringbootdemo.domain.Permission;
import org.springframework.stereotype.Service;

public interface PermissionService {
    boolean insert(Permission permission);
    boolean delete(int id);
    boolean update(Permission user);
    Permission select(int id);
}
