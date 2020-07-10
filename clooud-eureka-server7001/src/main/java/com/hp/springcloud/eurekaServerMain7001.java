package com.hp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName eurekaServerMain7001
 * @Description TODO
 * @Author 17126
 * @Date 2020/7/10 22:50
 */

@SpringBootApplication
@EnableEurekaServer
public class eurekaServerMain7001 {

    public static void main(String[] args) {
        SpringApplication.run(eurekaServerMain7001.class,args);
    }
}
