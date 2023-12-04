package com.dily.mybatisPlus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * UserInfo
 * Date: 2023-11-29 星期三
 * Time: 11:01
 * Author: Dily_Su
 * Remark: 用户信息表
 */
@Data
@TableName("t_user_info")
public class UserInfo {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String organization;

    private String position;
}
