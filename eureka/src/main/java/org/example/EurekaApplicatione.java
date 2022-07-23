package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaApplicatione {

    public static void main(String[] args) {
        System.out.println("Hello Eureka!");
        SpringApplication.run(EurekaApplicatione.class, args);;
    }
}