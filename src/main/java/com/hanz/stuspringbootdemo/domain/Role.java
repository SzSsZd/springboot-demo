package com.hanz.stuspringbootdemo.domain;

import lombok.Data;

import java.util.List;

@Data
public class Role {
    private Integer id;

    private String roleName;

    private Integer userId;

}