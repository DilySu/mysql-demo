package com.dily.mysql.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dily.mysql.entity.Group;
import org.apache.ibatis.annotations.Mapper;

/**
 * GroupRepo
 * Date: 2023-11-29 星期三
 * Time: 14:25
 * Author: Dily_Su
 * Remark:
 */
@Mapper
public interface GroupRepo extends BaseMapper<Group> {
}
