package com.dily.mysql.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dily.mysql.enums.GradeEnum;
import com.dily.mysql.enums.SexEnum;
import lombok.Data;

/**
 * Student
 * Date: 2023-11-29 星期三
 * Time: 10:50
 * Author: Dily_Su
 * Remark: 学生
 */
@Data
@TableName("t_student")
public class Student {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private SexEnum sex;

    private String age;

    // 枚举
    private GradeEnum grade;

    private boolean deleted;
}
