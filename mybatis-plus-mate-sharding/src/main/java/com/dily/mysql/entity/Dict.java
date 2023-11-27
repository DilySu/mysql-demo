package com.dily.mysql.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.UUID;

/**
 * Date: 2022-09-21 星期三
 * Time: 13:55
 * Author: Dily_Su
 * Remark:
 */
@Data
@TableName
public class Dict {

    private UUID id;
    private String status;
    private String value;
}
