package com.dily.mybatisFlex.entity;

import com.dily.mybatisFlex.enums.GradeEnum;
import com.mybatisflex.annotation.*;
import com.mybatisflex.core.mask.MaskManager;
import com.mybatisflex.core.mask.Masks;
import lombok.Builder;
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

    @ColumnMask(Masks.CHINESE_NAME)
    private String name;

    @ColumnMask("sexMask")
    private String sex;

    static {
        MaskManager.registerMaskProcessor("sexMask", data -> "*");
    }

    private String age;

    // 枚举
    private GradeEnum grade;

    @Column(isLogicDelete = true)
    private boolean deleted;

    // 单向关联
    // 双向关联
    @RelationManyToOne(selfField = "groupId", targetField = "id")
    private Group group;
    private Integer groupId;
    @Column(ignore = true)
    private Integer maxAge;

    @Column(ignore = true)
    private Integer avgAge;
}
