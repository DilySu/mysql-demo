package com.dily.mybatisFlex.controller;

import com.dily.mybatisFlex.entity.Student;
import com.dily.mybatisFlex.enums.GradeEnum;
import com.dily.mybatisFlex.mapper.StudentMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Resource
    private StudentMapper studentRepo;
    @GetMapping
    public Student get (){
        Student student = new Student();
        student.setGrade(GradeEnum.PRIMARY);
        return student;
    }

    @GetMapping("list")
    public List<Student> list (){
        return studentRepo.selectAll();
    }
    @GetMapping("delete/{id}")
    public Integer delete(@PathVariable Integer id){
        return studentRepo.deleteById(id);
    }
}
