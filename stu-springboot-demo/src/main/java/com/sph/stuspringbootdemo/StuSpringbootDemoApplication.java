package com.sph.stuspringbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sph.stuspringbootdemo")
public class StuSpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(StuSpringbootDemoApplication.class, args);
    }

}
