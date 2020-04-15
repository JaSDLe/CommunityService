package com.jason.csserviceactivity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CsServiceActivityApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsServiceActivityApplication.class, args);
    }

}
