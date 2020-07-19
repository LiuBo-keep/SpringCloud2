package com.hp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName OrderOpenFeignMain80
 * @Description TODO
 * @Author 17126
 * @Date 2020/7/19 10:00
 */

@SpringBootApplication
@EnableFeignClients
public class OrderOpenFeignMain80 {

    public static void main(String[] args) {

        SpringApplication.run(OrderOpenFeignMain80.class,args);
    }
}
