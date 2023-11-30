package com.dily.mysql.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Date: 2022-09-20 星期二
 * Time: 11:17
 * Author: Dily_Su
 * Remark:
 */
@Data
@TableName
public class User {

    private Long id;

    private Long cid;

    private String name;

    private String status;

    @TableField(exist = false)
    private Integer sum;
}
