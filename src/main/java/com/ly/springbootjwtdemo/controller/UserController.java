package com.ly.springbootjwtdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.ly.springbootjwtdemo.annotation.UserLoginToken;
import com.ly.springbootjwtdemo.entity.User;
import com.ly.springbootjwtdemo.service.UserService;
import com.ly.springbootjwtdemo.serviceImpl.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("userApi")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    TokenServiceImpl tokenServiceImpl;

    @RequestMapping("/index")
    public List<User> sayHello() {
        List<User> users = userService.list();
        return users;
    }

    @PostMapping("/login")
    public Object login( User user){
        JSONObject jsonObject=new JSONObject();
        User userForBase=userService.getByUsername(user);
        if(userForBase==null){
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }else {
            if (!userForBase.getPassword().equals(user.getPassword())){
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
            }else {
                String token = tokenServiceImpl.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }
}
