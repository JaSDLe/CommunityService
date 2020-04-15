package com.jason.cseurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CsEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsEurekaServerApplication.class, args);
    }

}
