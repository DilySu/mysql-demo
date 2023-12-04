package com.dily.jpa.controller;

import com.dily.jpa.repository.ProductRepo;
import com.dily.jpa.entity.Product;
import com.dily.jpa.vo.JpaPageImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @GetMapping("page")
    public  JpaPageImpl<Product> page (){
        PageRequest pageRequest = PageRequest.of(0,2);
        Page<Product> all = productRepo.findAll(pageRequest);
        return new JpaPageImpl<>(all);
    }
}
