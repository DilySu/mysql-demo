package com.dily.mybatisFlex.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.util.List;

/**
 * Student
 * Date: 2023-11-29 星期三
 * Time: 10:50
 * Author: Dily_Su
 * Remark: 班级内的组
 */
@Data
@Table(value = "t_group")
public class Group {
    @Id(keyType = KeyType.Auto)
    private Integer id;

    private String name;

    // 单向关联
//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "group_id")
//    @OneToMany(mappedBy = "group", fetch = FetchType.EAGER)
    List<Student> studentList;
}
