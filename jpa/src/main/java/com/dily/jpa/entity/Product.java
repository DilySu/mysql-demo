package com.dily.jpa.entity;

import com.dily.jpa.enums.GradeEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

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
@SecondaryTables({
        @SecondaryTable(name = "t_product_info", pkJoinColumns = @PrimaryKeyJoinColumn(name = "product_id")),
        @SecondaryTable(name = "t_product_detail", pkJoinColumns = @PrimaryKeyJoinColumn(name = "product_id"))
})
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Convert(converter = GradeEnum.Converter.class)
    private GradeEnum grade;

    @Column(table = "t_product_info")
    private BigDecimal prices;
    @Column(table = "t_product_detail")
    private String brand;
}
