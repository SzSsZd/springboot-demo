package com.sph.stuspringbootdemo.domain;

import lombok.Data;

@Data
public class Role {
    private Integer id;
    private String role_name;
    private  Integer user_id;
}
