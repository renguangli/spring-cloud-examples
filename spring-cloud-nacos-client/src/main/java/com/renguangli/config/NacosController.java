package com.renguangli.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * spring-cloud-nacos-client
 * Created by renguangli at 2018/12/24 10:04
 *
 * @since JDK1.8
 */
@RefreshScope // 配置中心修改配置时是否自动刷新配置
@RestController
public class NacosController {

    private final RestTemplate restTemplate;

    @Value("${server.port}")
    private int port;

    @Value("${app:hello}")
    private String app;

    @Autowired
    public NacosController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/hello")
    public String hi() {
        return app + restTemplate.getForObject("http://service-provider/port", String.class);
    }

    @GetMapping("/port")
    public int port() {
        return port;
    }
}
