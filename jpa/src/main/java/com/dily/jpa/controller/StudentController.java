package com.dily.jpa.controller;

import com.dily.jpa.entity.Student;
import com.dily.jpa.enums.GradeEnum;
import com.dily.jpa.repository.StudentRepo;
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
    @GetMapping
    public Student get (){
        Student student = new Student();
        student.setGrade(GradeEnum.PRIMARY);
        return student;
    }

    @GetMapping("list")
    public List<Student> list (){
        return studentRepo.findAll();
    }
}
