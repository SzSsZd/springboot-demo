package com.sph.stuspringbootdemo.dao;

import com.sph.stuspringbootdemo.domain.Role;
import com.sph.stuspringbootdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(User record);

    User    selectByName(String name);

    List<Role> getRoleByUserName(String username);
}