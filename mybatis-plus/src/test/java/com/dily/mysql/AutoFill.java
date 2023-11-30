package com.dily.mysql;

import com.dily.mysql.entity.Product;
import com.dily.mysql.repository.ProductRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * AutoFill
 * Date: 2023-11-30 星期四
 * Time: 14:55
 * Author: Dily_Su
 * Remark:
 */
@SpringBootTest
public class AutoFill {

    @Autowired
    private ProductRepo productRepo;
    @Test
    public void save (){
        productRepo.insert(new Product());
    }
}
