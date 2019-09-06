package com.sph.stuspringbootdemo.service;


import com.sph.stuspringbootdemo.domain.Role;
import com.sph.stuspringbootdemo.domain.User;

import java.util.List;

public interface UserService {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(User record);

    User    selectByName(String name);

    List<Role> getRoleByUserName(String username);
}
