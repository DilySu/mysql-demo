package com.dily.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * AutoFillConfig
 * Date: 2023-11-29 星期三
 * Time: 15:40
 * Author: Dily_Su
 * Remark: 自动填充配置
 */
@Configuration
public class AutoFillConfig {
    @Bean
    public AuditorAware<String> auditorAware() {
        AuditorAware<String> aa = () -> {
            // TODO 获取当前用户名
            String username = "测试";
            return Optional.of(username);
        };
        return aa;
    }
}
