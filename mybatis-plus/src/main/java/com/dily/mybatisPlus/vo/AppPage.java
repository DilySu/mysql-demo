package com.dily.mybatisPlus.vo;

import java.util.List;

/**
 * IPage
 * Date: 2023-11-30 星期四
 * Time: 15:31
 * Author: Dily_Su
 * Remark:
 */
public interface AppPage<T> {

    /**
     * 当前页页码
     */
    long getPageNum();

    /**
     * 每页条数
     */
    long getPageSize();

    /**
     * 总条数
     */
    long getTotal();

    /**
     * 总页数
     */
    long getTotalPages();

    /**
     * 分页对象记录
     */
    List<T> getItems();
}
