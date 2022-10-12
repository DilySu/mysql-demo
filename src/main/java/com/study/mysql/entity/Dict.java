package com.study.mysql.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * Date: 2022-09-21 星期三
 * Time: 13:55
 * Author: Dily_Su
 * Remark:
 */
@Data
//@TableName("t_dict")
public class Dict {

    private UUID id;
    private String status;
    private String value;
}
