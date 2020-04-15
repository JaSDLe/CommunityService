package com.jason.csservicecommunity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CsServiceCommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsServiceCommunityApplication.class, args);
    }

}
