package com.dily.mybatisPlus.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * PageImpl
 * Date: 2023-11-30 星期四
 * Time: 15:34
 * Author: Dily_Su
 * Remark:
 */
@AllArgsConstructor
public class MybatisPlusPageImpl<T> implements AppPage<T> {
    private IPage<T> iPage;

    @Override
    public long getPageNum() {
        return iPage.getCurrent();
    }

    @Override
    public long getPageSize() {
        return iPage.getSize();
    }

    @Override
    public long getTotal() {
        return iPage.getTotal();
    }

    @Override
    public long getTotalPages() {
        return iPage.getPages();
    }

    @Override
    public List<T> getItems() {
        return iPage.getRecords();
    }
}
