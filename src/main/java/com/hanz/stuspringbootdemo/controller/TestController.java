package com.hanz.stuspringbootdemo.controller;

import com.hanz.stuspringbootdemo.config.jedis.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import java.util.Map;

@RestController
public class TestController {
    @RequestMapping(value = "/test")
    public Object test() {
        return "hello world!";
    }

    //rest接口
    @RequestMapping("/restTest/{name}")
    public Object restTest(@PathVariable String name) {
        return "restTest" + name;
    }

    @Autowired
    private JedisUtil jedis;

    @RequestMapping("/restJedis/{val}")
    public Object restJedis(@PathVariable String val) {
        jedis.set("key-" + val, val);
        return "restJedis_OK";
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @RequestMapping("/getJDBC/{id}")
    public Object getJDBC(@PathVariable Integer id) {
        String sql = "select * from test where id = " + id;
        Map<String,Object> data = jdbcTemplate.queryForMap(sql);
        return data;
    }
}
