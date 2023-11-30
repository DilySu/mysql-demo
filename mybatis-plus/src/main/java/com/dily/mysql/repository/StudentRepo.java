package com.dily.mysql.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dily.mysql.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * StudentRepo
 * Date: 2023-11-29 星期三
 * Time: 11:16
 * Author: Dily_Su
 * Remark:
 */
@Mapper
public interface StudentRepo extends BaseMapper<Student> {
}
