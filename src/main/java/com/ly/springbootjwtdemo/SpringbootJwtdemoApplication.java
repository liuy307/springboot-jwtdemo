package com.ly.springbootjwtdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ly.springbootjwtdemo.mapper")
public class SpringbootJwtdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJwtdemoApplication.class, args);
    }

}
