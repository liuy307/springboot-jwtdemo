package com.ly.springbootjwtdemo.serviceImpl;

import com.ly.springbootjwtdemo.entity.User;
import com.ly.springbootjwtdemo.mapper.UserMapper;
import com.ly.springbootjwtdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> list() {
        return userMapper.listAllUsers();
    }
}
