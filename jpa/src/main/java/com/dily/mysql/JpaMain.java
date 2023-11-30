package com.dily.mysql;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

/**
 * ${NAME}
 * Date: 2023-11-29 星期三
 * Time: 10:18
 * Author: Dily_Su
 * Remark:
 */
@EnableJpaAuditing
@SpringBootApplication
public class JpaMain {
    public static void main(String[] args) {
        SpringApplication.run(JpaMain.class,args);
    }
}