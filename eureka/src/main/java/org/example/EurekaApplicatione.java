package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
//@EnableEurekaServer 설정 하여 유레카 서버임을 알려준다
@SpringBootApplication
public class EurekaApplicatione {

    public static void main(String[] args) {
        System.out.println("Hello Eureka!");
        SpringApplication.run(EurekaApplicatione.class, args);
    }
}