package com.dily.mybatisFlex.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * BaseEntity
 * Date: 2023-11-29 星期三
 * Time: 10:54
 * Author: Dily_Su
 * Remark: 自动填充抽象类
 */


@Data
public abstract class BaseEntity implements Serializable {
//    @Column(onInsertValue = "'测试'")
    // 创建人
    private String createdBy;
    // 创建时间
//    @Column(onInsertValue = "now()")
    private Date createdTime;
    // 更新人
//    @Column(onInsertValue = "'测试'", onUpdateValue = "'测试'")
    private String updatedBy;
    // 更新时间
//    @Column(onInsertValue = "now()", onUpdateValue = "now()")
    private Date updatedTime;
}
