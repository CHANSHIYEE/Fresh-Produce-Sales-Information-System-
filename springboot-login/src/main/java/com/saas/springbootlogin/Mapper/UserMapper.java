package com.saas.springbootlogin.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.saas.springbootlogin.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/*
 * 1.使用@Mapper注解 ，代表这个接口被mybatis接管
 * 2.继承BaseMapper<属性类名>
 * */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT * FROM user WHERE username = #{username} limit 1")
    User findByUname(@Param("username") String username); //通过用户名uname查找用户

    @Select("SELECT * FROM user WHERE uname = #{username} AND password = #{password}")
    User findByUsernameAndPassword(@Param("username") String uname, @Param("password") String password); //通过用户名uname和密码查找用户

    void insertSelective(User user);

    User findByName(String username);
}
/*
 * @Mapper：注解是 MyBatis 框架中的一个重要标识，
 * 它定义了 Mapper 接口，用于与数据库交互。使用这个注解可以简化数据库操作代码，并提供一些优势，
 * 如自动生成 SQL、类型安全性等。
 * */
