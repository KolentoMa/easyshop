package com.easyshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//启用openFeign
@EnableFeignClients
public class AppOperator {
    public static void main(String[] args) {
        SpringApplication.run(AppOperator.class,args);
    }
}
