package eurcka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Administrator
 * @Classname EurckaApp
 * @Description TODO
 * @Date 2020/10/8 10:10
 * @Created by Administrator
 */

@SpringBootApplication
@EnableEurekaServer
public class EurckaApp {
    public static void main(String[] args) {
        SpringApplication.run(EurckaApp.class, args);
    }
}
