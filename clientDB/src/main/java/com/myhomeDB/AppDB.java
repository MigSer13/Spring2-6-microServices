package com.myhomeDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.autoconfigure.ConfigurationPropertiesRebinderAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@SpringBootApplication(scanBasePackages = {"test"} , exclude = ConfigurationPropertiesRebinderAutoConfiguration.class)
@SpringBootApplication
@EnableEurekaClient
public class AppDB {
    public static void main(String[] args) {
        SpringApplication.run(AppDB.class, args);
    }
}
