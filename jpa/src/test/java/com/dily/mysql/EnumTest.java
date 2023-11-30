package com.dily.mysql;

import com.dily.mysql.entity.Product;
import com.dily.mysql.entity.Student;
import com.dily.mysql.enums.GradeEnum;
import com.dily.mysql.repository.ProductRepo;
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
    private ProductRepo productRepo;
    @Test // 枚举转json
    public void enumTest () throws JsonProcessingException {
        Student student = new Student();
        student.setGrade(GradeEnum.HIGH);
        System.out.println(new ObjectMapper().writeValueAsString(student));
    }

    @Test
    public void enum2Db () {
        Product product = new Product();
        product.setGrade(GradeEnum.PRIMARY);
        productRepo.save(product);
    }

    @Test
    public void db2Enum (){
        List<Product> all = productRepo.findAll();
        System.out.println(all.get(0));
    }
}
