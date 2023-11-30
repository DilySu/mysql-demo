package com.dily.mysql.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dily.mysql.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * StudentRepo
 * Date: 2023-11-29 星期三
 * Time: 11:16
 * Author: Dily_Su
 * Remark:
 */
@Mapper
public interface UserRepo extends BaseMapper<User> {
}
