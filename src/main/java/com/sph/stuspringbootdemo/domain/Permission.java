package com.sph.stuspringbootdemo.domain;

import lombok.Data;

@Data
public class Permission {
    private Integer id;
    private String permission;
    private Integer role_id;
}
