package com.dily.mybatisFlex.controller;

import com.dily.mybatisFlex.entity.Product;
import com.dily.mybatisFlex.enums.GradeEnum;
import com.dily.mybatisFlex.mapper.ProductMapper;
import jakarta.annotation.Resource;
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

    @Resource
    private ProductMapper productRepo;
    @GetMapping("add")
    public int add (){
        Product product = new Product();
        product.setGrade(GradeEnum.HIGH);
        return productRepo.insert(product);
    }

    @GetMapping("list")
    public List<Product> list(){
        return productRepo.selectAll();
    }

}
