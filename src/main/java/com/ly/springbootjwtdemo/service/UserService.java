package com.ly.springbootjwtdemo.service;

import com.ly.springbootjwtdemo.entity.User;
import java.util.List;

public interface UserService {
    List<User> list();

    User getByUsername(User user);

    User getById(String id);
}
