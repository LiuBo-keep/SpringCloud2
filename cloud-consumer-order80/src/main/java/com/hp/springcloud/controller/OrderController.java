package com.hp.springcloud.controller;

import com.hp.springcloud.entities.CommonResult;
import com.hp.springcloud.entities.PayMent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author 17126
 * @Date 2020/7/8 23:10
 */

@RestController
@Slf4j
public class OrderController {

    /**
     * 请求地址
     */
    private static final String PAYMENT_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<PayMent> create(PayMent payMent) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payMent, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<PayMent> getPayMentById(
            @PathVariable("id") Long id
    ){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
}
