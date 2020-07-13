package com.hp.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ClassName PayMentController
 * @Description TODO
 * @Author 17126
 * @Date 2020/7/13 21:22
 */

@RestController
@Slf4j
public class PayMentController {

    @Value("${server.port}")
    private String serverport;

    @RequestMapping(value = "/payment/zk")
    public String paymentzk(){
        return "springcloud with zookeeper："+serverport+"\t"+UUID.randomUUID().toString();
    }
}
