package com.dily.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * UserInfo
 * Date: 2023-11-29 星期三
 * Time: 11:01
 * Author: Dily_Su
 * Remark: 用户信息表
 */
@Data
@Entity
@Table(name = "t_user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String organization;

    private String position;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", organization='" + organization + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
