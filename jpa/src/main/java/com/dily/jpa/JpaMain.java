package com.dily.jpa;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

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