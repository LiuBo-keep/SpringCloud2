package com.hp.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ApplicationContextConfig
 * @Description TODO
 * @Author 17126
 * @Date 2020/7/8 23:14
 */

@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced  //通过这个注解让RestTemplate拥有负载均衡的功能
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
