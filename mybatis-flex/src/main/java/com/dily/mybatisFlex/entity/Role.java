package com.dily.mybatisFlex.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.RelationManyToMany;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.util.List;

/**
 * Student
 * Date: 2023-11-29 星期三
 * Time: 10:50
 * Author: Dily_Su
 * Remark: 角色
 */
@Data
@Table(value = "t_role")
public class Role {
    @Id(keyType = KeyType.Auto)
    private Integer id;

    private String name;

    @RelationManyToMany(joinTable = "t_user_role",
            joinSelfColumn = "role_id",
            joinTargetColumn = "user_id")
    private List<User> userList;

}
