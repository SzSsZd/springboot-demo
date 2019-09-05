package com.hanz.stuspringbootdemo.controller;

import com.hanz.stuspringbootdemo.domain.User;
import com.hanz.stuspringbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserContorller {

    @Autowired
    private UserService userService;

    @GetMapping("/addUser/{name}/{password}")
    public Object addUser(@PathVariable String name, @PathVariable String password) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        int count = userService.insert(user);
        if (count > 0)
            result.put("code", 0);
        return result;
    }

    @GetMapping("/updUser/{name}/{password}/{sal}/{id}")
    public Object updUser(@PathVariable String name, @PathVariable String password
            , @PathVariable Double sal, @PathVariable Integer id) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setId(id);
        user.setSal(sal);
        int count = userService.updateByPrimaryKey(user);
        if (count > 0)
            result.put("code", 0);
        return result;
    }

    @GetMapping("/delUserById/{id}")
    public Object delUserById(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        int count = userService.deleteByPrimaryKey(id);
        if (count > 0)
            result.put("code", 0);
        return result;
    }

    @GetMapping("/getUserById/{id}")
    public Object getUserById(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        result.put("payload", userService.selectByPrimaryKey(id));
        return result;
    }
}
