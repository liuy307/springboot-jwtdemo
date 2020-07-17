package com.ly.springbootjwtdemo.mapper;

import com.ly.springbootjwtdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//@Mapper
public interface UserMapper {
    List<User> listAllUsers();

    User getByUsername(String username);

    User getById(String id);
}
