package com.dily.mybatisFlex.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.RelationOneToOne;
import com.mybatisflex.annotation.Table;
import lombok.Data;

/**
 * UserInfo
 * Date: 2023-11-29 星期三
 * Time: 11:01
 * Author: Dily_Su
 * Remark: 用户信息表
 */
@Data
@Table(value = "t_user_info")
public class UserInfo {
    @Id(keyType = KeyType.Auto)
    private Integer id;

    private String organization;

    private String position;

    @RelationOneToOne(selfField = "userId", targetField = "id")
    private User user;
    private Integer userId;

}
