package com.jason.csservicemember;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CsServiceMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsServiceMemberApplication.class, args);
    }

}
