package com.dily.mysql.vo;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * PageImpl
 * Date: 2023-11-30 星期四
 * Time: 15:38
 * Author: Dily_Su
 * Remark: JPA 分页封装成统一 IPage
 */
@AllArgsConstructor
public class JpaPageImpl<T> implements AppPage<T> {
    private Page<T> page;

    @Override
    public long getPageNum() {
        if (page == null) return  0;
        return page.getNumber() + 1;
    }

    @Override
    public long getPageSize() {
        if (page == null ) return 0;
        return page.getSize();
    }

    @Override
    public long getTotal() {
        if (page == null ) return 0;
        return page.getTotalElements();
    }

    @Override
    public long getTotalPages() {
        if (page == null ) return 0;

        return page.getTotalPages();
    }

    @Override
    public List<T> getItems() {
        return page.getContent();
    }
}
