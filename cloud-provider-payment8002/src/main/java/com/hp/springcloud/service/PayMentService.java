package com.hp.springcloud.service;

import com.hp.springcloud.entites.PayMent;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName PayMentService
 * @Description TODO
 * @Author 17126
 * @Date 2020/7/7 23:30
 */
public interface PayMentService {
    /**
     * 添加
     */
    public int create(PayMent payMent);

    /**
     * 读取
     */
    public PayMent getPaymentById(@Param("id") Long id);
}
