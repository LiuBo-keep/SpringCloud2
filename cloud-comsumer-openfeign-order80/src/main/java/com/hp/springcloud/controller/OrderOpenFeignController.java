package com.hp.springcloud.controller;

import com.hp.springcloud.entites.CommonResult;
import com.hp.springcloud.service.PayMentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName OrderOpenFeignController
 * @Description TODO
 * @Author 17126
 * @Date 2020/7/19 11:51
 */

@RestController
public class OrderOpenFeignController {

    @Resource
    private PayMentService payMentService;


    @GetMapping(value = "/comsumer/payment/get/{id}")
    public CommonResult getById(@PathVariable("id") Long id){
        return payMentService.getPaymentById(id);
    }
}
