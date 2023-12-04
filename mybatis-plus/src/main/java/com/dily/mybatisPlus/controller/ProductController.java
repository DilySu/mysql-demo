package com.dily.mybatisPlus.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dily.mybatisPlus.mapper.ProductRepo;
import com.dily.mybatisPlus.entity.Product;
import com.dily.mybatisPlus.service.ProductService;
import com.dily.mybatisPlus.vo.MybatisPlusPageImpl;
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
    @Autowired
    private ProductService productService;

    @GetMapping
    public void add() {
        productRepo.insert(new Product());
    }

    @GetMapping("list")
    public List<Product> list() {
        return productRepo.selectList(Wrappers.emptyWrapper());
    }

    @GetMapping("page")
    public MybatisPlusPageImpl<Product> page() {
        Page<Product> productPage = new Page<>(1, 2);
        IPage<Product> page = productRepo.selectPage(productPage, null);
        return new MybatisPlusPageImpl<>(page);
    }
}
