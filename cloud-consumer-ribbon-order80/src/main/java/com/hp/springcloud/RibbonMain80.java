package com.hp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName RibbonMain80
 * @Description TODO
 * @Author 17126
 * @Date 2020/7/18 16:24
 */

@SpringBootApplication
@EnableEurekaClient
public class RibbonMain80 {

    public static void main(String[] args) {
        SpringApplication.run(RibbonMain80.class,args);
    }
}
