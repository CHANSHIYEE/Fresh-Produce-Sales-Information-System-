package com.saas.springbootlogin.controller;

import com.baomidou.mybatisplus.annotation.TableName;
import com.saas.springbootlogin.entity.User;
import com.saas.springbootlogin.service.IUserService;
import com.saas.springbootlogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.bind.annotation.*;
import com.saas.springbootlogin.utils.Result;

import javax.persistence.Table;
import java.util.List;
/*
 * 1.@RestController---添加控制层注解，让springboot知道这是控制层
 * 2.@RequestMapping("/user")--- user代表默认访问路径在/user下可以访问
 * */
@TableName(value = "user")

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired  //4.自动注解
    private IUserService userService;  //3.定义调用服务层的接口

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        User loginUser = userService.login(user);
        return Result.success(loginUser);
    }
    @PostMapping
    public Result save(@RequestBody User user){
        if (user.getId() == null){
            userService.add(user);

        }else{
            userService.update(user);
        }
        return Result.success(user);
    }

    @GetMapping("/{id}")
    public User findAll(){
        List<User> list = userService.findAll();
        return userService.success(list);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id){
        return userService.getById(id);
    }

    /*7.新增和修改
         需要传递body传递全部参数，
        7.1对数据的操作使用@PostMapping，括号里面不定义就代表使用post方式，url访问上面默认路径/user
        7.2自定义一个方法，括号里面使用(@RequestBody 属性类 自定义属性昵称)
        为什么这里用Boolean而不是User，因为对数据的修改希望返回的结果就两种，要么成功，要么失败，所以用布尔值
        @RequestBody这个注解用于映射传递来的json参数映射为到java对象里面，特别是适用与请求体的参数
        7.3然后再用服务层返回获取的saveOrUpdate方法就好了
    */
    @PostMapping
    public Boolean add(@RequestBody User user){
        return userService.saveOrUpdate(user);
    }
    /*
    8.删除的方法
     8.1使用@DeleteMapping注解，因为删除只需要传递一个特定的id给后端就可以了，
     所以括号里面使用("/{id}")
     8.2创建一个自定义的方法，删除也是要么成功要么失败，所以使用Boolean作为返回值
     @PathVariable在上面已经解释过了
     8.3再用服务层次返回对应的方法，括号里面的值就是上面括号里面需要的值
    * */
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id){
        return userService.removeById(id);
    }


}

/*    //修改数据的另一种写法
    @PostMapping("/update")
    public Boolean update(@RequestBody User user){
        return userService.updateById(user);
    }*/