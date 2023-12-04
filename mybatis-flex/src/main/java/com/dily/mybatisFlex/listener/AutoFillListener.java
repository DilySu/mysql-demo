package com.dily.mybatisFlex.listener;

import com.dily.mybatisFlex.entity.BaseEntity;
import com.mybatisflex.annotation.InsertListener;
import com.mybatisflex.annotation.UpdateListener;

import java.util.Date;

/**
 * AutoFillListener
 * Date: 2023-12-04 星期一
 * Time: 8:38
 * Author: Dily_Su
 * Remark:
 */
public class AutoFillListener implements InsertListener, UpdateListener {
    @Override
    public void onInsert(Object o) {
        BaseEntity baseEntity = (BaseEntity) o;
        // TODO 获取当前用户
        String username = "测试用户";
        Date now = new Date();
        baseEntity.setCreatedBy(username);
        baseEntity.setCreatedTime(now);
        baseEntity.setUpdatedBy(username);
        baseEntity.setUpdatedTime(now);
    }

    @Override
    public void onUpdate(Object o) {
        BaseEntity baseEntity = (BaseEntity) o;
        // TODO 获取当前用户
        String username = "测试用户";
        Date now = new Date();
        baseEntity.setUpdatedBy(username);
        baseEntity.setUpdatedTime(now);
    }
}
