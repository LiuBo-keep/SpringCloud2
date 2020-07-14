package com.hp.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ClassName PaymentController
 * @Description TODO
 * @Author 17126
 * @Date 2020/7/14 21:50
 */

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverport;

    @RequestMapping(value = "/payment/consul")
    public String paymentConsul()
    {
        return "springcloud with zookeeper："+serverport+"\t"+UUID.randomUUID().toString();
    }

}
