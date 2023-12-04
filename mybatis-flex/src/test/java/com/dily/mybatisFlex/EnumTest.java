package com.dily.mybatisFlex;

import com.dily.mybatisFlex.entity.Product;
import com.dily.mybatisFlex.entity.Student;
import com.dily.mybatisFlex.enums.GradeEnum;
import com.dily.mybatisFlex.mapper.ProductMapper;
import com.dily.mybatisFlex.mapper.StudentMapper;
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
 * Remark: 枚举测试
 */
@SpringBootTest
public class EnumTest {
    @Autowired
    private ProductMapper productRepo;
    @Test // 枚举转json
    public void enum2Json () throws JsonProcessingException {
        Student student = new Student();
        student.setGrade(GradeEnum.HIGH);
        System.out.println(new ObjectMapper().writeValueAsString(student));
    }

    @Test
    public void db2Enum () {
        List<Product> all = productRepo.selectAll();
        System.out.println(all.get(0));
    }

    @Test
    public void enum2Db (){
        Product product = new Product();
        product.setGrade(GradeEnum.PRIMARY);
        productRepo.insert(product);
    }
}
