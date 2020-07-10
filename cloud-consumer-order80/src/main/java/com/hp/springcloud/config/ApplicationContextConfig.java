package com.hp.springcloud.config;

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
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
