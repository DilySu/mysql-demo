package com.dily.mybatisPlus.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * BaseEntity
 * Date: 2023-11-29 星期三
 * Time: 10:54
 * Author: Dily_Su
 * Remark: 自动填充抽象类
 */
@Data
public abstract class  BaseEntity implements Serializable {
    // 创建人
    @TableField(fill = FieldFill.INSERT)
    private String createdBy;
    // 创建时间
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdTime;
    // 更新人
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updatedBy;
    // 更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedTime;
}
