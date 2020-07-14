package com.hp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName PayMentMain8006
 * @Description TODO
 * @Author 17126
 * @Date 2020/7/14 21:49
 */

@SpringBootApplication
@EnableDiscoveryClient
public class PayMentMain8006 {

    public static void main(String[] args) {
        SpringApplication.run(PayMentMain8006.class,args);
    }
}
