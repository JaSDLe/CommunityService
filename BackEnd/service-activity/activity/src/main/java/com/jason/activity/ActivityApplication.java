package com.jason.activity;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@MapperScan("com.jason.activity.dao.mapper")
@EnableEurekaClient
@SpringBootApplication
public class ActivityApplication {

    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }

    public static void main(String[] args) {
        SpringApplication.run(ActivityApplication.class, args);
    }

}
