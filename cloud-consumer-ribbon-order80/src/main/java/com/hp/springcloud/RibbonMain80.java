package com.hp.springcloud;

import com.hp.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @ClassName RibbonMain80
 * @Description TODO
 * @Author 17126
 * @Date 2020/7/18 16:24
 *
 * 在启动该微服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效。
 * @RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
 * 当调用CLOUD-PAYMENT-SERVICE这个服务时，使用我们自己定制的负载均衡算法
 */


@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class RibbonMain80 {

    public static void main(String[] args) {
        SpringApplication.run(RibbonMain80.class,args);
    }
}
