package com.wfr.springcloud.server.two;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class ServerTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerTwoApplication.class, args);
    }


    @Value("${server.port}")
    private String port;

    @GetMapping("/hi")
    public String hi(@RequestParam(value = "name", defaultValue = "twoo",required = false) String name) {
        return "hello " + name + ", i'm server-two ,my port:" + port;

    }
}