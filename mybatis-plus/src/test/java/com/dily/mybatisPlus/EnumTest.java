package com.dily.mybatisPlus;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dily.mybatisPlus.entity.Product;
import com.dily.mybatisPlus.entity.Student;
import com.dily.mybatisPlus.enums.GradeEnum;
import com.dily.mybatisPlus.enums.SexEnum;
import com.dily.mybatisPlus.mapper.ProductRepo;
import com.dily.mybatisPlus.mapper.StudentRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * EnumTest
 * Date: 2023-11-29 星期三
 * Time: 15:56
 * Author: Dily_Su
 * Remark:
 */
@SpringBootTest
public class EnumTest {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ProductRepo productRepo;
    /// ========= 方式一 =========================
    @Test // 枚举转json
    public void enum2Json () throws JsonProcessingException {
        Student student = new Student();
        student.setGrade(GradeEnum.HIGH);
        System.out.println(new ObjectMapper().writeValueAsString(student));
    }

    @Test
    public void db2Enum () {
        List<Product> all = productRepo.selectList(Wrappers.emptyWrapper());
        System.out.println(all.get(0));
    }

    @Test
    public void enum2Db (){
        Product product = new Product();
        product.setGrade(GradeEnum.PRIMARY);
        productRepo.insert(product);
    }

    /// ========= 方式二 =========================

    @Test // 枚举转json
    public void enum2Json2 () throws JsonProcessingException {
        Student student = new Student();
        student.setSex(SexEnum.MALE);
        System.out.println(new ObjectMapper().writeValueAsString(student));
    }

    @Test
    public void db2Enum2 () {
        List<Student> all = studentRepo.selectList(Wrappers.emptyWrapper());
        System.out.println(all.get(0));
    }

    @Test
    public void enum2Db2 (){
        Student student = new Student();
        student.setSex(SexEnum.MALE);
        studentRepo.insert(student);
    }
}
