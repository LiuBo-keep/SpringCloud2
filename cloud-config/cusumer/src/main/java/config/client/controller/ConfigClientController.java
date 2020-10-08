package config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @Classname ConfigClientController
 * @Description TODO
 * @Date 2020/10/8 13:41
 * @Created by Administrator
 */

@RestController
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configinfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
