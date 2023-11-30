package com.dily.mysql.enums;

/**
 * BaseEnum
 * Date: 2023-11-29 星期三
 * Time: 16:26
 * Author: Dily_Su
 * Remark: 通用枚举接口
 */
public interface BaseEnum<V> {
    // 用于显示的枚举名称
    String getName();
    // 数据库存储数值
    V getCode();
}
