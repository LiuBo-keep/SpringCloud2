package config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Administrator
 * @Classname ConfigApp
 * @Description TODO
 * @Date 2020/10/8 10:24
 * @Created by Administrator
 */

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigApp {

    public static void main(String[] args) {

        SpringApplication.run(ConfigApp.class,args);
    }
}
