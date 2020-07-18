package com.hp.springcloud.controller;

import com.hp.springcloud.entites.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName ConsumerController
 * @Description TODO
 * @Author 17126
 * @Date 2020/7/18 16:26
 */

@RestController
@Slf4j
public class ConsumerController {

    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";


    @Resource
    private RestTemplate restTemplate;


    @GetMapping(value = "/consumer/payment/{id}")
    public CommonResult getById(
            @PathVariable("id") Long id
    ){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
}
