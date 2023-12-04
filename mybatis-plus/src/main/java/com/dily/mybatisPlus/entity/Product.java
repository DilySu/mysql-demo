package com.dily.mybatisPlus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dily.mybatisPlus.enums.GradeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Student
 * Date: 2023-11-29 星期三
 * Time: 10:50
 * Author: Dily_Su
 * Remark: 产品
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_product")
public class Product extends BaseEntity {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private GradeEnum grade;
}
