package com.dily.mybatisFlex.entity;

import com.mybatisflex.annotation.*;
import lombok.Data;

import java.util.List;

/**
 * User
 * Date: 2023-11-29 星期三
 * Time: 10:47
 * Author: Dily_Su
 * Remark: 用户简表
 */
@Data
@Table(value = "t_user")
public class User {
    @Id(keyType = KeyType.Auto)
    private Integer id;

    private String name;
    private boolean deleted;

    @RelationOneToOne(selfField = "id", targetField = "userId") // selfField 为主键可省略
    private UserInfo userInfo;

    @RelationManyToMany(joinTable = "t_user_role",
            selfField = "id", joinSelfColumn = "user_id",
            targetField = "id", joinTargetColumn = "role_id")
    private List<Role> roles;

}
