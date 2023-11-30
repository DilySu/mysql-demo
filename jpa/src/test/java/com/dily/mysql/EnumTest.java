package com.dily.mysql;

import com.dily.mysql.entity.Product;
import com.dily.mysql.entity.Student;
import com.dily.mysql.enums.GradeEnum;
import com.dily.mysql.repository.ProductRepo;
import com.dily.mysql.repository.StudentRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Method;
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
    @Test
    public void enumTest () throws JsonProcessingException {
        // 枚举转json
        Student student = new Student();
        student.setGrade(GradeEnum.HIGH);
        System.out.println(new ObjectMapper().writeValueAsString(student));

        List<Student> all = studentRepo.findAll();
        System.out.println(all.get(0));
    }

    @Test
    public void enumTest2 () throws JsonProcessingException {
//        System.out.println(GradeEnum.PRIMARY.toString());
//        // 枚举转json
        Product product = new Product();
//        product.setGrade(GradeEnum.PRIMARY);
        System.out.println(new ObjectMapper().writeValueAsString(product));
//        productRepo.save(product);

        List<Product> all = productRepo.findAll();
        System.out.println(all.get(0));
    }
}
