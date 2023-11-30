package com.dily.mysql.repository;

import com.dily.mysql.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ProductRepo
 * Date: 2023-11-29 星期三
 * Time: 15:22
 * Author: Dily_Su
 * Remark:
 */
@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
}
