package com.dily.jpa;

import com.dily.jpa.entity.Product;
import com.dily.jpa.repository.ProductRepo;
import com.dily.mysql.entity.*;
import com.dily.mysql.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
