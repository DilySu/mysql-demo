package com.dily.mybatisPlus.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dily.mybatisPlus.entity.Student;
import com.dily.mybatisPlus.enums.GradeEnum;
import com.dily.mybatisPlus.mapper.StudentRepo;
import com.dily.mybatisPlus.enums.SexEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ProductController
 * Date: 2023-11-29 星期三
 * Time: 15:25
 * Author: Dily_Su
 * Remark:
 */
@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;
    @GetMapping("get")
    public Student get (){
        Student student = new Student();
        student.setSex(SexEnum.MALE);
        student.setGrade(GradeEnum.PRIMARY);
        return student;
    }

    @GetMapping("list")
    public List<Student> list (){
        return studentRepo.selectList(Wrappers.emptyWrapper());
    }
}
