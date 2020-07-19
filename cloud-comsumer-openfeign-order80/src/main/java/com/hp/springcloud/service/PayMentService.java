package com.hp.springcloud.service;

import com.hp.springcloud.entites.CommonResult;
import com.hp.springcloud.entites.PayMent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName PayMentService
 * @Description TODO
 * @Author 17126
 * @Date 2020/7/19 11:26
 */

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PayMentService {
    /**
     * 读取
     */
    @GetMapping(value = "/payment/get/{id}")
     CommonResult<PayMent> getPaymentById(@PathVariable("id") Long id);
}
