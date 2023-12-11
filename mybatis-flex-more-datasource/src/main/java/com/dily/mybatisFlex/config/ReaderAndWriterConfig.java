package com.dily.mybatisFlex.config;

import com.dily.mybatisFlex.strategy.ReaderAndWriterStrategy;
import com.mybatisflex.core.datasource.DataSourceManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MoreSourceConfig
 * Date: 2023-12-11 星期一
 * Time: 9:25
 * Author: Dily_Su
 * Remark: 读写分离配置
 */
@Configuration
public class ReaderAndWriterConfig {
    @Bean
    public DataSourceManager dataSourceManager(){
        DataSourceManager dataSourceManager = new DataSourceManager();
        dataSourceManager.setDataSourceShardingStrategy(new ReaderAndWriterStrategy());
        return dataSourceManager;
    }
}
