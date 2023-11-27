package com.dily.mysql.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dily.mysql.entity.User;
import com.dily.mysql.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TestController
 * Date: 2023-11-22 星期三
 * Time: 15:29
 * Author: Dily_Su
 * Remark:
 */
@RestController
@RequestMapping(("/test"))
public class TestController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/getUser")
    public List<User> getUser (){
        return userMapper.selectList(Wrappers.emptyWrapper());
    }

    @RequestMapping("/saveUser")
    public int saveUser (){
        return userMapper.insert(new User());
    }
}
