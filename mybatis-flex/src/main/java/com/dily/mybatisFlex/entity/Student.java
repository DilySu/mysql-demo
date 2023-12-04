package com.dily.mybatisFlex.entity;

import com.dily.mybatisFlex.enums.GradeEnum;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

/**
 * Student
 * Date: 2023-11-29 星期三
 * Time: 10:50
 * Author: Dily_Su
 * Remark: 学生
 */
@Data
@Table(value = "t_student")
public class Student {
    @Id(keyType = KeyType.Auto)
    private Integer id;

    private String name;

    private String sex;

    private String age;

    // 枚举
//    @Enumerated(EnumType.STRING)
    private GradeEnum grade;

    private boolean deleted;

    // 单向关联
//    @ManyToOne
//    @JoinColumn(name = "group_id")
    // 双向关联
//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn(name = "group_id")
//    private Group group;

//    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", sex='" + sex + '\'' +
//                ", age='" + age + '\'' +
//                ", grade='" + grade + '\'' +
//                ", deleted=" + deleted +
//                '}';
//    }
}
