package com.sph.stuspringbootdemo.domain;

import lombok.Data;

@Data
public class User {
    
    private Integer id;
    private String name;
    private  String password;
    private Double sal;

}
