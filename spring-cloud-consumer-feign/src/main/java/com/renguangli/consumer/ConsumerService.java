package com.renguangli.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "PROVIDER-SERVICE-ADD")
public interface ConsumerService {

    @GetMapping("/add")
    String add(@RequestParam(value = "x") String x, @RequestParam(value = "y")String y);
}
