package com.dily.mybatisPlus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dily.mybatisPlus.entity.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * ProductRepo
 * Date: 2023-11-29 星期三
 * Time: 15:22
 * Author: Dily_Su
 * Remark:
 */
@Mapper
public interface ProductRepo extends BaseMapper<Product> {
}
