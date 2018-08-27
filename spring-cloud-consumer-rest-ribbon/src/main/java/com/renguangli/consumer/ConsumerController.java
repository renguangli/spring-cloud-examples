package com.renguangli.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    @Resource
    public RestTemplate restTemplate;

    @Value("${service-name}")
    private String serviceName;

    @GetMapping("/add")
    public String add(String x, String y) {
        return restTemplate.getForObject("http://" + serviceName + "/add?x={x}&y={y}", String.class, x, y);
    }

}
