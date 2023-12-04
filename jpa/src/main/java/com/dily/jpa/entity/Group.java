package com.dily.jpa.entity;

import jakarta.persistence.*;
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
@Entity
@Table(name = "t_group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    // 单向关联
//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "group_id")
    @OneToMany(mappedBy = "group", fetch = FetchType.EAGER)
    List<Student> studentList;

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
