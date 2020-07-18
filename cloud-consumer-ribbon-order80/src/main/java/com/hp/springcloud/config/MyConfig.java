package com.hp.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName MyConfig
 * @Description TODO
 * @Author 17126
 * @Date 2020/7/18 16:36
 */

@Configuration
public class MyConfig
{

    @Bean
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }
}
