package com.hp.springcloud.service.impl;

import com.hp.springcloud.dao.PayMentDao;
import com.hp.springcloud.entites.PayMent;
import com.hp.springcloud.service.PayMentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName PayMentServiceIpl
 * @Description TODO
 * @Author 17126
 * @Date 2020/7/7 23:48
 */

@Service
public class PayMentServiceIpl implements PayMentService {

    /**
     * @Resource与@Autowrute功能一样都可以自动注入 前者是java自带的
     * 后者是spring中的
     */
    @Resource
    private PayMentDao payMentDao;

    @Override
    public int create(PayMent payMent) {
        return payMentDao.create(payMent);
    }

    @Override
    public PayMent getPaymentById(Long id) {
        return payMentDao.getPaymentById(id);
    }
}
