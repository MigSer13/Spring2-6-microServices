package com.myhomeDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = {"test"} , exclude = JpaRepositoriesAutoConfiguration.class)
//@SpringBootApplication
@EnableEurekaClient
public class AppDB {
    public static void main(String[] args) {
        SpringApplication.run(AppDB.class, args);
    }
}
