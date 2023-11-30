package com.dily.mysql.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * User
 * Date: 2023-11-29 星期三
 * Time: 10:47
 * Author: Dily_Su
 * Remark: 用户简表
 */
@Data
@TableName("t_user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;
    private boolean deleted;

}
