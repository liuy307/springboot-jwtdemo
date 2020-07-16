package com.ly.springbootjwtdemo.controller;

import com.ly.springbootjwtdemo.entity.User;
import com.ly.springbootjwtdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("userApi")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/index")
    public List<User> sayHello() {
        List<User> users = userService.list();
        return users;
    }
}
