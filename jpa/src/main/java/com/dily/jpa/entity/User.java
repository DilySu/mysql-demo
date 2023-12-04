package com.dily.jpa.entity;

import jakarta.persistence.*;
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
@Entity
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private boolean deleted;

    @OneToOne
    @JoinColumn(name = "user_info_id",referencedColumnName = "id") // referencedColumnName 可省略，默认使用主键
    private UserInfo userInfo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "t_user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
