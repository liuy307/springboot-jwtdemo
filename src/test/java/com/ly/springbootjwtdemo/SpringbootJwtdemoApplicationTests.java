package com.ly.springbootjwtdemo;

import com.ly.springbootjwtdemo.controller.UserController;
import com.ly.springbootjwtdemo.entity.User;
import com.ly.springbootjwtdemo.service.UserService;
import com.ly.springbootjwtdemo.serviceImpl.TokenServiceImpl;
import com.ly.springbootjwtdemo.serviceImpl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
//@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootJwtdemoApplicationTests {
    @Autowired
    UserService userService;
    @Autowired
    TokenServiceImpl tokenServiceImpl;
    @Autowired
    UserController userController;

    @Test
    void contextLoads() {
        List<User> result = userService.list();
        User user1 = userService.getById("1");

        user1.setPassword("135");
        User user2 = userService.getByUsername(user1);
        tokenServiceImpl.getToken(result.get(0));

//        userController.login(user1);
//        userController.login(user2);
    }

}
