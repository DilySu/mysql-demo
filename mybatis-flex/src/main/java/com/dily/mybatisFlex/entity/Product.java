package com.dily.mybatisFlex.entity;

import com.dily.mybatisFlex.enums.GradeEnum;
import com.dily.mybatisFlex.listener.AutoFillListener;
import com.mybatisflex.annotation.ColumnMask;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.core.mask.MaskManager;
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
@Table(value = "t_product", onInsert = AutoFillListener.class, onUpdate = AutoFillListener.class)
public class Product extends BaseEntity {
    @Id(keyType = KeyType.Auto)
    private Integer id;

    private String name;

    private GradeEnum grade;
}
