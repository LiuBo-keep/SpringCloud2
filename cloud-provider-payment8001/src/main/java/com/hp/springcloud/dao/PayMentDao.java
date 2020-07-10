package com.hp.springcloud.dao;

import com.hp.springcloud.entites.PayMent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName PayMentDao
 * @Description TODO
 * @Author 17126
 * @Date 2020/7/7 23:26
 */

@Mapper
public interface PayMentDao {

    /**
     * 添加
     */
    public int create(PayMent payMent);

    /**
     * 读取
     */
    public PayMent getPaymentById(@Param("id") Long id);
}
