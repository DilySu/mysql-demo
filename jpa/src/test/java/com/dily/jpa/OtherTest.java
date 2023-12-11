package com.dily.jpa;

import com.dily.jpa.entity.Group;
import com.dily.jpa.entity.Student;
import com.dily.jpa.enums.GradeEnum;
import com.dily.jpa.repository.GroupRepo;
import com.dily.jpa.repository.StudentRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * OtherTest
 * Date: 2023-12-05 星期二
 * Time: 16:14
 * Author: Dily_Su
 * Remark:
 */
@SpringBootTest
public class OtherTest {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private GroupRepo groupRepo;
    @Test
    public void tst (){
        List<Student> allByUserIdAndGroupIdIn = studentRepo.findAllByAgeAndGroupIdIn(14, List.of(1, 2));
        System.out.println(allByUserIdAndGroupIdIn);
    }

    @Test
    public void save (){
        Student student1 = new Student(); student1.setAge(1);
        Student student2 = new Student(); student2.setAge(2);
        Student student3 = new Student(); student3.setAge(3);
        List<Student> studentList = List.of(student1,student2,student3);
        Group group = new Group(); group.setName("三个学生");
        group.setStudentList(studentList);
        group.getStudentList().forEach(e -> e.setGroup(group));
        groupRepo.save(group);
        studentRepo.saveAll(studentList);
        System.out.println(group);
    }

    @Test
    public void ss (){
        GradeEnum sss = GradeEnum.valueOf("中学");
        System.out.println(sss);
    }
}
