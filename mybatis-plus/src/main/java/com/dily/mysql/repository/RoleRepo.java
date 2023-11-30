package com.dily.mysql.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dily.mysql.entity.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * RoleRepo
 * Date: 2023-11-29 星期三
 * Time: 14:57
 * Author: Dily_Su
 * Remark:
 */
@Mapper
public interface RoleRepo extends BaseMapper<Role> {
}
