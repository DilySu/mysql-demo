package com.dily.mysql.entity;

import com.dily.mysql.enums.GradeEnum;
import jakarta.persistence.*;
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
@Entity
@Table(name = "t_product")
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Convert(converter = GradeEnum.Converter.class)
    private GradeEnum grade;
}
