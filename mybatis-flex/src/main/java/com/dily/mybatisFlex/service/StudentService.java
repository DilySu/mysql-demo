package com.dily.mybatisFlex.service;

import com.dily.mybatisFlex.entity.Student;
import com.dily.mybatisFlex.mapper.StudentMapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * StudentMapper
 * Date: 2023-08-28 星期一
 * Time: 15:23
 * Author: Dily_Su
 * Remark:
 */
@Service
public class StudentService extends ServiceImpl<StudentMapper, Student> {
}
