package com.dily.mysql;

import com.dily.mysql.entity.*;
import com.dily.mysql.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * mysql
 * Date: 2023-11-29 星期三
 * Time: 11:14
 * Author: Dily_Su
 * Remark: 表关联测试
 */
@SpringBootTest
public class TableAssociation {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserInfoRepo userInfoRepo;

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private GroupRepo groupRepo;

    @Autowired
    private RoleRepo roleRepo;
    @Test
    public void one2one(){
        // 单向关联
//        Iterable<User> users = userRepo.findAll();
//        System.out.println(users);  // 从属性中 可看到 userInfo
        // 双向关联
        Iterable<User> users2 = userRepo.findAll();
        System.out.println(users2);  // 从属性中 可看到 userInfo
        Iterable<UserInfo> userInfos = userInfoRepo.findAll();
        System.out.println(userInfos);
    }

    @Test
    public void many2OneOrOne2Many(){
        // many2One
//        Iterable<Student> students = studentRepo.findAll();
//        System.out.println(students);
        // one2Many
//        Iterable<Group> groups = groupRepo.findAll();
//        System.out.println(groups);
        // 双向关联
        Iterable<Student> students = studentRepo.findAll();
        System.out.println(students);
        Iterable<Group> groups = groupRepo.findAll();
        List<Student> studentList = groups.iterator().next().getStudentList();
        System.out.println(studentList);
    }

    @Test
    public void many2Many(){
        // 单向关联
//        Iterable<User> users = userRepo.findAll();
//        System.out.println(users);

        // 双向关联
        Iterable<User> users = userRepo.findAll();
        List<Role> roleList = users.iterator().next().getRoles();
        System.out.println(roleList);
        Iterable<Role> roles = roleRepo.findAll();
        List<User> userList = roles.iterator().next().getUserList();
        System.out.println(userList);
    }
}
