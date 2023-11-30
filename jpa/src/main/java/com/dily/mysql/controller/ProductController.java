package com.dily.mysql.controller;

import com.dily.mysql.entity.Product;
import com.dily.mysql.entity.Student;
import com.dily.mysql.repository.ProductRepo;
import com.dily.mysql.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductRepo productRepo;
    @GetMapping("add")
    public void add (){
        productRepo.save(new Product());
    }

    @GetMapping("list")
    public List<Product> list(){
        return productRepo.findAll();
    }
}
