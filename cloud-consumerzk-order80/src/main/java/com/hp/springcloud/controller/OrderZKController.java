package com.hp.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName OrderZKController
 * @Description TODO
 * @Author 17126
 * @Date 2020/7/13 22:14
 */

@RestController
@Slf4j
public class OrderZKController {

    private static final String INVOKE_URL="http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;


    @GetMapping(value = "/consumer/payment/zk")
    public String paymentinfo(){

        String template = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return template;
    }
}
