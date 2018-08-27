package com.renguangli.consumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service("ConsumerService")
public class ConsumerService {

    @Resource
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "addHystrix")
    public String add(String x, String y) {
        return restTemplate.getForObject("http://PROVIDER-SERVICE-ADD/add?x={x}&y={y}", String.class, x, y);
    }

    public String addHystrix(String x, String y) {
        return "PROVIDER-SERVICE-ADD has Exception";
    }
}
