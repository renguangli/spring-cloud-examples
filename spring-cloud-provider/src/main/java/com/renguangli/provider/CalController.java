package com.renguangli.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalController {

    @GetMapping("/add")
    public String add(@Value("${server.port}") String port, String x, String y) {
        return "x+y=" + x + y + "," + "the port is " + port;
    }

    @GetMapping("/hello")
    public String hello(@Value("${hello}") String hello) {
        return hello;
    }
}
