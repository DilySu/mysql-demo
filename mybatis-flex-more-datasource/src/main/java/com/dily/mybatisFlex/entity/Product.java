package com.dily.mybatisFlex.entity;

import com.dily.mybatisFlex.enums.GradeEnum;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Student
 * Date: 2023-11-29 星期三
 * Time: 10:50
 * Author: Dily_Su
 * Remark: 产品
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(value = "t_product")
public class Product extends BaseEntity {
    @Id(keyType = KeyType.Auto)
    private Integer id;

    private String name;

    private GradeEnum grade;
}
