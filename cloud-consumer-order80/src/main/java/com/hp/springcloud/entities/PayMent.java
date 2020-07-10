package com.hp.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName PayMent
 * @Description TODO
 * @Author 17126
 * @Date 2020/7/8 23:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayMent implements Serializable {

    private Long id;
    private String serial;
}
