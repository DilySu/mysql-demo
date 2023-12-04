package com.dily.mybatisPlus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * AutoFillHandler
 * Date: 2023-11-30 星期四
 * Time: 14:57
 * Author: Dily_Su
 * Remark: Mybatis Plus 自动填充处理类
 */
@Slf4j
@Component // 不使用@Component，也可在 config 中，将该类注册为 Bean
public class AutoFillHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("created log");
        String username = "测试";
        // createBy 为 当前用户名
        this.setFieldValByName("createdBy", username, metaObject);
        // createTime 为 当前时间
        this.strictInsertFill(metaObject, "createdTime", LocalDateTime::now, LocalDateTime.class); // 起始版本 3.3.3(推荐)
        // updateBy 为 当前用户名
        this.setFieldValByName("updatedBy", username, metaObject);
        // updateTime 为 当前时间
        this.strictInsertFill(metaObject, "updatedTime", LocalDateTime::now, LocalDateTime.class); // 起始版本 3.3.3(推荐)
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("updated log");
        String username = "测试";
        // updateBy 为 当前用户名
        this.setFieldValByName("updatedBy", username, metaObject);
        // updateTime 为 当前时间
        this.strictUpdateFill(metaObject, "updatedTime", LocalDateTime::now, LocalDateTime.class); // 起始版本 3.3.3(推荐)
    }
}
