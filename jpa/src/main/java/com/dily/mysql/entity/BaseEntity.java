package com.dily.mysql.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

/**
 * BaseEntity
 * Date: 2023-11-29 星期三
 * Time: 10:54
 * Author: Dily_Su
 * Remark:
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class  BaseEntity implements Serializable {
    // 创建人
    @CreatedBy
    @Column(length = 50)
    private String createdBy;
    // 创建时间
//    @CreatedDate
    @CreationTimestamp
    private Date createdTime;
    // 更新人
    @LastModifiedBy
    @Column(length = 50)
    private String updatedBy;
    // 更新时间
//    @LastModifiedDate
    @UpdateTimestamp
    private Date updatedTime;
}
