package com.dily.mybatisFlex;

import com.dily.mybatisFlex.entity.*;
import com.dily.mybatisFlex.mapper.*;
import com.mybatisflex.core.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
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
    private UserMapper userMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private ProductMapper productMapper;

    @Test
    public void one2one() {
        // 单向关联
        List<User> users = userMapper.selectAllWithRelations();
        System.out.println(users);
        // 双向关联
        List<UserInfo> userInfos = userInfoMapper.selectAllWithRelations();
        System.out.println(userInfos);
    }

    @Test
    public void many2OneOrOne2Many() {
        // many2One
        List<Student> students = studentMapper.selectAllWithRelations();
        System.out.println(students);

        // one2Many
        List<Group> groups = groupMapper.selectAllWithRelations();
        System.out.println(groups);
        // 双向关联
        List<Group> groupList = groupMapper.selectAll();
        System.out.println(groupList);
        List<Student> studentList = studentMapper.selectAll();
        System.out.println(studentList);
    }

    @Test
    public void many2Many() {
        // 单向关联
        List<User> users = userMapper.selectAllWithRelations();
        System.out.println(users);
        // 双向关联
        List<Role> roles = roleMapper.selectAllWithRelations();
        System.out.println(roles);
    }

    @Test // 关联查询
    public void associationQuery() {
        // 查询 Student 及对应的 Group
        List<Student> students = studentMapper.selectListByQuery(QueryWrapper.create(),
                fb -> fb.field(Student::getGroup)
                        .queryWrapper(student ->{
                            Group group = new Group();
                            group.setId(student.getId());
                            return QueryWrapper.create(group);
                        })
        );
        System.out.println(students);

        // 查询 Group 及对应的 Student
        List<Group> groups = groupMapper.selectListByQuery(QueryWrapper.create(),
                f -> f.field(Group::getStudentList)
                                .queryWrapper(group -> {
                                    Student student = new Student();
                                    student.setGroupId(group.getId());
                                    return QueryWrapper.create(student);
                                }));
        System.out.println(groups);
    }
}
