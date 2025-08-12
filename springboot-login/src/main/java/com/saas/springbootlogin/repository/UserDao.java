package com.saas.springbootlogin.repository;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.saas.springbootlogin.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao extends BaseMapper<User> {

    @Select("select * from user where username = #{username} limit 1")
    User findByUserName(@Param("username")String name); //通过用户名uname查找用户，注意要按照JPA的格式使用驼峰命名法

    List<User> selectAll();
    @Select("select * from user where username = #{username} and password =#{password} limit 1")
    User findByUserNameAndPassword(String username, String password);

    void insertSelective(User user);

    User findByName(String username);

    void updateByPrimaryKeyselective(User user);

    void deleteByPrimaryKey(Integer id);
}