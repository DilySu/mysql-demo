package com.dily.mybatisFlex.mapper;

import com.dily.mybatisFlex.entity.Product;
import com.mybatisflex.annotation.UseDataSource;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ProductRepo
 * Date: 2023-11-29 星期三
 * Time: 15:22
 * Author: Dily_Su
 * Remark:
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
    @UseDataSource("master")
    @Select("select * from t_product")
    List<Product> findAll();
}
