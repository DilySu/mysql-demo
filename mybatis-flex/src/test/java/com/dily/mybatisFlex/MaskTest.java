package com.dily.mybatisFlex;

import com.dily.mybatisFlex.entity.Product;
import com.dily.mybatisFlex.entity.Student;
import com.dily.mybatisFlex.mapper.ProductMapper;
import com.dily.mybatisFlex.mapper.StudentMapper;
import com.mybatisflex.core.mask.MaskManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * DesensitizationTest
 * Date: 2023-12-04 星期一
 * Time: 9:34
 * Author: Dily_Su
 * Remark: 数据脱敏测试
 */
@SpringBootTest
public class MaskTest {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ProductMapper productMapper;

    @Test // 加密
    public void mask (){
        System.out.println(studentMapper.selectAll());
    }

    @Test // 取消脱敏
    public void unMask (){
        // 方式一
//        List<Student> students = MaskManager.execWithoutMask(studentMapper::selectAll);
//        System.out.println(students);
        // 方式二
        try {
            MaskManager.skipMask();
            //此处查询到的数据不会进行脱敏处理
            List<Student> students1 = studentMapper.selectAll();
            System.out.println(students1);
        } finally {
            MaskManager.restoreMask();
        }
    }

    @Test // 自定义脱敏
    public void testMask (){
        List<Product> products = productMapper.selectAll();
        System.out.println(products);
    }
}
