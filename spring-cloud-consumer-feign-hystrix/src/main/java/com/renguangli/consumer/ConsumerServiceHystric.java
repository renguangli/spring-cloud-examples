package com.renguangli.consumer;

import org.springframework.stereotype.Component;

@Component
public class ConsumerServiceHystric implements ConsumerService{

    @Override
    public String add(String x, String y) {
        return "hello world";
    }
}
