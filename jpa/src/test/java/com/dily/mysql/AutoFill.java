package com.dily.mysql;

import com.dily.mysql.entity.*;
import com.dily.mysql.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * mysql
 * Date: 2023-11-29 星期三
 * Time: 11:14
 * Author: Dily_Su
 * Remark: 自动填充
 */
@SpringBootTest
public class AutoFill {
    @Autowired
    private ProductRepo productRepo;

    @Test
    public void baseEntity (){
        Product product = new Product();
        product.setName("测试产品");
        productRepo.save(product);
    }

}
