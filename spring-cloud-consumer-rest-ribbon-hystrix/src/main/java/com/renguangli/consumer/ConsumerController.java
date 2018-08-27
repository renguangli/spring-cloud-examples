package com.renguangli.consumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    @Resource
    public ConsumerService consumerService;


    @GetMapping("/add")
    public String add(String x, String y) {
        return consumerService.add(x, y);
    }

}
