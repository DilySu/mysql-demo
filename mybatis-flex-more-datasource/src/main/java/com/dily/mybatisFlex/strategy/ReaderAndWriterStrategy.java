package com.dily.mybatisFlex.strategy;

import com.mybatisflex.core.datasource.DataSourceShardingStrategy;
import com.mybatisflex.core.util.StringUtil;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * ReaderAndWriterStategy
 * Date: 2023-12-11 星期一
 * Time: 11:07
 * Author: Dily_Su
 * Remark: 读写分离策略
 */
@Slf4j
public class ReaderAndWriterStrategy implements DataSourceShardingStrategy {

    private static final String MASTER = "master";
    private static final String SLAVE = "slave*";
    @Override
    public String doSharding(String currentDataSourceKey, Object mapper, Method mapperMethod, Object[] methodArgs) {
        // 增删改 用 master
        if (StringUtil.startsWithAny(mapperMethod.getName(),"insert","delete","update")){
            log.info(MASTER);
            return MASTER;
        }

        // 其他场景使用 slave开头 的数据源进行负载均衡
        log.info(SLAVE);
        return SLAVE;
    }
}
