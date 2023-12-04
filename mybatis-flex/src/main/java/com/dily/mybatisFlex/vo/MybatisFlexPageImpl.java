package com.dily.mybatisFlex.vo;

import com.mybatisflex.core.paginate.Page;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * PageImpl
 * Date: 2023-11-30 星期四
 * Time: 15:38
 * Author: Dily_Su
 * Remark: JPA 分页封装成统一 IPage
 */
@AllArgsConstructor
public class MybatisFlexPageImpl<T> implements AppPage<T> {
    private Page<T> page;

    @Override
    public long getPageNum() {
        if (page == null) return  0;
        return page.getPageNumber();
    }

    @Override
    public long getPageSize() {
        if (page == null ) return 0;
        return page.getPageSize();
    }

    @Override
    public long getTotal() {
        if (page == null ) return 0;
        return page.getTotalRow();
    }

    @Override
    public long getTotalPages() {
        if (page == null ) return 0;

        return page.getTotalPage();
    }

    @Override
    public List<T> getItems() {
        return page.getRecords();
    }
}
