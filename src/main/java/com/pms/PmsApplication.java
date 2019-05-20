package com.pms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PmsApplication {

    public static void main(String[] args) {

        SpringApplication.run(PmsApplication.class, args);
    }

}
