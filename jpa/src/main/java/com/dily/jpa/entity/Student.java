package com.dily.jpa.entity;

import com.dily.jpa.enums.GradeEnum;
import jakarta.persistence.*;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

/**
 * Student
 * Date: 2023-11-29 星期三
 * Time: 10:50
 * Author: Dily_Su
 * Remark: 学生
 */
@Data
@Entity
@Table(name = "t_student")
@SecondaryTable(name = "t_student_info",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "student_id")
)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String sex;

    private String age;

    @Column(table = "t_student_info")
    private String birthDay;

    // 枚举
//    @Enumerated(EnumType.STRING)
    private GradeEnum grade;

    private boolean deleted;

    // 单向关联
//    @ManyToOne
//    @JoinColumn(name = "group_id")
    // 双向关联
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "group_id")
    private Group group;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", grade='" + grade + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
