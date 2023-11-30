package com.dily.mysql.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dily.mysql.entity.Product;
import com.dily.mysql.repository.ProductRepo;
import org.springframework.stereotype.Service;

/**
 * ProductService
 * Date: 2023-11-30 星期四
 * Time: 15:59
 * Author: Dily_Su
 * Remark:
 */
@Service
public class ProductService extends ServiceImpl<ProductRepo, Product> {

}
