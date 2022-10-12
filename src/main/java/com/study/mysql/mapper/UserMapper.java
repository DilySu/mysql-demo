package com.study.mysql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.mysql.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Date: 2022-09-20 星期二
 * Time: 11:17
 * Author: Dily_Su
 * Remark:
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select u.id,u.name,d.value status from user u left join dict d on u.status = d.status")
    public List<User> getUserStatus();

}
