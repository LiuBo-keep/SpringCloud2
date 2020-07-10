package com.hp.springcloud.controller;

import com.hp.springcloud.entities.CommonResult;
import com.hp.springcloud.entities.PayMent;
import com.hp.springcloud.service.PayMentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName PayMentController
 * @Description TODO
 * @Author 17126
 * @Date 2020/7/7 23:53
 */

@RestController
@Slf4j
public class PayMentController {

    @Resource
    private PayMentService payMentService;

    /**
     * 创建该类的日志对象但使用注解@Slf4j效果一样
     * 推荐使用注解@Slf4j
     */
    //Logger log=LoggerFactory.getLogger(PayMentController.class);

    @PostMapping(value = "/payment/create")
    public CommonResult create(
            @RequestBody PayMent payMent
    ) {
        int result = payMentService.create(payMent);
        log.info("*****插入结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "插入数据库成功", result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<PayMent> getPayMentById(
            @PathVariable("id") Long id) {
        PayMent payment = payMentService.getPaymentById(id);
        log.info("*****返回结果：" + payment);

        if (null != payment) {
            return new CommonResult(200, "查询成功", payment);
        } else {
            return new CommonResult(444, "查询失败，查询ID："+id, null);
        }
    }
}
