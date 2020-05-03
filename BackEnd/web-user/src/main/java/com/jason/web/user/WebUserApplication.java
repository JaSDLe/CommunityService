package com.jason.web.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients({"com.jason.member.api", "com.jason.community.api"})
@EnableEurekaClient
@SpringBootApplication
public class WebUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebUserApplication.class, args);
    }

}
