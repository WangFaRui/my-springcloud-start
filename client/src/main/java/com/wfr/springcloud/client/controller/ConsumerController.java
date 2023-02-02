package com.wfr.springcloud.client.controller;

import com.wfr.springcloud.client.feign.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private ProviderClient providerClient;

    @GetMapping("/hi-feign")
    public String hiFeign() {
        return providerClient.hi("feign");
    }

    @GetMapping("/inner/hi-feign")
    public String innerHiFeign() {
        return providerClient.hi("feign");
    }
}