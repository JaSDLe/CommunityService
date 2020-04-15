package com.jason.csservicemessage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CsServiceMessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsServiceMessageApplication.class, args);
    }

}
