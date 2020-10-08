package config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Classname ClientApp
 * @Description TODO
 * @Date 2020/10/8 13:38
 * @Created by Administrator
 */
@EnableEurekaClient
@SpringBootApplication
public class ClientApp {

    public static void main(String[] args) {
        SpringApplication.run(ClientApp.class,args);
    }
}
