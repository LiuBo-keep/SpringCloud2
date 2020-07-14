package com.hp.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName OrderConsulController
 * @Description TODO
 * @Author 17126
 * @Date 2020/7/14 22:12
 */
@RestController
@Slf4j
public class OrderConsulController {
    private static final String INVOKE_URL="http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;


    @GetMapping(value = "/consumer/payment/consul")
    public String paymentinfo(){

        String template = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        return template;
    }
}
