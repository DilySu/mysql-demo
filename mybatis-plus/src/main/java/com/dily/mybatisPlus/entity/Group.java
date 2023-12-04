package com.dily.mybatisPlus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Student
 * Date: 2023-11-29 星期三
 * Time: 10:50
 * Author: Dily_Su
 * Remark: 班级内的组
 */
@Data
@TableName("t_group")
public class Group {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;
}
