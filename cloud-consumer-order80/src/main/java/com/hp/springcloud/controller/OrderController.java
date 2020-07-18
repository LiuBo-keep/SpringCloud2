package com.hp.springcloud.controller;

import com.hp.springcloud.entites.CommonResult;
import com.hp.springcloud.entites.PayMent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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
    //private static final String PAYMENT_URL = "http://localhost:8001";  //单机
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<PayMent> create(PayMent payMent) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payMent, CommonResult.class);
    }

    //getForObject请求返回对象为响应体中的数据转化成的对象，基本上可以理解为Json
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<PayMent> getPayMentById(
            @PathVariable("id") Long id
    ){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
//getForEntity请求返回对象为ResponseEntity对象，包含了响应体中的一些重要信息，比如响应头，响应状态码，响应体等
    @GetMapping(value = "/consumer/payment/getForEntity/{id}")
    public CommonResult<PayMent> getPayMentById2(
            @PathVariable("id") Long id
    ){
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);

        if (forEntity.getStatusCode().is2xxSuccessful()){
            log.info(forEntity.getStatusCode().toString());
            return forEntity.getBody();
        }else {
            return new CommonResult<>(444,"请求失败");
        }
    }
}
