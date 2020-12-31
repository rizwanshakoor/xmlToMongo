package com.thesis.admin.xacmlserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class XacmlserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(XacmlserverApplication.class, args);
    }

}
