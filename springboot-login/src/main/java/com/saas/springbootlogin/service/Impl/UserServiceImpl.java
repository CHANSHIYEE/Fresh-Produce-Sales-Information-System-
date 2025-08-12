package com.saas.springbootlogin.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.saas.springbootlogin.controller.UserController;
import com.saas.springbootlogin.entity.User;
import com.saas.springbootlogin.Mapper.UserMapper;
import com.saas.springbootlogin.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/*
 * 1.@Service--------使用@Service注解，让人知道这个是服务层
 * 2.extends ServiceImpl<UserMapper, User> ---继承和UserService类里面继承的方法一样，
 * 但是这里面还偷偷藏了UserService自定义的方法
 * 3.implements IUserService---实现接口
 * */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    //登录业务
    //登录校验业务
    //创建用户检查业务等等
    @Autowired
    private UserMapper userMapper; // 使用@Autowired注解进行自动注入

    @Override
    public User loginService(String username, String password) {
        // 根据用户名和密码查询用户
        User user = userMapper.findByUsernameAndPassword(username, password);
        // 清除重要信息
        if (user != null) {
            user.setPassword("");
        }
        return user;
    }

    @Override
    public User registService(User user) {
        // 查询用户名是否已存在
        User existingUser = userMapper.findByUname(user.getUsername());
        if (existingUser != null) {
            // 用户名已存在，无法注册
            return null;
        } else {
            // 保存新用户信息
            userMapper.insert(user);
            // 清除重要信息
            user.setPassword("");
            return user;
        }
    }

    @Override
    public User login(User user) {
        return null;
    }

    @Override
    public User login(String username, String password) {
        return null;
    }

    @Override
    public void add(User user) {

    }

    @Override
    public User success(List<User> list) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void update(User user) {

    }
}


