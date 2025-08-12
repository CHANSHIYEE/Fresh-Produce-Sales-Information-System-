package com.saas.springbootlogin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.saas.springbootlogin.entity.User;

import java.util.List;


//1.继承IService这个接口，<实体类名>
public interface IUserService extends IService<User> {
    /**
     * 登录业务逻辑
     * @param uname 账户名
     * @param password 密码
     * @return
     */
    User loginService(String uname, String password);

    /**
     * 注册业务逻辑
     * @param user 要注册的User对象，属性中主键uid要为空，若uid不为空可能会覆盖已存在的user
     * @return
     */
    User registService(User user);

    default User login(User user){
        //1. 進行非空判斷
        //2. 數據庫根據用戶名和密碼，查詢對應的管理員信息，若有，確實存在，且輸入的用戶名和密碼都對
        //3. 如果查出來沒有，說明輸入的用戶名和密碼有誤，不許登
        return null;
    };

    User login(String username, String password);

    void add(User user);

    User success(List<User> list);

    List<User> findAll();

    void update(User user);
}

/*
IService接口里面有mybatis-plus封装好我们经常会用到的增删改查的一些方法
里面本质上还调用了上数据层mapper，是对mapper的封装优化
*/