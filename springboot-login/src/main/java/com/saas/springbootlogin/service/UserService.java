package com.saas.springbootlogin.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.saas.springbootlogin.entity.User;
import com.saas.springbootlogin.Mapper.UserMapper;
import com.saas.springbootlogin.exception.CustomException;
import com.saas.springbootlogin.repository.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    private UserDao userDao;

    public List<User> findAll() {
        return userDao.selectAll();
    }
    public void update (User user) { userDao.updateByPrimaryKeyselective(user);}
    public void delete (Integer id) {
        userDao.deleteByPrimaryKey(id);}

    public void add(User user) {
        //1. 進行重複性判斷，統一名字的管理員不許重複新增：只要去數據庫查詢名字
        if (user.getUsername() == null || "".equals(user.getUsername())){
            throw new CustomException("用戶名不能為空");
        }
        User admin = userDao.findByName(user.getUsername());
        if (admin != null) {
            //說明重複了，提示不許新增
            throw new CustomException("該用戶名已存在，請勿重複添加");
        }
        //初始化密碼
        if (user.getPassword() == null) {
            user.setPassword("123456");
        }
        userDao.insertSelective(user);
    }

    public User login(User user) {
        //進行一些非空判斷
        if(user.getUsername()==null)
            if (user.getUsername() == null || "".equals(user.getUsername())){
                throw new CustomException("用戶名不能為空");
            };
            if (user.getPassword() == null || "".equals(user.getPassword())){
            throw new CustomException("密碼不能為空");
            }
            User admin =userDao.findByUserNameAndPassword(user.getUsername(), user.getPassword());
            if (user == null){
                throw new CustomException("用戶名或密碼輸入錯誤");
            }
                return user;
    }

}