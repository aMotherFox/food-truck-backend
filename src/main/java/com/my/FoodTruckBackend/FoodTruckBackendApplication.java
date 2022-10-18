package com.my.FoodTruckBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class FoodTruckBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodTruckBackendApplication.class, args);
    }
}
