package com.hp.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName PayMentMain8004
 * @Description TODO
 * @Author 17126
 * @Date 2020/7/13 21:17
 */

@SpringBootApplication
@EnableDiscoveryClient //该注解用于使用consul或者zookeeper作为注册中心时注册服务
public class PayMentMain8004 {

    public static void main(String[] args) {
        SpringApplication.run(PayMentMain8004.class,args);
    }
}
