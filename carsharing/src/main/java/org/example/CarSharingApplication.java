package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CarSharingApplication {
    public static void main(String[] args) {
        System.out.println("Hello CarSharing!");
        SpringApplication.run(CarSharingApplication.class, args);
    }
}